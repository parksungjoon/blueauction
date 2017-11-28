<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="wide wow-animation" lang="ko">
  <head>
    <%-- Site Title--%>
    <title>Home</title>
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <link rel="icon" href="/resources/images/favicon.ico" type="image/x-icon">
    <%-- Stylesheets --%>
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/mdi.css">
    <link rel="stylesheet" href="/resources/css/fl-bigmug-line.css">
		<%--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/">
    <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--%> 
  </head>

  <body>
    <%-- Page preloader 시작--%>
    <jsp:include page="/WEB-INF/views/include/pageloader.jsp"/>
    
    <%--Page 시작 --%>
    <div class="page">
    
     <%-- page Header START --%>
    <jsp:include page="/WEB-INF/views/include/header.jsp" />
    <%-- page Header END --%>
      
      <%--본문 시작--%>
      <section class="section fullwidth-page bg-image" style="background-image: url(resources/images/bg-02.jpg);">
        <div class="fullwidth-page-inner">
          <div class="section-md text-center">
            <div class="shell-wide">
              <!-- <p class="breadcrumbs-custom-subtitle">Payment has been completed.</p> -->
              <p class="heading-1 breadcrumbs-custom-title">${result}</p>
              <p>${why} 감사합니다..<!-- <br class="veil reveal-sm-inline">to give you the best experience on our new website. Stay ready, we`re launching soon. --></p>
              <div class="range range-xs-center">
                <div class="cell-sm-8 cell-lg-6 cell-xl-4">
                  <!-- RD Mailform: Subscribe-->
                  <!-- <form class="rd-mailform rd-mailform-inline rd-mailform-sm rd-mailform-inline-modern rd-mailform-inline-centered" data-form-output="form-output-global" data-form-type="subscribe" method="post" action="bat/rd-mailform.php">
                    <div class="rd-mailform-inline-inner">
                    </div>
                  </form> -->
                  <a href="/"><button class="button form-button button-sm button-secondary" >Go Home</button></a>
                  &nbsp;
                  <span><a href="/member/mypage"><button class="button form-button button-sm button-secondary" >Go Mypage</button></a></span>
                </div>
              </div>
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