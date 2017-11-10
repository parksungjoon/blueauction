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
      <header class="section page-header">
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
            <div class="rd-navbar-inner">
              <!-- RD Navbar Panel-->
              <div class="rd-navbar-panel">
                <!-- RD Navbar Toggle-->
                <button class="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar-nav-wrap"><span></span></button>
                <!-- RD Navbar Brand-->
                <div class="rd-navbar-brand"><a class="brand-name" href="WEB-INF/views/templates/index.html"><img class="logo-default" src="/resources/images/logo-default-173x55.png" alt="" width="173" height="55"/><img class="/resources/logo-inverse" src="/resources/images/logo-inverse-173x55.png" alt="" width="173" height="55"/></a></div>
              </div>
              <div class="rd-navbar-aside-center">
                <!-- RD Navbar Search-->
                <div class="rd-navbar-search"><a class="rd-navbar-search-toggle" data-rd-navbar-toggle=".rd-navbar-search" href="#"><span></span></a>
                  <form class="rd-search" action="search-results.html" data-search-live="rd-search-results-live" method="GET">
                    <div class="rd-mailform-inline rd-mailform-sm rd-mailform-inline-modern">
                      <div class="rd-mailform-inline-inner">
                        <div class="form-wrap form-wrap-icon mdi-magnify">
                          <label class="form-label form-label" for="rd-navbar-search-form-input">Search...</label>
                          <input class="rd-navbar-search-form-input form-input" id="rd-navbar-search-form-input" type="text" name="s" autocomplete="off">
                          <div class="rd-search-results-live"></div>
                        </div>
                        <button class="rd-search-form-submit rd-search-form-submit-icon mdi mdi-magnify"></button>
                        <button class="rd-search-form-submit button form-button button-sm button-secondary">search</button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
              <div class="rd-navbar-aside-right">
                <div class="rd-navbar-shop"><a class="rd-navbar-shop-icon mdi mdi-cart" href="WEB-INF/views/templates/shopping-cart.html"><span>2</span></a></div>
              </div>
            </div>
          </nav>
        </div>
      </header>


      <section class="section section-lg bg-white">
        <div class="shell shell-wide">
          <div class="range range-50 range-md-center">
            <div class="cell-md-11 cell-lg-10 cell-xl-6">
              <div class="tabs-custom tabs-horizontal tabs-line text-center" id="tabs-1">
                <!-- Nav tabs-->
                <ul class="nav nav-tabs nav-tabs-checkout">
                  <li class="active"><a href="#tabs-1-1" data-toggle="tab">회원 정보</a></li>
                  <li><a href="#tabs-1-2" data-toggle="tab">경매 참여 리스트</a></li>
                  <li><a href="#tabs-1-3" data-toggle="tab">중고 참여 리스트</a></li>
                  
                </ul>
                <!-- Tab panes-->
                <div class="tab-content">
                  <div class="tab-pane fade in active" id="tabs-1-1">
                    <form class="rd-mailform text-left" data-form-output="form-output-global" data-form-type="contact" method="post" action="bat/rd-mailform.php">
                      <div class="range range-20">
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-name">First name</label>
                            <input class="form-input" id="forms-3-name" type="text" name="name" data-constraints="@Required">
                          </div>
                        </div>
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-last-name">Last name</label>
                            <input class="form-input" id="forms-3-last-name" type="text" name="last-name" data-constraints="@Required">
                          </div>
                        </div>
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-company">zipcode</label>
                            <input class="form-input" id="forms-3-company" type="text" name="company">
                          </div>
                        </div>
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">baseaddress</label>
                            <input class="form-input" id="forms-3-city" type="text" name="city">
                          </div>
                        </div>
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="form-1-email">detailadress</label>
                            <input class="form-input" id="form-1-email" type="email" name="email" data-constraints="@Email @Required">
                          </div>
                        </div>
                      
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="form-1-phone">email</label>
                            <input class="form-input" id="form-1-phone" type="text" name="phone" data-constraints="@Numeric @Required">
                          </div>
                        </div>
                        <!-- <div class="cell-xs-12"> -->
                         <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-street-address">accountnumber</label>
                            <input class="form-input" id="forms-3-street-address" type="text" name="street-address">
                          </div>
                        </div>
                         <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-street-address">bank</label>
                            <input class="form-input" id="forms-3-street-address" type="text" name="street-address">
                          </div>
                        </div>
                        <div class="cell-md-12 offset-custom-1">
                          <div class="form-button text-sm-right">
                            <button class="button button-secondary" type="submit">checkout</button>
                          </div>
                        </div>
                      </div>
                    </form>
                  </div>
                  <div class="tab-pane fade" id="tabs-1-2">
                    <div class="table-checkout text-left">
                      <div class="table-novi table-custom-responsive">
                        <table class="table-custom">
                          <tbody>
                            <tr>
                              <td>Cart Subtotal</td>
                              <td>$58.00</td>
                            </tr>
                            <tr>
                              <td>Shipping</td>
                              <td>Free Delivery</td>
                            </tr>
                            <tr>
                              <td>Total</td>
                              <td>$58.00</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                      <div class="form-wrap">
                        <ul class="radio-group">
                          <li>
                            <label class="radio-inline">
                              <input type="radio" name="radio-group" checked="">Direct Bank Transfer
                            </label>
                          </li>
                          <li>
                            <label class="radio-inline">
                              <input type="radio" name="radio-group">Cheque Payment
                            </label>
                          </li>
                          <li>
                            <label class="radio-inline">
                              <input type="radio" name="radio-group">Paypal
                            </label>
                          </li>
                        </ul>
                      </div><a class="button button-secondary" href="#">place order</a>
                    </div>
                  </div>
                  <div class="tab-pane fade" id="tabs-1-3">
                    <div class="table-checkout text-left">
                      <div class="table-novi table-custom-responsive">
                        <table class="table-custom">
                          <tbody>
                            <tr>
                              <td>Cart Subtotal</td>
                              <td>$58.00</td>
                            </tr>
                            <tr>
                              <td>Shipping</td>
                              <td>Free Delivery</td>
                            </tr>
                            <tr>
                              <td>Total</td>
                              <td>$58.00</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                      <div class="form-wrap">
                        <ul class="radio-group">
                          <li>
                            <label class="radio-inline">
                              <input type="radio" name="radio-group" checked="">Direct Bank Transfer
                            </label>
                          </li>
                          <li>
                            <label class="radio-inline">
                              <input type="radio" name="radio-group">Cheque Payment
                            </label>
                          </li>
                          <li>
                            <label class="radio-inline">
                              <input type="radio" name="radio-group">Paypal
                            </label>
                          </li>
                        </ul>
                      </div><a class="button button-secondary" href="#">place order</a>
                    </div>
                  </div>
                </div>
              </div>
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