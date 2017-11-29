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

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Inject
	private MemberService service;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {
			saveDest(request);
			String dest = (String) session.getAttribute("dest");
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

			if (loginCookie != null) {
				Member member = service.checkLoginBefore(loginCookie.getValue());
				if (member != null) {
					session.setAttribute("login", member); // 로그인이 안되있는상태고 자동로그인이 설정되어있는상태일때 세션에로그인추가
					response.sendRedirect(dest != null ? (String) dest : "/");
					return true;
				} else {
					if (session.getAttribute("dest").equals("/member/login")) {
						return true;
					} else {
						response.sendRedirect("/member/login");
						return false;
					}
				}
			} else {// 로그인이 안되있고 자동로그인이 안되어있음 로그인화면으로가야됨
				response.sendRedirect("/member/login");
				return false;
			}
		}
		return true;
	}

	private void saveDest(HttpServletRequest req) {
		logger.info("AuthInterceptor  saveDest실행");

		String uri = req.getRequestURI();
		String query = req.getQueryString();

		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}

		if (req.getMethod().equals("GET")) {
			req.getSession().setAttribute("dest", uri + query);
		}

	}
}
