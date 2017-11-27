<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="wide wow-animation" lang="en">
  <head>
    <!-- Site Title-->
    <title>Home</title>
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
    <link rel="stylesheet" href="/resources/css/hideSearch.css">
		<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--> 
  <script src="/resources/js/jquery-1.12.4.min.js"></script>
  <script src="/resources/js/countdown.js"></script>
  <script src="/resources/js/index_list.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		
  		$.ajax({
  			type:"post",
  			dataType:"json",
  			url:"/product/index",
  			success:function(data){
  				
  				printList(data);
  			}
  		});
  	});
  		
  </script>
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
      
      <%-- page Header START --%>
      <jsp:include page="/WEB-INF/views/include/header.jsp" />
      <%-- page Header END --%>
      
      <%-- 배너 부분 시작 --%>
      <section class="section">
        <div class="range range-condensed">
          <div class="cell-lg-7 cell-xl-8 reveal-lg-flex"> 
            <div class="box-auction-large-left bg-primary">
              <div class="box-auction-large-inner">
                <div class="heading-group">
                  <p class="heading-3 text-elight">blue</p>
                  <h1>auction</h1>
                  <p class="heading-3 text-elight">for the whole family</p>
                </div>
                  <p class="heading-5">Blue Auction helps you sell your used products</p>
                   <c:if test="${empty login }">
                     <a class="button button-secondary" href="/member/register">Join Us</a>
                   </c:if>
              </div>
            </div>
          </div>
          <div class="cell-lg-5 cell-xl-4">
            <div class="box-auction-wrap">
              <div class="box-auction-minimal-left bg-gray-darker">
                <div class="box-auction-inner"><a class="box-auction-image box-auction-image-mod-1" > <img src="/resources/images/landing-auction-11-230x469.png" alt="" width="230" height="469"/></a></div>
                <div class="box-auction-inner box-auction-inner-content">
                  <div class="box-auction-title"> <a href="product-page.html">Used Products</a></div>
                  <div class="divider divider-secondary divider-sm"></div>
                  <div class="product-price">
                    <p>중고 상품을 판매 합니다</p>
                    <h6></h6>
                  </div>
                  <div class="box-auction-button"><a class="button button-secondary button-sm" href="/product/used">Show Products</a></div>
                </div>
              </div>
              <div class="box-auction-minimal-right bg-secondary-2">
                <div class="box-auction-inner"><a class="box-auction-image box-auction-image-mod-2"><img src="/resources/images/landing-auction-12-377x267.png" alt="" width="377" height="267"/></a></div>
                <div class="box-auction-inner box-auction-inner-content">
                  <div class="box-auction-title"><a href="product-page.html">Auction Products</a></div>
                  <div class="divider divider-secondary divider-sm"></div>
                  <div class="product-price">
                    <p>경매 상품을 판매 합니다</p>
                    <h6></h6>
                  </div>
                  <div class="box-auction-button"><a class="button button-secondary button-sm" href="/product/auction/1/0">Show Auctions</a></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <%-- 배너 부분 종료 --%>
      
      <%-- 경매 방식 설명 시작 --%>
      <section class="section section-lg text-center">
        <div class="shell-wide">
          <h3>USED PRODUCT how it buy</h3>
          <div class="divider divider-default"></div>
          <div class="range range-xs-center range-50">
            <div class="cell-sm-9 cell-md-6 cell-lg-3">
              <div class="thumbnail-classic unit unit-sm-horizontal unit-md-vertical unit-md-horizontal unit-lg-vertical">
                <div class="thumbnail-classic-icon unit-left"><span class="icon">01</span></div>
                <div class="thumbnail-classic-caption unit-body">
                  <h6 class="thumbnail-classic-title">register</h6>
                  <hr class="divider divider-default divider-sm"/>
                  <p class="thumbnail-classic-text">중고 상품 등록</p>
                </div>
              </div>
            </div>
            <div class="cell-sm-9 cell-md-6 cell-lg-3">
              <div class="thumbnail-classic unit unit-sm-horizontal unit-md-vertical unit-md-horizontal unit-lg-vertical">
                <div class="thumbnail-classic-icon unit-left"><span class="icon">02</span></div>
                <div class="thumbnail-classic-caption unit-body">
                  <h6 class="thumbnail-classic-title">chat or reply</h6>
                  <hr class="divider divider-default divider-sm"/>
                  <p class="thumbnail-classic-text">상품 확인을 위해  <br>
                  									판매자와 채팅/쪽지/댓글</p>
                </div>
              </div>
            </div>
            <div class="cell-sm-9 cell-md-6 cell-lg-3">
              <div class="thumbnail-classic unit unit-sm-horizontal unit-md-vertical unit-md-horizontal unit-lg-vertical">
                <div class="thumbnail-classic-icon unit-left"><span class="icon">03</span></div>
                <div class="thumbnail-classic-caption unit-body">
                  <h6 class="thumbnail-classic-title">Order</h6>
                  <hr class="divider divider-default divider-sm"/>
                  <p class="thumbnail-classic-text">원하는 상품 주문</p>
                </div>
              </div>
            </div>
            <div class="cell-sm-9 cell-md-6 cell-lg-3">
              <div class="thumbnail-classic unit unit-sm-horizontal unit-md-vertical unit-md-horizontal unit-lg-vertical">
                <div class="thumbnail-classic-icon unit-left"><span class="icon">04</span></div>
                <div class="thumbnail-classic-caption unit-body">
                  <h6 class="thumbnail-classic-title">Delivery</h6>
                  <hr class="divider divider-default divider-sm"/>
                  <p class="thumbnail-classic-text">중고 상품 수령</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <%-- 경매 방식 설명 종료 --%>
      
      <%-- 최근 중고 보기 시작 --%>
      <section class="section section-lg bg-gray-lighter text-center">
        <div class="shell shell-wide">
          <h3>Recent Used</h3>
          <div class="divider divider-default"></div>
          <div id="jjh-usedList" class="range range-30" style="z-index:1;">
          <%-- 중고 리스트 들어 가는 곳 --%>
          </div>
        </div>
            
      </section>
      <%-- 최근 중고 보기 종료 --%>
      
        <%-- 경매 방식 설명 시작 --%>
      <section class="section section-lg text-center">
        <div class="shell-wide">
          <h3>Auction how it works</h3>
          <div class="divider divider-default"></div>
          <div class="range range-xs-center range-50">
            <div class="cell-sm-9 cell-md-6 cell-lg-3">
              <div class="thumbnail-classic unit unit-sm-horizontal unit-md-vertical unit-md-horizontal unit-lg-vertical">
                <div class="thumbnail-classic-icon unit-left"><span class="icon">01</span></div>
                <div class="thumbnail-classic-caption unit-body">
                  <h6 class="thumbnail-classic-title">register</h6>
                  <hr class="divider divider-default divider-sm"/>
                  <p class="thumbnail-classic-text">경매 상품 등록</p>
                </div>
              </div>
            </div>
            <div class="cell-sm-9 cell-md-6 cell-lg-3">
              <div class="thumbnail-classic unit unit-sm-horizontal unit-md-vertical unit-md-horizontal unit-lg-vertical">
                <div class="thumbnail-classic-icon unit-left"><span class="icon">02</span></div>
                <div class="thumbnail-classic-caption unit-body">
                  <h6 class="thumbnail-classic-title">Buy or Bid</h6>
                  <hr class="divider divider-default divider-sm"/>
                  <p class="thumbnail-classic-text">매정각마다 30분간 진행</p>
                </div>
              </div>
            </div>
            <div class="cell-sm-9 cell-md-6 cell-lg-3">
              <div class="thumbnail-classic unit unit-sm-horizontal unit-md-vertical unit-md-horizontal unit-lg-vertical">
                <div class="thumbnail-classic-icon unit-left"><span class="icon">03</span></div>
                <div class="thumbnail-classic-caption unit-body">
                  <h6 class="thumbnail-classic-title">Submit a Bid</h6>
                  <hr class="divider divider-default divider-sm"/>
                  <p class="thumbnail-classic-text">원하는 상품에 입찰</p>
                </div>
              </div>
            </div>
            <div class="cell-sm-9 cell-md-6 cell-lg-3">
              <div class="thumbnail-classic unit unit-sm-horizontal unit-md-vertical unit-md-horizontal unit-lg-vertical">
                <div class="thumbnail-classic-icon unit-left"><span class="icon">04</span></div>
                <div class="thumbnail-classic-caption unit-body">
                  <h6 class="thumbnail-classic-title">Win</h6>
                  <hr class="divider divider-default divider-sm"/>
                  <p class="thumbnail-classic-text">가장 높은 가격을 제시한 사람 낙찰</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <%-- 경매 방식 설명 종료 --%>
      
      <%-- 최근 경매 보기 시작 --%>
      <section class="section section-lg bg-gray-lighter text-center">
        <div class="shell shell-wide">
          <h3>Current Auctions</h3>
          <div class="divider divider-default"></div>
          <div id="jjh-auctionList" class="range range-30" style="z-index:1;">
          <%-- 경매 리스트 들어가는 곳 --%>
           </div>
         </div>
      </section>
      <%-- 최근 경매 보기 종료 --%>
      
      <!-- Page Footer-->
      <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
      
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