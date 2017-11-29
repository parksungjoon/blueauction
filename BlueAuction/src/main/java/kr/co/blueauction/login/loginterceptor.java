package kr.co.blueauction.login;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.member.service.MemberService;

/**
 * 로그인이 페이지로 이동시 작동하는 loginterceptor
 * 
 * @author 김봉환
 *
 */
public class loginterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(loginterceptor.class);

	@Inject
	private MemberService service;

	/* 
	 * 로그인이 필요하여 로그인페이지로 이동할때
	 * 이동하기전 쿠키에서 자동로그인 쿠키를 확인하여
	 * 쿠키가있다면 dest로 이동하여 로그인 페이지로 이동하지않게한다
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		saveDest(request);
		String dest = (String) session.getAttribute("dest");
		if (session.getAttribute("login") == null) {

			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

			if (loginCookie != null) {
				Member member = service.checkLoginBefore(loginCookie.getValue());
				if (member != null) {
					session.setAttribute("login", member);
					response.sendRedirect(dest != null ? (String) dest : "/");
					return false;
				}
			}
			return true;
		}
		return true;
	}

	/**
	 * 로그인이 필요하지 않은 url에서도 
	 * 로그인을 하면 원래 url로 이동할 수 있게
	 * 저장하는 dest에 저장
	 * @param req
	 */
	private void saveDest(HttpServletRequest req) {
		String[] array =req.getHeader("REFERER").split("/");
		String a="/";
		for(int i=0; i<array.length; i++) {
			if(i>2) {
				a+=array[i]+"/";
			}
		}
		
		String uri = req.getRequestURI();
		String query = req.getQueryString();

		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}
		if (req.getMethod().equals("GET")) {
			if (req.getHeader("REFERER") != null) {
				req.getSession().setAttribute("dest", a);
			} else {
				req.getSession().setAttribute("dest", uri + query);
			}
		}

	}
}