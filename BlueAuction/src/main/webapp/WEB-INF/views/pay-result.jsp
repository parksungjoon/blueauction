<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="wide wow-animation" lang="en">
  <head>
    <%-- Site Title--%>
    <title>Home</title>
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <link rel="icon" href="resources/images/favicon.ico" type="image/x-icon">
    <%-- Stylesheets --%>
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/mdi.css">
    <link rel="stylesheet" href="resources/css/fl-bigmug-line.css">
		<%--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/">
    <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--%> 
  </head>
  
  <body>
    <%-- Page preloader 시작--%>
    <jsp:include page="/WEB-INF/views/include/pageloader.jsp"/>
    
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
                <ul class="rd-navbar-nav">
                  <li><a href="index.html">Home</a>
                  </li>
                  <li><a href="about-us.html">About Us</a>
                  </li>
                  <li><a href="#">Services</a>
                    <!-- RD Navbar Dropdown-->
                    <ul class="rd-navbar-dropdown">
                      <li><a href="services.html">Services</a>
                      </li>
                      <li><a href="single-service.html">Single Service</a>
                      </li>
                    </ul>
                  </li>
                  <li><a href="#">Gallery</a>
                    <!-- RD Navbar Dropdown-->
                    <ul class="rd-navbar-dropdown">
                      <li><a href="grid-album-gallery.html">Grid Album Gallery</a>
                      </li>
                      <li><a href="fullwidth-gallery-inside-title.html">Fullwidth Gallery Inside Title</a>
                      </li>
                      <li><a href="grid-gallery-outside-title.html">Grid Gallery Outside Title</a>
                      </li>
                      <li><a href="masonry-gallery-outside-title.html">Masonry Gallery Outside Title</a>
                      </li>
                    </ul>
                  </li>
                  <li><a href="#">Blog</a>
                    <!-- RD Navbar Dropdown-->
                    <ul class="rd-navbar-dropdown">
                      <li><a href="classic-blog.html">Classic Blog</a>
                      </li>
                      <li><a href="grid-blog.html">Grid Blog</a>
                      </li>
                      <li><a href="masonry-blog.html">Masonry Blog</a>
                      </li>
                      <li><a href="modern-blog.html">Modern Blog</a>
                      </li>
                      <li><a href="audio-post.html">Audio Post</a>
                      </li>
                      <li><a href="image-post.html">Image Post</a>
                      </li>
                      <li><a href="single-post.html">Single Post</a>
                      </li>
                      <li><a href="video-post.html">Video Post</a>
                      </li>
                    </ul>
                  </li>
                  <li><a href="#">Shop</a>
                    <!-- RD Navbar Dropdown-->
                    <ul class="rd-navbar-dropdown">
                      <li><a href="checkout.html">Checkout</a>
                      </li>
                      <li><a href="product-page.html">Product Page</a>
                      </li>
                      <li><a href="shop-3-columns-layout.html">Shop 3 Columns Layout</a>
                      </li>
                      <li><a href="shopping-cart.html">Shopping Cart</a>
                      </li>
                    </ul>
                  </li>
                  <li class="active"><a href="#">Pages</a>
                    <!-- RD Navbar Megamenu-->
                    <ul class="rd-navbar-megamenu rd-navbar-megamenu-banner">
                      <li><img src="images/accordions-1-570x600.jpg" alt="" width="570" height="600"/>
                      </li>
                      <li>
                        <ul class="rd-megamenu-list">
                          <li><a href="404-page.html">404 Page</a></li>
                          <li><a href="503-page.html">503 Page</a></li>
                          <li><a href="careers.html">Careers</a></li>
                          <li><a href="single-job.html">Single Job</a></li>
                          <li><a href="coming-soon.html">Coming Soon</a></li>
                          <li><a href="pricing.html">Pricing</a></li>
                          <li><a href="tooltips.html">Tooltips</a></li>
                        </ul>
                      </li>
                      <li>
                        <ul class="rd-megamenu-list">
                          <li><a href="our-history.html">Our History</a></li>
                          <li><a href="login-page.html">Login Page</a></li>
                          <li><a href="registration-page.html">Registration Page</a></li>
                          <li><a href="search-results.html">Search Results</a></li>
                          <li><a href="under-construction.html">Under Construction</a></li>
                          <li><a href="privacy-policy.html">Privacy policy</a></li>
                        </ul>
                      </li>
                      <li>
                        <ul class="rd-megamenu-list">
                          <li><a href="accordions.html">Accordions</a></li>
                          <li><a href="countdown.html">Countdown</a></li>
                          <li><a href="forms.html">Forms</a></li>
                          <li><a href="grid-system.html">Grid System</a></li>
                          <li><a href="tables.html">Tables</a></li>
                          <li><a href="tabs.html">Tabs</a></li>
                          <li><a href="typography.html">Typography</a></li>
                          <li><a href="radials.html">Radials</a></li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                  <li><a href="contacts.html">Contacts</a>
                  </li>
                </ul>
              </div>
            </div>
            
            <div class="rd-navbar-inner">
              <!-- RD Navbar Panel-->
              <div class="rd-navbar-panel">
                <!-- RD Navbar Toggle-->
                <button class="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar-nav-wrap"><span></span></button>
                <!-- RD Navbar Brand-->
                <div class="rd-navbar-brand"><a class="brand-name" href="index.html"><img class="logo-default" src="images/logo-default-173x55.png" alt="" width="173" height="55"/><img class="logo-inverse" src="images/logo-inverse-173x55.png" alt="" width="173" height="55"/></a></div>
              </div>
            </div>
          </nav>
        </div>
      </header>
      
      <!-- ë³¸ë¬¸ ìì -->
      <section class="section fullwidth-page bg-image" style="background-image: url(images/bg-02.jpg);">
        <div class="fullwidth-page-inner">
          <div class="section-md text-center">
            <div class="shell-wide">
              <!-- <p class="breadcrumbs-custom-subtitle">Payment has been completed.</p> -->
              <p class="heading-1 breadcrumbs-custom-title">Payment has been completed.</p>
              <p>'Go Home' ë²í¼ì ëë¥´ë©´ ë©ì¸íë©´ì¼ë¡ ì´ëí©ëë¤.<!-- <br class="veil reveal-sm-inline">to give you the best experience on our new website. Stay ready, we`re launching soon. --></p>
              <div class="range range-xs-center">
                <div class="cell-sm-8 cell-lg-6 cell-xl-4">
                  <!-- RD Mailform: Subscribe-->
                  <!-- <form class="rd-mailform rd-mailform-inline rd-mailform-sm rd-mailform-inline-modern rd-mailform-inline-centered" data-form-output="form-output-global" data-form-type="subscribe" method="post" action="bat/rd-mailform.php">
                    <div class="rd-mailform-inline-inner">
                    </div>
                  </form> -->
                  <button class="button form-button button-sm button-secondary" type="submit">Go Home</button>
                </div>
              </div>
            </div>
          </div>
          <!-- ë³¸ë¬¸ ì¢ë£ -->
          
          <!-- Page Footer-->
          <div class="section-xs page-footer text-center">
            <div class="shell">
              <p class="right">&#169; <span class="copyright-year"></span> All Rights Reserved
                &nbsp;<a href="#">Terms of Use</a>&nbsp;<span>and</span>&nbsp;<a href="privacy-policy.html">Privacy Policy</a>
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
    <script src="js/core.min.js"></script>
    <script src="js/script.js"></script>
  </body>
</html>