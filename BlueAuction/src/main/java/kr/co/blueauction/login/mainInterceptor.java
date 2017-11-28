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

public class mainInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(mainInterceptor.class);

	@Inject
	private MemberService service;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("mainInterceptor preHandle실행");
		HttpSession session = request.getSession();
		saveDest(request);
		String dest = (String) session.getAttribute("dest");
		logger.info("dest" + dest);
		if( WebUtils.getCookie(request, "loginCookie")!=null) {
			logger.info("쿠키가 있음(자동로그인)");
		}
		if (session.getAttribute("login") == null) {
			logger.info("login 세션이 null임");
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie"	);
			logger.info("자동로그인쿠키"+String.valueOf(loginCookie))	;
			if (loginCookie != null) {
				logger.info("loginCookie가  null이 아님");
				Member member = service.checkLoginBefore(loginCookie.getValue());
				if (member != null) {
					session.setAttribute("login", member);
					/*logger.info("request.getHeader(\"REFERER\").substring(16)"+request.getHeader("REFERER").substring(16));*/
					//response.sendRedirect(request.getHeader("REFERER").substring(16));
					response.sendRedirect(dest != null ? (String) dest : "/");
					return false;
				}else {
					logger.info("멤버가 null임");
				}
			}
			return true;
		}
		return true;
	}

	private void saveDest(HttpServletRequest req) {
		logger.info("mainInterceptor saveDest 실행");
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