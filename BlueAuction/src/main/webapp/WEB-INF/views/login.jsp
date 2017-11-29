<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="wide wow-animation" lang="en">
<head>
    <!-- Site Title-->
    <title>Login Page</title>
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <link rel="icon" href="/resources/images/favicon.ico" type="image/x-icon">
    <!-- Stylesheets -->
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/mdi.css">
    <link rel="stylesheet" href="/resources/css/fl-bigmug-line.css">
    <link rel="stylesheet" href="/resources/css/jjh-style.css">
		<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--> 
  </head>
  
 <body>
   <%-- Page preloader 시작--%>
    <jsp:include page="/WEB-INF/views/include/pageloader.jsp"/>
    
    <!-- Page-->
    <div class="page">
    
     <%@include file="include/header.jsp" %>
      <%-- Page Header 종료--%>
      
      <%--본문 시작--%>
      <section class="section fullwidth-page bg-image bg-image-4">
        <div class="fullwidth-page-inner">
          <div class="section-md text-center">
            <div class="shell">
              <h3>Login</h3>
              <div class="range range-xs-center">
                <div class="cell-sm-8 cell-md-6 cell-lg-4">
                  <!-- RD Mailform-->
                  <form action="/member/loginpost" class="rd-mailform" method="post">
                    <div class="form-wrap form-wrap-validation">
                      <input class="form-input"  type="text" name="memberId" placeholder="id">
                      <label class="form-label" for="forms-login-name" value="ID"></label>
                    </div>
                    <div class="form-wrap form-wrap-validation">
                      <input class="form-input" type="password" name="passwd" placeholder="password">
                      <label class="form-label" for="forms-login-password" ></label>
                    </div>
                    <br>
                    <div class="form-check" >
                      <label class="checkbox-inline jjh-autoLoginCheck">
                         <input type="checkbox" name="useCookie" >Remember me
                     </label>
                      <!-- <label>
                     <input type="checkbox" name="useCookie">Remember me
                    </label> -->
                    </div>
                    <div class="form-button">
                      <button class="button button-block button-secondary" type="submit">Sign In</button>
                    </div>
                  </form>
                </div>
              </div>
              <p class="offset-custom-1 text-gray-light">or enter with</p>
              <div class="group-xs group-middle"><a class="icon icon-md-smaller icon-circle icon-filled mdi mdi-facebook" href="#"></a><a class="icon icon-md-smaller icon-circle icon-filled mdi mdi-twitter" href="#"></a><a class="icon icon-md-smaller icon-circle icon-filled mdi mdi-google" href="#"></a></div>
            </div>
          </div>
          <%--본문 종료--%>
          
          <%-- Page Footer 시작--%>
          <div class="section-xs page-footer text-center">
            <div class="shell">
              <p class="right">&#169; <span class="copyright-year"></span> All Rights Reserved
                &nbsp;Terms of Use&nbsp;<span>and</span>&nbsp;Privacy Policy
              </p>
            </div>
          </div>
          <%-- Page Footer 종료--%>
          
        </div>
      </section>
    </div>
     <%-- PANEL--%>
    <%-- END PANEL--%>
    <%-- Global Mailform Output--%>
    <div class="snackbars" id="form-output-global"></div>
    
    <%-- Javascript--%>
    <script src="/resources/js/core.min.js"></script>
    <script src="/resources/js/script.js"></script>
  </body>
</html>