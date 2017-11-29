package kr.co.blueauction.login;

import java.util.Date;

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
 * 로그아웃을 할때 작동하는 logoutinterceptor
 * 
 * @author 김봉환
 *
 */
public class logoutinterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(logoutinterceptor.class);

	@Inject
	private MemberService service;

	/* 
	 * 로그아웃을 위해 저장된 세션과 저장된 쿠키를 지운다
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		saveDest(request);
		String dest = (String) session.getAttribute("dest");
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
		response.sendRedirect(dest != null ? (String) dest : "/");
		return false;
	}

	/**
	 * 
	 * 로그아웃시 현제 위치해 있는 url을 dest에 저장하여
	 * 
	 * 
	 * @param req
	 */
	private void saveDest(HttpServletRequest req) {
		String[] array = req.getHeader("REFERER").split("/");
		String a = "/";
		for (int i = 0; i < array.length; i++) {
			if (i > 2) {
				a += array[i] + "/";
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