package kr.co.blueauction.member.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.mysql.cj.api.Session;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.PageMaker;
import kr.co.blueauction.common.domain.PageMaker2;
import kr.co.blueauction.common.domain.SearchCriteria;
import kr.co.blueauction.login.LoginDTO;
import kr.co.blueauction.login.LoginInterceptor;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.member.service.MemberService;
import kr.co.blueauction.note.domain.Note;
import kr.co.blueauction.note.service.NoteService;
import kr.co.blueauction.order.domain.Orders;
import kr.co.blueauction.order.service.OrderService;
import kr.co.blueauction.photo.domain.Photo;
import kr.co.blueauction.product.controller.ProductDetailController;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;

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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET(@ModelAttribute("dto") LoginDTO dto, HttpServletRequest req) {
		logger.info("/member/login 실행");
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("login");

		if (obj != null) {
			logger.info("자동로그인할 login세션이있음");
			return "redirect:/";
		} else {
			logger.info("자동로그인할 login세션이없음");
		}
		return "/login";
	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		logger.info("member/loginPost 실행");
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

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		System.out.println("membercontroller logout 실행");

		Object obj = session.getAttribute("login");

		if (obj != null) {
			Member vo = (Member) obj;

			session.removeAttribute("login");
			session.invalidate();

			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

			if (loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(vo.getMemberId(), session.getId(), new Date());
			}
		}
		logger.info("로그아웃되었습니다");
		return "redirect:/";

	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypageGET(@ModelAttribute("member") Member member, HttpSession session, Model model) {
		Object obj = session.getAttribute("login");
		member = (Member) obj;

		model.addAttribute("member", member);

		logger.info("session.getAttribute(\"login\")" + obj.toString());
		logger.info("member" + member.toString());

		return "/member/mypage";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainGET(@ModelAttribute("member") Member member) {
		return "/examplePage/main";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void memberRegistGET(@ModelAttribute("member") Member member, HttpSession session) {
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String memberRegistPOST(@ModelAttribute("member") Member member, HttpSession session,
			HttpServletRequest request) throws Exception {
		logger.info("/member/register  controller  POST 실행");
		service.insertMember(member);
		return "redirect:/";
	}

	@RequestMapping(value = "/memberCheck")
	public void checkId(HttpServletRequest req, HttpServletResponse res, ModelMap model) throws Exception {
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

	@RequestMapping(value = "/memberEmailCheck")
	public void checkEmail(HttpServletRequest req, HttpServletResponse res, ModelMap model) throws Exception {
		System.out.println("checkEmail 실행");
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

	@RequestMapping(value = "/emailAuthenCheck", method = RequestMethod.POST)
	public void checkEmailAuthenCheck(HttpServletRequest req, HttpServletResponse res, HttpSession session)
			throws Exception {

		session.removeAttribute("uid");
		String frommail = "rlaqhdghks444@gmail.com";
		String title = "BLUE Aution 메일 인증 입니다";
		String content = "보내지나!!!!!!!!!";
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

		System.out.println("session.getAttribute(\"uid\")" + session.getAttribute("uid"));
	}

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

	@RequestMapping(value = "/mypage/goodsmarket", method = RequestMethod.GET)
	public String goodsmarket(@ModelAttribute("cri") Criteria cri, HttpSession session, Model model)
			throws Exception {
		// login 세션을 가저옴
		Object member = session.getAttribute("login");
		logger.info("/member/mypage/goodsmarket에서 " + member.toString());
		Member member1 = (Member) member;
		// 세션에 저장되어 있는 멤버에서 memberId를 가저옴
		String memberId = member1.getMemberId();
		String auctionFlag = "N";
		// 상품을 받아옴
		model.addAttribute("products", productService.productSellListCriteria(cri, memberId, auctionFlag));
		logger.info("String.valueOf(productService.listCountCriteria(cri))"+String.valueOf(productService.listCountCriteria(memberId)));
		PageMaker2 pageMaker2 = new PageMaker2();
		pageMaker2.setCri(cri);
		pageMaker2.setTotalCount(productService.listCountCriteria(memberId));
		model.addAttribute("pageMaker", pageMaker2);
		return "member/productsmarket";
	}


	@RequestMapping(value = "/mypage/auctionmarket", method = RequestMethod.GET)
	public String auctionmarket(@ModelAttribute("product") Product product, HttpSession session, Model model)
			throws Exception {
		// login 세션을 가저옴
		Object member = session.getAttribute("login");
		logger.info("/member/mypage/goodsmarket에서 " + member.toString());
		Member member1 = (Member) member;
		// 세션에 저장되어 있는 멤버에서 memberId를 가저옴
		String memberId = member1.getMemberId();
		String auctionFlag = "Y";
		// 상품을 받아옴
		List<Product> products = productService.productSellList(memberId, auctionFlag);
		for (Product product2 : products) {
			System.out.println("product2.getPhoto().toString() : " + product2.getPhoto().toString());
		}
		model.addAttribute("products", products);
		logger.info(products.toString());
		return "member/auctionmarket";
	}

	@RequestMapping(value = "/mypage/note/list", method = RequestMethod.GET)
	public String noteList(@ModelAttribute("cri") SearchCriteria cri, HttpSession session, Model model)
			throws Exception {
		logger.info("크리투스트링:" + cri.toString());
		// login 세션을 가저옴
		Object member = session.getAttribute("login");
		logger.info("/member/mypage/notelist에서 " + member.toString());
		Member member1 = (Member) member;

		if (cri.getKeyword() == null) {
			cri.setKeyword("R");
		}

		// 세션에 저장되어 있는 멤버에서 memberId를 가저옴
		String memberId = member1.getMemberId();
		List<Note> notelist = noteService.listByCri(cri, memberId);
		model.addAttribute("list", notelist);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(noteService.listCountCriteria(cri, memberId));
		model.addAttribute("pageMaker", pageMaker);

		return "member/noteList";
	}

	@RequestMapping(value = "/mypage/note/read", method = RequestMethod.GET)
	public String noteRead(@RequestParam("noteId") int noteId, Model model, HttpSession session) {
		Note note = noteService.readNote(noteId);
		Object member = session.getAttribute("login");
		Member member1 = (Member) member;
		String memberId = member1.getMemberId();
		logger.info("읽는 사람" + memberId + "받는사람" + note.getReceiver());
		if (note.getReceiver().equalsIgnoreCase(memberId)) {
			logger.info("왜 여기로 안들어오니");
			noteService.updateReadDate(noteId);
		}
		model.addAttribute(note);

		return "member/noteRead";
	}

	@RequestMapping(value = "/mypage/note/delete", method = RequestMethod.POST)
	public String noteDelete(@RequestParam("noteId") int noteId, RedirectAttributes rttr) {
		noteService.deleteNote(noteId);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/member/mypage/note/list";
	}

}
