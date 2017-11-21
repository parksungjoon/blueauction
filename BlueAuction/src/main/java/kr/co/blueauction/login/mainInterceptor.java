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
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		  logger.info("mainInterceptor preHandle 실행");
		  HttpSession session = request.getSession();   
		  logger.info("Location Before : " + session.getAttribute("login"));
		  
		  if(session.getAttribute("login") == null) {
			  logger.info("current user is not logined");
			
		      Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		      
		      if(loginCookie != null) { 
		        Member member = service.checkLoginBefore(loginCookie.getValue());
		        logger.info("loginCookie.getValue()"+loginCookie.getValue());
		       
		        logger.info("MEMBER: " + member);
		        if(member != null){
		        	  logger.info("member가 null 이 아님!");
		          session.setAttribute("login", member);
		          response.sendRedirect("/");
		          return false;
		        }
		      }
			  return true;
	    }
		  
	    if(session.getAttribute("login") != null) {
	    	logger.info("SESSION : " + session.getAttribute("login").toString());
	    }
	    
	    return true;
	  }  
}