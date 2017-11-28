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

public class logoutinterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(logoutinterceptor.class);

	@Inject
	private MemberService service;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		saveDest(request);
		String dest = (String) session.getAttribute("dest");
		logger.info("current user is not logined");
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
		logger.info("로그아웃되었습니다");

		logger.info("member가 null 이 아님!");
		response.sendRedirect(dest != null ? (String) dest : "/");
		return false;
	}

	private void saveDest(HttpServletRequest req) {
		logger.info("loginterceptor  saveDest실행");
		logger.info(req.getHeader("REFERER"));
		String[] array = req.getHeader("REFERER").split("/");
		logger.info("array 배열");
		String a = "/";
		for (int i = 0; i < array.length; i++) {
			if (i > 2) {
				a += array[i] + "/";
			}
		}

		logger.info("a : " + a);
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
				logger.info("첫번째 a :" + a);
				logger.info("첫번째 a :" + req.getSession().getAttribute("dest"));
			} else {
				req.getSession().setAttribute("dest", uri + query);
				logger.info("두번째");
			}
		}

	}
}