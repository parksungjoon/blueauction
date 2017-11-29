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
 * 로그인이 필요한 url의 접근을 차단, 허용하기 위한 AuthInterceptor 
 *
 * @author 김봉환
 * 
 * @since 2017. 11. 13.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Inject
	private MemberService service;

	/* 
	 * 회원가입이 필요한 url로 가기위해서 회원가입이 되어있는지 확인한다
	 * 자동로그인을 설정해 놓은 상태라면 자동로그인을 하여 이동하려던 url로 이동한다
	 * 로그인이 안되어 있다면 로그인페이지로 이동시킨다
	 * 
	 */
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

	/**
	 * 본래 가려던 url과 query를 dest에 저장한후 세션에 저장한다
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
			req.getSession().setAttribute("dest", uri + query);
		}

	}
}
