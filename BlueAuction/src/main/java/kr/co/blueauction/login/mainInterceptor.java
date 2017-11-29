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