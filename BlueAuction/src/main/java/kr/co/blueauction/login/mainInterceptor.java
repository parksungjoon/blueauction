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
		logger.info("mainInterceptor preHandle 실행");
		HttpSession session = request.getSession();
		logger.info("Location Before : " + session.getAttribute("login"));
		saveDest(request);
		String dest = (String) session.getAttribute("dest");
		if (session.getAttribute("login") == null) {
			logger.info("현제 로그인 안되있어");
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if (loginCookie != null) {
				Member member = service.checkLoginBefore(loginCookie.getValue());
				logger.info("loginCookie.getValue()" + loginCookie.getValue());
				logger.info("MEMBER: " + member);
				if (member != null) {
					logger.info("member가 null 이 아님!");
					session.setAttribute("login", member);
					// logger.info("request.getHeader(\"REFERER\").substring(16)"+request.getHeader("REFERER").substring(16));
					// response.sendRedirect(request.getHeader("REFERER").substring(16));
					response.sendRedirect(dest != null ? (String) dest : "/");
					return false;
				}
			}
			return true;
		}
		if (session.getAttribute("login") != null) {
			logger.info("SESSION : " + session.getAttribute("login").toString());
		}
		return true;
	}

	private void saveDest(HttpServletRequest req) {
		logger.info("mainInterceptor  saveDest실행");

		String uri = req.getRequestURI();
		String query = req.getQueryString();

		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}

		if (req.getMethod().equals("GET")) {
			logger.info("dest: " + (uri + query));
			if (req.getHeader("REFERER") == null) {
				logger.info("REFERER null");
				req.getSession().setAttribute("dest", uri + query);
			}
		}
	}
}