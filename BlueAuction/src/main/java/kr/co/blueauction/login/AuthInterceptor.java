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
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		  logger.info("AuthInterceptor preHandle 실행");

		  HttpSession session = request.getSession();   
	    
		  logger.info("Location Before : " + session.getAttribute("login"));
		  
		  if(session.getAttribute("login") == null) {
	    
			  logger.info("current user is not logined");
	      
			  saveDest(request);
			  String dest = (String)session.getAttribute("dest");
			  logger.info((String)session.getAttribute("dest"));
		      Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		      
		      if(loginCookie != null) { 
		        Member member = service.checkLoginBefore(loginCookie.getValue());
		        logger.info("loginCookie.getValue()"+loginCookie.getValue());
		       
		        logger.info("MEMBER: " + member);
		        if(member != null){
		        	 logger.info("member가 null 이 아님!");
		          session.setAttribute("login", member); //로그인이 안되있는상태고 자동로그인이 설정되어있는상태일때  세션에로그인추가
		          //로그인이되었으니 메인페이지로 이동 컨트롤러는 실행되지 않음
		          response.sendRedirect(dest != null ? (String)dest : "/");
		          return false;
		        }else {
		        	//자동로그인이 설정되어있지 않은상태여서 자동로그인이안되고 컨트롤러로이동한다?
		        	//login으로갈려고햇을때 login controller가실행되 login으로 이동할수있다
		        	//login으로가려한게아니면 다른컨트롤러가 실행되어 다른페이지로이동할수잇다(로그인이 안되있는대 다른페이지로가지면안된다)
		        	if(session.getAttribute("dest").equals("/login")) {
		        		return false;
		        	}else {
		        	return true;
		        	}
		        }
		      }else {// 로그인이 안되있고  자동로그인이 안되어있음  로그인화면으로가야됨
		    	  logger.info("response.sendRedirect(\"/login\")실행 ");
			  response.sendRedirect("/login");
			  return false;
		      }
			 
	    }
		  
	    if(session.getAttribute("login") != null) {
	    	logger.info("SESSION : " + session.getAttribute("login").toString());
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
	      logger.info("dest: " + (uri + query));
	      req.getSession().setAttribute("dest", uri + query);
	    }
	    
	  }
	 /* @Override
	  public void postHandle(
				HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
				throws Exception {
		  System.out.println("authinterceptor posthandle 실행");
		  response.sendRedirect("/payment");
		}*/

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
