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
      <%@include file = "include/header.jsp" %>
      <!--해더종료  -->


      <section class="section section-lg bg-white">
    
        <div class="shell shell-wide">
          
          <div class="range range-50 range-md-center">
            <div class="cell-md-11 cell-lg-10 cell-xl-6">
            
              <div class="tabs-custom tabs-horizontal tabs-line text-center" id="tabs-1">
                <!-- Nav tabs-->
                <ul class="nav nav-tabs nav-tabs-checkout">
                  <li class="active"><a href="#tabs-1-1" data-toggle="tab">회원 정보</a></li>
                 
                  
                </ul>
                <!-- Tab panes-->
                
                <div class="tab-content">
                  <div class="tab-pane fade in active" id="tabs-1-1">
                  <%@include file="include/rightSidebar.jsp" %>
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