package kr.co.blueauction.member.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import kr.co.blueauction.login.LoginDTO;
import kr.co.blueauction.login.LoginInterceptor;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.member.service.MemberService;

@Controller
// @RequestMapping("/main")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Inject
	private MemberService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {
		System.out.println("membercontroller loginGET 실행");
	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		System.out.println("membercontroller loginpost 실행");
		System.out.println(dto.toString());
		Member vo = service.login(dto);
		if (vo == null) {
			return;
		}
		model.addAttribute("member", vo);
		if (dto.isUseCookie()) {
			int amount = 60 * 60 * 24 * 7;
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
			service.keepLogin(vo.getMemberId(), session.getId(), sessionLimit);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
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
	}

	@RequestMapping(value = "/memberRegistration", method = RequestMethod.GET)
	public void memberRegistrationGET(@ModelAttribute("member") Member member) {
		System.out.println("membercontroller memberRegistrationGET 실행");
	}
	
	@RequestMapping(value = "/memberRegistration2", method = RequestMethod.GET)
	public void memberRegistrationGET1(@ModelAttribute("member") Member member) {
		System.out.println("membercontroller memberRegistrationGET 실행");
	}
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public void mypageGET(@ModelAttribute("member") Member member) {
		System.out.println("membercontroller mypageGET 실행");
	}

	@RequestMapping(value ="/main", method = RequestMethod.GET)
	public String mainGET(@ModelAttribute("member") Member member) {
		System.out.println("membercontroller mainGET 실행");
		return "/examplePage/main";
	}
	@RequestMapping(value ="/payment", method = RequestMethod.GET)
	public String paymentGET(@ModelAttribute("member") Member member,HttpSession session) {
		System.out.println("membercontroller paymentGET 실행");
		Object obj = session.getAttribute("login");
		System.out.println("obj"+obj);
		
//		System.out.println(member);
		return "/payment";
	}
	@RequestMapping(value ="/payment", method = RequestMethod.POST)
	public String paymentGET2(@ModelAttribute("member") Member member,HttpSession session) {
		System.out.println("membercontroller paymentGET 실행");
		
		
		
		

		return "/payment";
	}
	@RequestMapping(value ="/member/register", method = RequestMethod.GET)
	public void memberRegist(@ModelAttribute("member") Member member,HttpSession session) {
		System.out.println("membercontroller memberRegist 실행");
	}
	
	
	
}
