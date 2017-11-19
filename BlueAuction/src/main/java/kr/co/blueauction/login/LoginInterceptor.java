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
		logger.info("LoginInterceptor postHandler 실행");
		HttpSession session = request.getSession();

		ModelMap modelMap = modelAndView.getModelMap();
		Object member = modelMap.get("member");

		if (member != null) { //로그인할 맴버가있으면
			
			logger.info("new login success");
			session.setAttribute(LOGIN, member); 
			if (request.getParameter("useCookie") != null) { 		//자동로그인표시 유무
				logger.info("remember me................");
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60 * 60 * 24 * 7); //쿠키 일주일저장
				response.addCookie(loginCookie);	//쿠키 response에 담음
			}
			String dest = (String)session.getAttribute("dest");
			//dest = "";
			
		//	logger.info("(String)dest"+(String)dest);
			//response.sendRedirect("/templates/checkout.html");		
			
			//System.out.println((String)dest);
			//response.setHeader("test", "Test");
			
			//response.sendRedirect("/WEB-INF/views/mypage.jsp");
			response.sendRedirect(dest != null ? (String)dest : "/");
			
			//response.sendRedirect("/");
		
		}else {
			response.sendRedirect("/login");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("LoginInterceptor preHandle 실행");
		HttpSession session = request.getSession();

		if (session.getAttribute(LOGIN) != null) {
		      logger.info("clear login data before");
		      session.removeAttribute(LOGIN);
	   }
		
		return true;
	}
}
