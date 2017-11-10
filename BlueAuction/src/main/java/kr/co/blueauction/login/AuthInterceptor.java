package kr.co.blueauction.login;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.member.service.MemberService;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	  private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	  
	  @Inject
	  private MemberService service;
	  
	  @Override
	  public boolean preHandle(HttpServletRequest request,
	      HttpServletResponse response, Object handler) throws Exception {
		  System.out.println("authInterceptor prehandle 실행");
	    HttpSession session = request.getSession();   
	    System.out.println(session.toString()+"세션 ㅡㅡ");

	    if(session.getAttribute("login") == null){
	    
	      logger.info("current user is not logined");
	      
	      saveDest(request);
	      
	      Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
	      
	      if(loginCookie != null) { 
	        
	        Member member = service.checkLoginBefore(loginCookie.getValue());
	        System.out.println(loginCookie.getValue());
	        
	        logger.info("MEMBER: " + member);
	        
	        if(member != null){
	        	System.out.println("member가 null 이 아님!");
	          session.setAttribute("login", member);
	          response.sendRedirect("/");
	          return true;
	        }
	        
	      }

	      response.sendRedirect("/login");
	      return false;
	    }
	    return true;
	  }  
	  

	  private void saveDest(HttpServletRequest req) {

		  System.out.println("authinterceptor savedest 실행");
	    String uri = req.getRequestURI();

	    String query = req.getQueryString();

	    if (query == null || query.equals("null")) {
	      query = "";
	    } else {
	      query = "?" + query;
	    }

	    if (req.getMethod().equals("GET")) {
	      logger.info("dest: " + (uri + query));
	      req.getSession().setAttribute("dest", uri + query);
	    }
	  }

	//  @Override
	//  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	//
//	    HttpSession session = request.getSession();
	//
//	    if (session.getAttribute("login") == null) {
	//
//	      logger.info("current user is not logined");
	//
//	      saveDest(request);
//	      
//	      response.sendRedirect("/user/login");
//	      return false;
//	    }
//	    return true;
	//  }
	}

	// if(session.getAttribute("login") == null){
	//
	// logger.info("current user is not logined");
	// response.sendRedirect("/user/login");
	// return false;
	// }
