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
    <link rel="icon" href="resources/images/favicon.ico" type="image/x-icon">
    
    <%-- Stylesheets --%>
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/mdi.css">
    <link rel="stylesheet" href="resources/css/fl-bigmug-line.css">
    <link rel="stylesheet" href="resources/css/jjh-style.css">
    <script src="resources/js/jquery-1.12.4.min.js"></script>
    
		<%--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/">
    <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--%> 
    <script type="text/javascript">
    	$(document).ready(function(){
    		var offset = $(".jjh-top").offset(); // topCounter위치 파악
    		$(window).scroll(function(){ // 스크롤발생시 함수 실행
    			if($(document).scrollTop() > offset.top){ // 스크롤바 위치가 topCounter 수직 길이보다 아래
    				$(".jjh-top").addClass(".jjh-fixed");
    			}else{
    				$(".jjh-top").removeClass(".jjh-fixed");
    			}
    		});
    	});
    </script>
  </head>  
  <body>
    <%-- Page preloader--%>
    <jsp:include page="/WEB-INF/views/include/pageloader.jsp"/>
    
    <%-- Page--%>
    <div class="page">
      
       <%-- page Header START --%>
      <jsp:include page="/WEB-INF/views/include/header.jsp" />
      <%-- page Header END --%>
      
      <%-- Breadcrumbs--%>
      <section class="breadcrumbs-custom breadcrumbs-custom-svg bg-gradient breadcrumbs-background-01">
        <div class="shell">
          <p class="breadcrumbs-custom-subtitle">Product Catalog</p>
          <p class="heading-1 breadcrumbs-custom-title">Shop</p>
          <ul class="breadcrumbs-custom-path">
            <li><a href="index.html">Home</a></li>
            <li><a href="#">Shop</a></li>
            <li class="active">Ongoing Auction</li>
          </ul>
        </div>
      </section>

      <%--참여 경매 잔여 시간 표시 헤더 --%>
       <div class="jjh-top">
          <div class="countdown jjh-topCounter" data-time="2017/11/13 08:30:00" data-format="MM/DDHMS" data-type="until" data-layout="{dn} {dl} {hnn}{sep}{mnn}{sep}{snn}"></div>
       </div>
      
       
      <%-- product catalog--%>
      <section class="section section-lg bg-gray-lighter text-center">
        <div class="shell shell-wide" >
          <h3>product catalog</h3>
          <div class="divider divider-default"></div>
          <div class="range range-sm range-shop">
          
            <div class="cell-lg-10 ">
            
              <div class="range range-70 text-left">
              <%-- 여기에 자기 부분 넣어주세요 --%>
                <div class="range range-30 range-xs-center" style="z-index:1;">
                <%--리스트 한 단위 시작 --%>
                      <div class="cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3">
                        <div class="product product-counter product-auction">
                          <div class="product-counter-inner">
                            <div class="countdown jjh-counter" data-time="2017/11/12 17:30:00" data-format="MM/DDHMS" data-type="until" data-layout="{dn} {dl} {hnn}{sep}{mnn}{sep}{snn}"></div>
                          </div>
                          <div class="product-image "><a href="product-page.html"><img src="resources/images/flower.jpg" alt="" width="331" height="245"/></a></div>
                          <div class="product-title">
                            <h5><a href="product-page.html">Typhoon 4K Quadcopter — Black</a></h5>
                          </div>
                          <div class="jjh-price">
                            <div class="product-price">
                              <p>Start Price</p>
                              <h6>$125.00</h6>
                            </div>
                            <br>
                            <div class="jjh-currentPrice">
                              <p class=""><strong>Current Price</strong></p>
                              <h6>$320.00</h6>
                            </div>
                          </div>
                          <div class="product-button"><a class="jjh-listButton button-secondary" href="shopping-cart.html">Detail</a></div>
                        </div>
                      </div>
                      <%--리스트 한 단위 종료 --%>
                      
                      <div class="cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3">
                        <div class="product product-counter product-auction">
                          <div class="product-counter-inner">
                            <div class="countdown jjh-counter" data-time="2017/11/10 14:34:56" data-format="MM/DDHMS" data-type="until" data-layout="{dn} {dl} {hnn}{sep}{mnn}{sep}{snn}"></div>
                          </div>
                          <div class="product-image "><a href="product-page.html"><img src="resources/images/landing-auction-2-323x245.jpg" alt="" width="323" height="245"/></a></div>
                          <div class="product-title">
                            <h5><a href="product-page.html">Fyxation Eastside Crimson Roja – Bicicleta Urbana 1</a></h5>
                          </div>
                          <div class="product-price-wrap">
                            <div class="product-price">
                              <p>Start Price</p>
                              <h6>$190.00</h6>
                            </div>
                          </div>
                          <div class="product-button"><a class="button button-secondary" href="shopping-cart.html">submit a bid</a></div>
                        </div>
                      </div>
                      <div class="cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3">
                        <div class="product product-counter product-auction">
                          <div class="product-counter-inner">
                            <div class="countdown" data-time="2017/10/10 14:34:56" data-format="MM/DDHMS" data-type="until" data-layout="{dn} {dl} {hnn}{sep}{mnn}{sep}{snn}"></div>
                          </div>
                          <div class="product-image"><a href="product-page.html"><img src="resources/images/landing-auction-3-329x245.jpg" alt="" width="329" height="245"/></a></div>
                          <div class="product-title">
                            <h5><a href="product-page.html">Brass Reclining Deer</a></h5>
                          </div>
                          <div class="product-price-wrap">
                            <div class="product-price">
                              <p>Start Price</p>
                              <h6>$125.00</h6>
                            </div>
                          </div>
                          <div class="product-button"><a class="button button-secondary" href="shopping-cart.html">submit a bid</a></div>
                        </div>
                      </div>
                      <div class="cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3">
                        <div class="product product-counter product-auction">
                          <div class="product-counter-inner">
                            <div class="countdown" data-time="2017/10/9 14:34:56" data-format="MM/DDHMS" data-type="until" data-layout="{dn} {dl} {hnn}{sep}{mnn}{sep}{snn}"></div>
                          </div>
                          <div class="product-image"><a href="product-page.html"><img src="resources/images/landing-auction-4-318x245.jpg" alt="" width="318" height="245"/></a></div>
                          <div class="product-title">
                            <h5><a href="product-page.html">Zane Grey - Vanishing American (First Edition)</a></h5>
                          </div>
                          <div class="product-price-wrap">
                            <div class="product-price">
                              <p>Start Price</p>
                              <h6>$190.00</h6>
                            </div>
                          </div>
                          <div class="product-button"><a class="button button-secondary" href="shopping-cart.html">submit a bid</a></div>
                        </div>
                      </div>
                      <div class="cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3">
                        <div class="product product-counter product-auction">
                          <div class="product-counter-inner">
                            <div class="countdown" data-time="2017/10/10 14:34:56" data-format="MM/DDHMS" data-type="until" data-layout="{dn} {dl} {hnn}{sep}{mnn}{sep}{snn}"></div>
                          </div>
                          <div class="product-image"><a href="product-page.html"><img src="resources/images/landing-auction-5-331x245.jpg" alt="" width="331" height="245"/></a></div>
                          <div class="product-title">
                            <h5><a href="product-page.html">Lenovo K5 Note 4G <br class="veil reveal-md-inline">Phablet</a></h5>
                          </div>
                          <div class="product-price-wrap">
                            <div class="product-price">
                              <p>Start Price</p>
                              <h6>$125.00</h6>
                            </div>
                          </div>
                          <div class="product-button"><a class="button button-secondary" href="shopping-cart.html">submit a bid</a></div>
                        </div>
                      </div>
                      <div class="cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3">
                        <div class="product product-counter product-auction">
                          <div class="product-counter-inner">
                            <div class="countdown" data-time="2017/10/9 14:34:56" data-format="MM/DDHMS" data-type="until" data-layout="{dn} {dl} {hnn}{sep}{mnn}{sep}{snn}"></div>
                          </div>
                          <div class="product-image"><a href="product-page.html"><img src="resources/images/landing-auction-6-323x245.jpg" alt="" width="323" height="245"/></a></div>
                          <div class="product-title">
                            <h5><a href="product-page.html">Classic Accessories Roanoke Inflatable Pontoon Boat</a></h5>
                          </div>
                          <div class="product-price-wrap">
                            <div class="product-price">
                              <p>Start Price</p>
                              <h6>$190.00</h6>
                            </div>
                          </div>
                          <div class="product-button"><a class="button button-secondary" href="shopping-cart.html">submit a bid</a></div>
                        </div>
                      </div>
                      <div class="cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3">
                        <div class="product product-counter product-auction">
                          <div class="product-counter-inner">
                            <div class="countdown" data-time="2017/10/10 14:34:56" data-format="MM/DDHMS" data-type="until" data-layout="{dn} {dl} {hnn}{sep}{mnn}{sep}{snn}"></div>
                          </div>
                          <div class="product-image"><a href="product-page.html"><img src="resources/images/landing-auction-7-329x245.jpg" alt="" width="329" height="245"/></a></div>
                          <div class="product-title">
                            <h5><a href="product-page.html">Executive Victorian Desk With Rosa La Vanta Marble</a></h5>
                          </div>
                          <div class="product-price-wrap">
                            <div class="product-price">
                              <p>Start Price</p>
                              <h6>$125.00</h6>
                            </div>
                          </div>
                          <div class="product-button"><a class="button button-secondary" href="shopping-cart.html">submit a bid</a></div>
                        </div>
                      </div>
                      <div class="cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3">
                        <div class="product product-counter product-auction">
                          <div class="product-counter-inner">
                            <div class="countdown" data-time="2017/10/9 14:34:56" data-format="MM/DDHMS" data-type="until" data-layout="{dn} {dl} {hnn}{sep}{mnn}{sep}{snn}"></div>
                          </div>
                          <div class="product-image"><a href="product-page.html"><img src="resources/images/landing-auction-8-318x245.jpg" alt="" width="318" height="245"/></a></div>
                          <div class="product-title">
                            <h5><a href="product-page.html">Biomega- PEK – Bicicleta Carga</a></h5>
                          </div>
                          <div class="product-price-wrap">
                            <div class="product-price">
                              <p>Start Price</p>
                              <h6>$190.00</h6>
                            </div>
                          </div>
                          <div class="product-button"><a class="button button-secondary" href="shopping-cart.html">submit a bid</a></div>
                        </div>
                      </div>
                    <!-- </div><a class="button button-secondary" href="shop-3-columns-layout.html">view all auctions </a> -->
              </div>
              
              	<span><a class="button-blog button button-default-outline" href="#">load more products</a></span>
                <div class="jjh-newButton"><button class="button button-secondary " type="button">New Auction</button></div>
              <br>
            </div>
          </div>
          
            <%-- Shop Sidebar START --%>
            <jsp:include page="/WEB-INF/views/include/rightSidebar.jsp"></jsp:include>
            <%-- Shop Sidebar END --%>
        </div>
      </section>

      <%-- Page Footer--%>
      <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
     
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