<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="wide wow-animation" lang="en">
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
    <link rel="stylesheet" href="/resources/css/jjh-style.css">
	
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
    
      <%-- Page Header 시작--%>
      <header class="section page-header bg-gray-darker breadcrumbs-custom-wrap">  
        <%-- RD Navbar--%>
        <div class="rd-navbar-wrap rd-navbar-shop-header">
          <nav class="rd-navbar" data-layout="rd-navbar-fixed" data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fullwidth" data-md-device-layout="rd-navbar-fixed" data-lg-layout="rd-navbar-static" data-lg-device-layout="rd-navbar-static" data-md-stick-up-offset="100px" data-lg-stick-up-offset="150px" data-stick-up="true" data-sm-stick-up="true" data-md-stick-up="true" data-lg-stick-up="true">
            <div class="rd-navbar-top-panel">
              <div class="rd-navbar-nav-wrap">
                <%-- RD Navbar Nav--%>
                <ul class="rd-navbar-nav">
                  <li><a href="index.html">Home</a>
                  </li>
                  <li><a href="about-us.html">About Us</a>
                  </li>
                  <li><a href="#">Services</a>
                    <%-- RD Navbar Dropdown--%>
                    <ul class="rd-navbar-dropdown">
                      <li><a href="services.html">Services</a>
                      </li>
                      <li><a href="single-service.html">Single Service</a>
                      </li>
                    </ul>
                  </li>
                  <li><a href="#">Gallery</a>
                    <%-- RD Navbar Dropdown--%>
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
                    <%-- RD Navbar Dropdown--%>
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
                    <%-- RD Navbar Dropdown--%>
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
                    <%-- RD Navbar Megamenu--%>
                    <ul class="rd-navbar-megamenu rd-navbar-megamenu-banner">
                      <li><img src="/resources/images/accordions-1-570x600.jpg" alt="" width="570" height="600"/>
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
            
            <%-- Page 상단 로고 시작--%>
            <div class="rd-navbar-inner">
              <%-- RD Navbar Panel--%>
              <div class="rd-navbar-panel">
                <%-- RD Navbar Toggle--%>
                <button class="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar-nav-wrap"><span></span></button>
                <%-- RD Navbar Brand--%>
                <div class="rd-navbar-brand"><a class="brand-name" href="index.html"><img class="logo-default" src="/resources/images/logo-default-173x55.png" alt="" width="173" height="55"/><img class="logo-inverse" src="/resources/images/logo-inverse-173x55.png" alt="" width="173" height="55"/></a></div>
              </div>
            </div>
            <%-- Page 상단 로고 종료--%>
            
          </nav>
        </div>
      </header>
      <%-- Page Header 종료--%>
      
      
      <%-- Formatting forms START --%>
      <section class="section section-lg bg-white text-center">
        <div class="shell">
          <div class="range range-xs-center">
            <div class="cell-sm-10 cell-lg-8">
              <h3>Join Us</h3>
              <%-- RD Mailform--%>
              <form class="rd-mailform text-left" data-form-output="form-output-global" data-form-type="contact" method="post" action="/member/register">
                <div class="range range-20">
                  <div class="cell-sm-6">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="forms-3-name">ID</label>
                      <input class="form-input" id="forms-3-name" type="text" name="memberId" data-constraints="@Required" placeholder="ID">
                    </div>
                  </div>
                  <div class="cell-sm-3">
                  	<div class="form-wrap-validation">
                    	<button type="button" class="button button-secondary jjh-postCodeSearchBtn">check ID</button>
                    </div>
                 </div>
                 
                 <div class="cell-sm-6">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="forms-3-name">Password</label>
                      <input class="form-input" id="forms-3-name" type="text" name="passwd" data-constraints="@Required" placeholder="Password">
                    </div>
                  </div>
                  <div class="cell-sm-6">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="forms-3-name">Password Check</label>
                      <input class="form-input" id="forms-3-name" type="text" name="passwordCheck" data-constraints="@Required" placeholder="Password Check">
                    </div>
                  </div>
                  
                 
                  <div class="cell-sm-12">
                  	<div class="form-wrap form-wrap-validation">
                    	<label class="form-label-outside" for="forms-3-last-name">Name</label>
                    	<input class="form-input" id="forms-3-last-name" type="text" name="name" data-constraints="@Required" placeholder="Name">
                 	</div>
               	 </div>
               	 
                  <div class="cell-sm-6">	
                  	<label class="form-label-outside">Address</label>
                 	<div class="form-wrap form-wrap-inline">
                    	<input class="form-input" id="sample6_postcode" type="text" name="zipcode" placeholder="우편번호">
                 	</div>
                </div>
           		<div class="cell-sm-3">
                	<div class="form-wrap-validation">
                    	<button type="button" class="button button-secondary jjh-postCodeSearchBtn"  onclick="sample6_execDaumPostcode()">POSTAL CODE</button>
                	</div>
            	</div>
              	<div class="cell-xs-12">
                	<div class="form-wrap form-wrap-inline">
                    	<input class="form-input" id="sample6_address" type="text" name="baseaddress" placeholder="기본주소">
                    </div>
               		<div class="form-wrap form-wrap-inline">
                    	<input class="form-input" id="sample6_address2" type="text" name="detailaddress" placeholder="상세주소">
                  	</div>
              	</div>
              	
                  <div class="cell-sm-12">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="forms-3-name">E-Mail</label>
                      <input class="form-input" id="forms-3-name" type="text" name="email" data-constraints="@Required" placeholder="E-Mail">
                    </div>
                  </div>
                  
                   <div class="cell-sm-10">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="forms-3-name">Phone</label>
                      <input class="form-input" id="forms-3-name" type="text" name="phoneNumber" data-constraints="@Required" placeholder="-없이 숫자만 입력해주세요" >
                    </div>
                  </div>
                  
                 <div class="cell-sm-12">
                 <label class="form-label-outside" for="forms-3-name">Account</label>
                    <div class="form-wrap form-wrap-validation">
                      <div class="col-sm-3">
                      <!-- Dropdown list-->
			                <!-- Select 2-->
			                <select class="col-sm-2 form-control select-filter" data-placeholder="All" data-minimum-results-for-search="Infinity" data-constraints="@Selected" name="bank">
			                  <option label="계좌종류"> </option>
			                  <option value="1" selected="">국민</option>
			                  <option value="2">농협</option>
			                  <option value="3">신한</option>
			                </select>
			           </div>
			          <div class="col-sm-9">
                      	<input class="cell-sm-8 form-input" id="forms-3-name" type="text" name="accountNumber" data-constraints="@Required" placeholder="-없이 숫자만 입력해주세요" >
                      </div>
                    </div>
                  </div>
                  
                  <div class="cell-sm-8"></div>
                  <div class="cell-sm-3">
                	<div class="form-wrap-validation">
                    	<button type="submit" class="button button-secondary jjh-postCodeSearchBtn" > SUBMIT</button>
                	</div>
            	</div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>
       <%-- Formatting forms END --%>
      
      <%-- Page Footer--%>
      <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
     
    </div>
    <%-- PANEL--%>
    <%-- END PANEL--%>
    <%-- Global Mailform Output--%>
    <div class="snackbars" id="form-output-global"></div>
    
    <%-- Javascript--%>
    <script src="/resources/js/core.min.js"></script>
    <script src="/resources/js/script.js"></script>
    
    <%--다음API 주소 적용 --%>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script type="text/javascript" >
        function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
    
                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var fullAddr = ''; // 최종 주소 변수
                    var extraAddr = ''; // 조합형 주소 변수
    
                    // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        fullAddr = data.roadAddress;
    
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        fullAddr = data.jibunAddress;	 
                    }
    
                    // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                    if(data.userSelectedType === 'R'){
                        //법정동명이 있을 경우 추가한다.
                        if(data.bname !== ''){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있을 경우 추가한다.
                        if(data.buildingName !== ''){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                        fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                    }
    
                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                    document.getElementById('sample6_address').value = fullAddr;
    
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById('sample6_address2').focus();
                }
            }).open();
        }
    </script>
  </body>
</html>