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
 * 모든 url 이동시 로그인상태 유무를 확인한다
 * 
 * @author 김봉환
 *
 */
public class mainInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(mainInterceptor.class);

	@Inject
	private MemberService service;

	/* 
	 * 모든 url 이동시 자동 로그인이 저장되어있는 쿠키를 확인한후
	 * 자동로그인을 실행하여 이동한다
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		saveDest(request);
		String dest = (String) session.getAttribute("dest");
		if (session.getAttribute("login") == null) {
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie"	);
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
	 *
	 * 이전에 가려던 url이 로그인이필요없는페이지일때
	 *  이동하려는 url을 dest에 저장 
	 * @param req
	 */
	private void saveDest(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String query = req.getQueryString();

		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}

		if (req.getMethod().equals("GET")) {
			if (req.getHeader("REFERER") == null) {
				req.getSession().setAttribute("dest", uri + query);
			}
		}
	}
}