package kr.co.blueauction.member.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.blueauction.bid.service.BidService;
import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.PageMaker;
import kr.co.blueauction.common.domain.PageMaker2;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.login.LoginDTO;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.member.service.MemberService;
import kr.co.blueauction.note.domain.Note;
import kr.co.blueauction.note.service.NoteService;
import kr.co.blueauction.order.service.OrderService;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;

/**
 * 경매 리스트를 위한 ProductController 
 *
 * @author 김봉환
 * @author 박성준
 * 
 * @since 2017. 11. 13.
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Inject
	private MemberService service;
	@Inject
	private JavaMailSender mailSender;
	@Inject
	private ProductService productService;
	@Inject
	private OrderService orderService;
	@Inject
	private NoteService noteService;
	@Inject
	private BidService bidservice;

	
	/**
	 * 로그인 페이지로 이동
	 * @param req HttpServletRequest(로그인세션얻어옴)
	 * @return 페이지이동
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("login");

		if (obj != null) {
			return "redirect:/";
		} else {
		}
		return "/login";
	}
	/**
	 * 로그인 처리 POST
	 * @param dto 로그인정보
	 * @param session session
	 * @param model model
	 * @throws Exception
	 */
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		Member vo = service.login(dto);
		if (vo == null) {
			return;
		}
		model.addAttribute("member", vo);

		if (dto.isUseCookie()) {
			System.out.println("dto.isusecookie()");
			int amount = 60 * 60 * 24 * 7;
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
			service.keepLogin(vo.getMemberId(), session.getId(), sessionLimit);
		}
	}

	
	/**
	 * 로그아웃을위한 GET
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout() throws Exception {
	}

	/**
	 * 마이페이지이동 GET
	 * @param member
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypageGET(@ModelAttribute("member") Member member, HttpSession session, Model model) {
		Object obj = session.getAttribute("login");
		member = (Member) obj;
		model.addAttribute("member", member);
		return "/member/mypage";
	}



	/**
	 * 회원가입페이지 이동
	 * @param member
	 * @param session
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void memberRegistGET() {
	}

	/**
	 * 회원가입처리를위한 POST
	 * @param member
	 * @param session
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String memberRegistPOST(@ModelAttribute("member") Member member, HttpSession session,
			HttpServletRequest request) throws Exception {
		service.insertMember(member);
		return "redirect:/";
	}

	/**
	 * 아이디 중복확인
	 * @param req HttpServletRequest
	 * @param res HttpServletResponse
	 * @throws Exception
	 */
	@RequestMapping(value = "/memberCheck")
	public void checkId(HttpServletRequest req, HttpServletResponse res) throws Exception {
		PrintWriter out = res.getWriter();
		try {
			String paramId = (req.getParameter("memberId") == null) ? "" : String.valueOf(req.getParameter("memberId"));
			Member chkmemer = new Member();
			chkmemer = service.idCheck(paramId.trim());
			out.print(chkmemer);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			out.print("1");
		}
	}

	/**
	 * 이메일중복확인
	 * @param req
	 * @param res
	 * @throws Exception
	 */
	@RequestMapping(value = "/memberEmailCheck")
	public void checkEmail(HttpServletRequest req, HttpServletResponse res) throws Exception {
		PrintWriter out = res.getWriter();
		try {
			String paramemail = (req.getParameter("email") == null) ? "" : String.valueOf(req.getParameter("email"));
			Member chkmemer = new Member();
			chkmemer = service.emailCheck(paramemail.trim());
			out.print(chkmemer);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			out.print("1");
		}
	}

	/**
	 * 이메일 인증을위한 POST
	 * @param req
	 * @param res
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/emailAuthenCheck", method = RequestMethod.POST)
	public void checkEmailAuthenCheck(HttpServletRequest req, HttpServletResponse res, HttpSession session)
			throws Exception {

		session.removeAttribute("uid");
		String frommail = "rlaqhdghks444@gmail.com";
		String title = "BLUE Aution 메일 인증 입니다";
		String paramemail = (req.getParameter("email") == null) ? "" : String.valueOf(req.getParameter("email"));

		UUID uuid = UUID.randomUUID();
		String uid = String.valueOf(uuid);

		session.setAttribute("uid", uid);

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
		messageHelper.setFrom(frommail);
		messageHelper.setTo(paramemail);
		messageHelper.setSubject(title);
		messageHelper.setText(uid);

		mailSender.send(message);
	}

	/**
	 * UID 확인을위한 POST
	 * @param req
	 * @param res
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/uidCheck", method = RequestMethod.POST)
	public void uidCheck(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {
		PrintWriter out = res.getWriter();
		String paramuid = (req.getParameter("uid") == null) ? "" : String.valueOf(req.getParameter("uid"));

		if (String.valueOf(session.getAttribute("uid")).equals(paramuid)) {
			out.print("1");

		} else {
			out.print("2");
		}
		out.flush();
		out.close();
	}

	/**
	 * 해당아이디에 중고판매리스트로 이동
	 * @param cri
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mypage/goodsmarket", method = RequestMethod.GET)
	public String goodsmarket(@ModelAttribute("cri") Criteria cri, HttpSession session, Model model)
			throws Exception {
		Object member = session.getAttribute("login");
		Member member1 = (Member) member;
		String memberId = member1.getMemberId();
		String auctionFlag = "N";
		model.addAttribute("products", productService.productSellListCriteria(cri, memberId, auctionFlag).get("products"));
		PageMaker2 pageMaker2 = new PageMaker2();
		pageMaker2.setCri(cri);
		pageMaker2.setTotalCount(productService.listCountCriteria(memberId,auctionFlag));
		model.addAttribute("pageMaker", pageMaker2);
		return "member/productsmarket";
	}


	/**
	 * 해당아이디에 옥션판매리스트로 이동
	 * @param cri
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mypage/auctionmarket", method = RequestMethod.GET)
	public String auctionmarket(@ModelAttribute("cri") Criteria cri, HttpSession session, Model model)
			throws Exception {
		Object member = session.getAttribute("login");
		Member member1 = (Member) member;
		String memberId = member1.getMemberId();
		String auctionFlag = "Y";
		model.addAttribute("products", productService.productSellListCriteria(cri, memberId, auctionFlag).get("products"));
		
		PageMaker2 pageMaker2 = new PageMaker2();
		pageMaker2.setCri(cri);
		pageMaker2.setTotalCount(productService.listCountCriteria(memberId, auctionFlag));
		model.addAttribute("pageMaker", pageMaker2);
		return "member/auctionmarket";
	}

	/**
	 * 해당아이디에 note리스트로 이동
	 * @param cri
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mypage/note/list", method = RequestMethod.GET)
	public String noteList(@ModelAttribute("cri") Criteria cri, HttpSession session, Model model)
			throws Exception {
		Object member = session.getAttribute("login");
		Member member1 = (Member) member;

		if (cri.getKeyword() == null) {
			cri.setKeyword("R");
		}

		String memberId = member1.getMemberId();
		List<Note> notelist = noteService.listByCri(cri, memberId);
		model.addAttribute("list", notelist);

		PageMaker2 pageMaker = new PageMaker2();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(noteService.listCountCriteria(cri, memberId));
		model.addAttribute("pageMaker", pageMaker);

		return "member/noteList";
	}
	
	/**
	 * @param page
	 * @param perPageNum
	 * @param keyword
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 * 받은편지함, 보낸편지함 조회시
	 */
	@RequestMapping(value = "/mypage/note/list/{page}/{perPageNum}/{keyword}", method = RequestMethod.GET)
	public String noteListByCri(@PathVariable("page") int page, @PathVariable("perPageNum") int perPageNum, @PathVariable("keyword") String keyword, HttpSession session, Model model)
			throws Exception {
		logger.info("크리투스트링: page" +page+"perPageNum:"+perPageNum+"keyword"+keyword );
		// login 세션을 가저옴
		Object member = session.getAttribute("login");
		Member member1 = (Member) member;
		Criteria cri=new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setKeyword(keyword);
		// 세션에 저장되어 있는 멤버에서 memberId를 가저옴
		String memberId = member1.getMemberId();
		List<Note> notelist = noteService.listByCri(cri, memberId);
		logger.info("보낸편지함"+notelist.toString());
		model.addAttribute("list", notelist);

		PageMaker2 pageMaker = new PageMaker2();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(noteService.listCountCriteria(cri, memberId));
		model.addAttribute("pageMaker", pageMaker);

		return "member/noteList";
	}
	
	/**
	 * @param noteId
	 * @param model
	 * @param session
	 * @return
	 * 쪽지 읽기
	 */
	@RequestMapping(value = "/mypage/note/read/{noteId}", method = RequestMethod.GET)
	public String noteRead(@PathVariable("noteId") int noteId, Model model, HttpSession session) {
		Note note = noteService.readNote(noteId);
		Object member = session.getAttribute("login");
		Member member1 = (Member) member;
		String memberId = member1.getMemberId();
		if (note.getReceiver().equalsIgnoreCase(memberId)) {
			noteService.updateReadDate(noteId);
		}
		model.addAttribute(note);

		return "member/noteRead";
	}

	/**
	 * 해당아이디에 note 삭제POST
	 * @param noteId
	 * @param rttr
	 * @return
	 */
	@RequestMapping(value = "/mypage/note/delete", method = RequestMethod.POST)
	public String noteDelete(@RequestParam("noteId") int noteId, RedirectAttributes rttr) {
		noteService.deleteNote(noteId);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/member/mypage/note/list";
	}


}
