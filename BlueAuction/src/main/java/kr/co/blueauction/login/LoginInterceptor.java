package kr.co.blueauction.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
		System.out.println("loginterceptor posthandle 실행");
		HttpSession session = request.getSession();
		// System.out.println("session : " + session);

		ModelMap modelMap = modelAndView.getModelMap();
		Object member = modelMap.get("member");

		if (member != null) {

			logger.info("new login success");
			session.setAttribute(LOGIN, member);

			if (request.getParameter("useCookie") != null) {

				logger.info("remember me................");
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60 * 60 * 24 * 7);
				response.addCookie(loginCookie);
			}
			// response.sendRedirect("/");
			Object dest = session.getAttribute("dest");

			response.sendRedirect(dest != null ? (String) dest : "/");
			// response.sendRedirect("/");
		}
	}

	// @Override
	// public void postHandle(HttpServletRequest request,
	// HttpServletResponse response, Object handler,
	// ModelAndView modelAndView) throws Exception {
	//
	// HttpSession session = request.getSession();
	//
	// ModelMap modelMap = modelAndView.getModelMap();
	// Object userVO = modelMap.get("userVO");
	//
	// if(userVO != null){
	//
	// logger.info("new login success");
	// session.setAttribute(LOGIN, userVO);
	// //response.sendRedirect("/");
	//
	// Object dest = session.getAttribute("dest");
	//
	// response.sendRedirect(dest != null ? (String)dest:"/");
	// }
	// }

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("loginterceptor prehandle 실행");
		HttpSession session = request.getSession();

		if (session.getAttribute(LOGIN) != null) {
			logger.info("세션이있다");
			session.removeAttribute(LOGIN);
		}else {
			System.out.println("LOGIN 세션없다");
		}

		return true;
	}
}
