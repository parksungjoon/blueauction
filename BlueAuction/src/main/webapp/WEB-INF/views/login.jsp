<%@ page contentType="text/html; charset=utf-8"%>
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
    
      <%-- Page Header 시작--%>
       <header class="section page-header bg-gray-darker breadcrumbs-custom-wrap">  
        <!-- RD Navbar-->
        <div class="rd-navbar-wrap rd-navbar-shop-header">
          <nav class="rd-navbar" data-layout="rd-navbar-fixed" data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fullwidth" data-md-device-layout="rd-navbar-fixed" data-lg-layout="rd-navbar-static" data-lg-device-layout="rd-navbar-static" data-md-stick-up-offset="100px" data-lg-stick-up-offset="150px" data-stick-up="true" data-sm-stick-up="true" data-md-stick-up="true" data-lg-stick-up="true">
            <div class="rd-navbar-top-panel">
              <div class="rd-navbar-nav-wrap">
                <!-- RD Navbar Nav-->
                <ul class="rd-navbar-nav">
                  <li><a href="../WEB-INF/views/examplePage/main">Home</a>
                  </li>
                  <li><a href="WEB-INF/views/templates/about-us.html">About Us</a>
                  </li>
                  <li><a href="#">Services</a>
                    <!-- RD Navbar Dropdown-->
                    <ul class="rd-navbar-dropdown">
                      <li><a href="WEB-INF/views/templates/services.html">Services</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/single-service.html">Single Service</a>
                      </li>
                    </ul>
                  </li>
                  <li><a href="#">Gallery</a>
                    <!-- RD Navbar Dropdown-->
                    <ul class="rd-navbar-dropdown">
                      <li><a href="WEB-INF/views/templates/grid-album-gallery.html">Grid Album Gallery</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/fullwidth-gallery-inside-title.html">Fullwidth Gallery Inside Title</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/grid-gallery-outside-title.html">Grid Gallery Outside Title</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/masonry-gallery-outside-title.html">Masonry Gallery Outside Title</a>
                      </li>
                    </ul>
                  </li>
                  <li><a href="#">Blog</a>
                    <!-- RD Navbar Dropdown-->
                    <ul class="rd-navbar-dropdown">
                      <li><a href="WEB-INF/views/templates/classic-blog.html">Classic Blog</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/grid-blog.html">Grid Blog</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/masonry-blog.html">Masonry Blog</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/modern-blog.html">Modern Blog</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/audio-post.html">Audio Post</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/image-post.html">Image Post</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/single-post.html">Single Post</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/video-post.html">Video Post</a>
                      </li>
                    </ul>
                  </li>
                  <li><a href="#">Shop</a>
                    <!-- RD Navbar Dropdown-->
                    <ul class="rd-navbar-dropdown">
                      <li><a href="WEB-INF/views/templates/checkout.html">Checkout</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/product-page.html">Product Page</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/shop-3-columns-layout.html">Shop 3 Columns Layout</a>
                      </li>
                      <li><a href="WEB-INF/views/templates/shopping-cart.html">Shopping Cart</a>
                      </li>
                    </ul>
                  </li>
                  <li class="active"><a href="#">Pages</a>
                    <!-- RD Navbar Megamenu-->
                    <ul class="rd-navbar-megamenu rd-navbar-megamenu-banner">
                      <li><img src="resources/images/accordions-1-570x600.jpg" alt="" width="570" height="600"/>
                      </li>
                      <li>
                        <ul class="rd-megamenu-list">
                          <li><a href="WEB-INF/views/templates/404-page.html">404 Page</a></li>
                          <li><a href="WEB-INF/views/templates/503-page.html">503 Page</a></li>
                          <li><a href="WEB-INF/views/templates/careers.html">Careers</a></li>
                          <li><a href="WEB-INF/views/templates/single-job.html">Single Job</a></li>
                          <li><a href="WEB-INF/views/templates/coming-soon.html">Coming Soon</a></li>
                          <li><a href="WEB-INF/views/templates/pricing.html">Pricing</a></li>
                          <li><a href="WEB-INF/views/templates/tooltips.html">Tooltips</a></li>
                        </ul>
                      </li>
                      <li>
                        <ul class="rd-megamenu-list">
                          <li><a href="WEB-INF/views/templates/our-history.html">Our History</a></li>
                          <li><a href="WEB-INF/views/templates/login-page.html">Login Page</a></li>
                          <li><a href="WEB-INF/views/templates/registration-page.html">Registration Page</a></li>
                          <li><a href="WEB-INF/views/templates/search-results.html">Search Results</a></li>
                          <li><a href="WEB-INF/views/templates/under-construction.html">Under Construction</a></li>
                          <li><a href="WEB-INF/views/templates/privacy-policy.html">Privacy policy</a></li>
                        </ul>
                      </li>
                      <li>
                        <ul class="rd-megamenu-list">
                          <li><a href="WEB-INF/views/templates/accordions.html">Accordions</a></li>
                          <li><a href="WEB-INF/views/templates/countdown.html">Countdown</a></li>
                          <li><a href="WEB-INF/views/templates/forms.html">Forms</a></li>
                          <li><a href="WEB-INF/views/templates/grid-system.html">Grid System</a></li>
                          <li><a href="WEB-INF/views/templates/tables.html">Tables</a></li>
                          <li><a href="WEB-INF/views/templates/tabs.html">Tabs</a></li>
                          <li><a href="WEB-INF/views/templates/typography.html">Typography</a></li>
                          <li><a href="WEB-INF/views/templates/radials.html">Radials</a></li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                  <li><a href="WEB-INF/views/templates/contacts.html">Contacts</a>
                  </li>
                </ul>
              </div>
            </div>
            
            <%-- Page 상단 로고 시작--%>
            <div class="rd-navbar-inner">
              <%-- RD Navbar Panel--%>
              <div class="rd-navbar-panel">
                <%-- RD Navbar Panel--%>
                <button class="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar-nav-wrap"><span></span></button>
                <%-- RD Navbar Brand--%>
                <div class="rd-navbar-brand"><a class="brand-name" href="WEB-INF/views/templates/index.html"><img class="logo-default" src="/resources/images/logo-default-173x55.png" alt="" width="173" height="55"/><img class="/resources/logo-inverse" src="/resources/images/logo-inverse-173x55.png" alt="" width="173" height="55"/></a></div>
              </div>
            </div>
            <%-- Page 상단 로고 종료--%>
            
          </nav>
        </div>
      </header>
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
                  <form action="/loginPost" class="rd-mailform" method="post">
                    <div class="form-wrap form-wrap-validation">
                      <input class="form-input" id="forms-login-name" type="text" name="member_id" data-constraints="@Required">
                      <label class="form-label" for="forms-login-name">E-mail or nickname</label>
                    </div>
                    <div class="form-wrap form-wrap-validation">
                      <input class="form-input" id="forms-login-password" type="password" name="passwd" data-constraints="@Required">
                      <label class="form-label" for="forms-login-password">Password</label>
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
    <script src="resources/js/core.min.js"></script>
    <script src="resources/js/script.js"></script>
  </body>
</html>