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

/**
 * 로그인을 실행한후 url 이동을 위한 LoginInterceptor
 * 
 * @author 김봉환
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	/* 
	 * 로그인후 자동로그인을 실행할 것인지 확인한후
	 * 쿠키를 일주일 저장한후 
	 * 가려던 dest로 이동한다 dest가 없다면 / 로 이동한다
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object member = modelMap.get("member");

		if (member != null) { 
			session.setAttribute(LOGIN, member); 
			if (request.getParameter("useCookie") != null) { 		//자동로그인표시 유무
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60 * 60 * 24 * 7); //쿠키 일주일저장
				response.addCookie(loginCookie);	//쿠키 response에 담음
			}
			String dest = (String)session.getAttribute("dest");
			Object referer=session.getAttribute("referer");
			if(dest!="/resources/css/style.css.map") {
				System.out.println("dfdsdfsfdsfdsfdsfdsfdsfsd");
				dest="/";
			}
			response.sendRedirect(dest != null ? (String)dest : "/");
		}else {
			response.sendRedirect("/member/login");
		}
	}

	/* 
	 * 로그인 실행전 전에있던 login 세션을 제거
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute(LOGIN) != null) {
		      session.removeAttribute(LOGIN);
	   }
		return true;
	}
}
