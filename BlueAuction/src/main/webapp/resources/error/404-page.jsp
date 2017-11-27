<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="wide wow-animation" lang="en">
  <head>
    <!-- Site Title-->
    <title>404 Page</title>
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
    <link rel="stylesheet" href="/resources/css/ksj-css.css">
		<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--> 
  </head>
  <body>
    <!-- Page preloader-->
    <div class="page-loader">
      <div class="page-loader-body">
        <div class="preloader-wrapper big active"> 
          <div class="spinner-layer spinner-blue">
            <div class="circle-clipper left">
              <div class="circle"></div>
            </div>
            <div class="gap-patch">
              <div class="circle"> </div>
            </div>
            <div class="circle-clipper right">
              <div class="circle"></div>
            </div>
          </div>
          <div class="spinner-layer spinner-red">
            <div class="circle-clipper left">
              <div class="circle"></div>
            </div>
            <div class="gap-patch">
              <div class="circle"> </div>
            </div>
            <div class="circle-clipper right">
              <div class="circle"></div>
            </div>
          </div>
          <div class="spinner-layer spinner-yellow"> 
            <div class="circle-clipper left">
              <div class="circle"></div>
            </div>
            <div class="gap-patch">
              <div class="circle"></div>
            </div>
            <div class="circle-clipper right">
              <div class="circle"> </div>
            </div>
          </div>
          <div class="spinner-layer spinner-green"> 
            <div class="circle-clipper left">
              <div class="circle"></div>
            </div>
            <div class="gap-patch">
              <div class="circle"></div>
            </div>
            <div class="circle-clipper right">
              <div class="circle"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page-->
    <div class="page">
      <!-- Page Header-->
      <header class="section page-header bg-gray-darker breadcrumbs-custom-wrap">
        <!-- RD Navbar-->
        <div class="rd-navbar-wrap rd-navbar-shop-header">
          <nav class="rd-navbar" data-layout="rd-navbar-fixed" data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fullwidth" data-md-device-layout="rd-navbar-fixed" data-lg-layout="rd-navbar-static" data-lg-device-layout="rd-navbar-static" data-md-stick-up-offset="100px" data-lg-stick-up-offset="150px" data-stick-up="true" data-sm-stick-up="true" data-md-stick-up="true" data-lg-stick-up="true">
            
			<div class="rd-navbar-top-panel">
				<div class="rd-navbar-nav-wrap">
					<!-- RD Navbar Nav-->
                  <ul class="jjh-headerNav">
                    <li class="jjh-headerLi">
    					<ul class="rd-navbar-nav">
    						<li class="active"><a href="/">Home</a></li>
    						<li><a href="/product/used">중고상품</a></li>
    						<li><a href="/product/auction/1/0">경매상품</a> <!-- RD Navbar Dropdown-->
    							<ul class="rd-navbar-dropdown">
    								<!-- <li><a href="/product/auction/1/0">시작전 경매</a></li>
    								<li><a href="/product/auction/2/0">진행중 경매</a></li>
    								<li><a href="/product/auction/3/0">마감된 경매</a></li> -->
                    <li class="rd-navbar-dropdown-submenu">
                        <a class="test" href="/product/auction/1/0">시작전 경매</a>
                    <ul class="rd-navbar-dropdown">
                      <li><a tabindex="-1" href="/product/auction/1/1">의류</a></li>
                      <li><a tabindex="-1" href="/product/auction/1/2">잡화</a></li>
                      <li><a tabindex="-1" href="/product/auction/1/3">티켓</a></li>
                      <li><a tabindex="-1" href="/product/auction/1/4">가전제품</a></li>
                    </ul>
                  </li>
                  <li class="rd-navbar-dropdown-submenu">
                        <a class="test" href="/product/auction/2/0">진행중 경매</a>
                    <ul class="rd-navbar-dropdown">
                      <li><a tabindex="-1" href="/product/auction/2/1">의류</a></li>
                      <li><a tabindex="-1" href="/product/auction/2/2">잡화</a></li>
                      <li><a tabindex="-1" href="/product/auction/2/3">티켓</a></li>
                      <li><a tabindex="-1" href="/product/auction/2/4">가전제품</a></li>
                    </ul>
                  </li>
                  <li class="rd-navbar-dropdown-submenu">
                        <a class="test" href="/product/auction/3/0">마감된 경매</a>
                    <ul class="rd-navbar-dropdown">
                      <li><a tabindex="-1" href="/product/auction/3/1">의류</a></li>
                      <li><a tabindex="-1" href="/product/auction/3/2">잡화</a></li>
                      <li><a tabindex="-1" href="/product/auction/3/3">티켓</a></li>
                      <li><a tabindex="-1" href="/product/auction/3/4">가전제품</a></li>
                    </ul>
                  </li>
    							</ul></li>
    					</ul>
                    </li>
                    <li class="jjh-userHeader">
                      <ul class="jjh-userUl">
                        <c:if test="${not empty login}">
                         <!-- <li><form action="/logout" class="rd-mailform" method="get">  -->
                          <li class="jjh-userLi"><a href="/member/mypage"> ${login.memberId}</a>님</li>
                          <li class="jjh-userLi"><a href="/member/logout">Logout</a></li>
                          <li class="jjh-userLi"><a href="/member/mypage/note/list"><span class="icon icon-md-smaller ksj-icon-primary mdi mdi-email"><span class="badge badge-primary" id="counter">0</span>
                          </span></a></li>
                        </c:if>
                        
                        <c:if test="${empty login}">
                        <li class="jjh-userLi"><a href="/member/login">Login</a></li>
                        <li class="jjh-userLi"><a href="/member/register">Join Us</a></li>
                        </c:if>
                      </ul>
                    <li>
                  </ul>
				</div>
			</div>
            
            <div class="rd-navbar-inner">
              <!-- RD Navbar Panel-->
              <div class="rd-navbar-panel">
                <!-- RD Navbar Toggle-->
                <button class="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar-nav-wrap"><span></span></button>
                <!-- RD Navbar Brand-->
                <div class="rd-navbar-brand"><a class="brand-name" href="/"><img class="logo-default" src="/resources/images/logo-default-173x55.png" alt="" width="173" height="55"/><img class="logo-inverse" src="/resources/images/logo-inverse-173x55.png" alt="" width="173" height="55"/></a></div>
              </div>
              <div class="rd-navbar-aside-center">
              </div>
            </div>
          </nav>
        </div>
      </header>
      <section class="section fullwidth-page bg-image" style="background-image: url(/resources/images/bg-01.jpg);">
        <div class="fullwidth-page-inner">
          <div class="section-md text-center">
            <div class="shell">
              <p class="breadcrumbs-custom-subtitle">Sorry, But the Page Was not Found</p>
              <p class="heading-1 breadcrumbs-custom-title">error 404</p>
              <p>You may have mistyped the address or the page may have moved.</p><a class="button button-secondary" href="/"> back to home page</a>
            </div>
          </div>
          <!-- Page Footer-->
          <div class="section-xs page-footer text-center">
            <div class="shell">
              <p class="right">&#169; <span class="copyright-year"></span> All Rights Reserved
                &nbsp;<a href="#">Terms of Use</a>&nbsp;<span>and</span>&nbsp;<a href="#">Privacy Policy</a>
              </p>
            </div>
          </div>
        </div>
      </section>
    </div>
    <!-- PANEL-->
    <!-- END PANEL-->
    <!-- Global Mailform Output-->
    <div class="snackbars" id="form-output-global"></div>
    <!-- Javascript-->
    <script src="/resources/js/core.min.js"></script>
    <script src="/resources/js/script.js"></script>
  </body>
</html>