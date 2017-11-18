package kr.co.blueauction.member.controller;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.util.WebUtils;

import kr.co.blueauction.login.LoginDTO;
import kr.co.blueauction.login.LoginInterceptor;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.member.service.MemberService;
import kr.co.blueauction.photo.domain.Photo;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;

@Controller
//@RequestMapping("/main")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Inject
	private MemberService service;
	@Inject
	private JavaMailSender mailSender;
	@Inject
	private ProductService productService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {
		logger.info("/login 실행");
	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		logger.info("/loginPost 실행" );
		Member vo = service.login(dto);
		if (vo == null) {
			return;
		}
		model.addAttribute("member", vo);
		
		if (dto.isUseCookie()) {
			System.out.println( "dto.isusecookie()");
			int amount = 60 * 60 * 24 * 7;
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
			service.keepLogin(vo.getMemberId(), session.getId(), sessionLimit);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
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
		Object obj=session.getAttribute("login");
		member=(Member)obj;
		
		
			
		model.addAttribute("member", member);
		
		logger.info("session.getAttribute(\"login\")"+obj.toString());
		logger.info("member"+member.toString());
		

		return "/member/mypage";
	}

	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String mainGET(@ModelAttribute("member") Member member) {
		return "/examplePage/main";
	}
	@RequestMapping(value ="/payment", method = RequestMethod.GET)
	public void paymentGET(@ModelAttribute("member") Member member,HttpSession session) {
		
	}
	@RequestMapping(value ="/payment", method = RequestMethod.POST)
	public void paymentGET2(@ModelAttribute("member") Member member, HttpSession session) {

	}
	@RequestMapping(value ="/member/register", method = RequestMethod.GET)
	public void memberRegistGET(@ModelAttribute("member") Member member,HttpSession session) {
	}

	@RequestMapping(value ="/member/register", method = RequestMethod.POST)
	public void memberRegistPOST(@ModelAttribute("member") Member member, HttpSession session, HttpServletRequest request) throws Exception{
		service.insertMember(member);
		
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
	@RequestMapping(value="/memberEmailCheck")
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
	
	@RequestMapping(value="/emailAuthenCheck", method=RequestMethod.POST)
	public void checkEmailAuthenCheck(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {
		
		session.removeAttribute("uid");
		String frommail="rlaqhdghks444@gmail.com";
		String title="BLUE Aution 메일 인증 입니다";
		String content="보내지나!!!!!!!!!";
		   String paramemail = (req.getParameter("email") == null) ? "" : String.valueOf(req.getParameter("email"));
		 
		   UUID uuid=UUID.randomUUID();
		   String uid=String.valueOf(uuid);
		   
		   session.setAttribute("uid", uid);
		  
		   MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			messageHelper.setFrom(frommail);
			messageHelper.setTo(paramemail);
			messageHelper.setSubject(title);
			messageHelper.setText(uid);
			
			
			mailSender.send(message);

			System.out.println("session.getAttribute(\"uid\")"+session.getAttribute("uid"));
	}
	
	@RequestMapping(value="/uidCheck", method=RequestMethod.POST)
	public void uidCheck(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {
		PrintWriter out=res.getWriter();
		String paramuid=(req.getParameter("uid")==null) ?"" : String.valueOf(req.getParameter("uid"));
		
		if(String.valueOf(session.getAttribute("uid")).equals(paramuid)) {
			out.print("1");
			
		}else {
			out.print("2");
		}
		out.flush();
		out.close();
	}
	@RequestMapping(value="/member/mypage/goodsmarket", method=RequestMethod.GET)
	public String goodsmarket(@ModelAttribute("product") Product product, HttpSession session, Model model) throws Exception {
		//login 세션을 가저옴
		Object member=session.getAttribute("login");
		logger.info("/member/mypage/goodsmarket에서 "+member.toString());
		Member member1=(Member)member;
		//세션에 저장되어 있는 멤버에서 memberId를 가저옴
		String memberId=member1.getMemberId();
		
		//상품을 받아옴
			List<Product> products = productService.productSellList(memberId);
			for (Product product2 : products) {
				System.out.println("product2.getPhoto().toString() : "+product2.getPhoto().toString());
			}
			model.addAttribute("products", products);
			logger.info(products.toString());
		return "member/productsmarket";
	}
	
}
