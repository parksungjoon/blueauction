<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    
  <script src="/resources/js/jquery-1.12.4.min.js"></script>
  <script type="text/javascript">
  	
  	var page;
  	
  	$(document).ready(function(){
  		
  		init();
  		
  		 $(".jjh-pageLoader").click(function(event) {
  			alert("이벤트 수행!!");
  			
  			page = page + 1;
  			alert(page);
  			
  	  		$.ajax({
  	  			type: "post",
  	  			url: "/product/auction/1/" + page,
  	  			success:function(data){
  	  			for (var i in data.list) {
					console.log(data.list[i].name);
				}
					print(data);
  	  			} 			
  	  		});
  	  	}); 
  	});
  	
  	function print(data){
  		var list = data.list;
  		
  	 	var html = "";

  		   for ( var i in list) {
  			html +="<div class='cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3'>";
  	  		html +="      <div class='product product-counter product-auction'>";
  	  		html +="         <div class='product-counter-inner'>";
  	  		html +="          <div class='jjh-counter' >" + list[i].auctionstart + "</div>";
  	  		html +="        </div>";
  	  		html +="        <div class='product-image '><a href='product-page.html'><img src='/resources/pro-img/bicycle.jpg' alt='' width='331' height='245'/></a></div>";
  	  		html +="        <div class='product-title'>";
  	  		html +="          <h5>" + list[i].name +"</h5>";
  	  		html +="        </div>";
  	  		html +="        <div class='product-price-wrap'>";
  	  		html +="          <div class='product-price'>";
  	  		html +="            <p>Start Price</p>";
  	  		html +="            <h6>" + list[i].basicprice + "원</h6>";
  	  		html +="          </div>";
  	  		html +="        </div>";
  	  		html +="        <div class='product-button'><a class='jjh-listButton button-secondary' href='shopping-cart.html'>Detail</a></div>";
  	  		html +="        <button class='jjh-favoriteButton'><img alt='favorite-register' src='/resources/images/empty-heart.png'></button>";
  	  		html +="      </div>";
  	  		html +="    </div>";
		}   
     $(".auction-list").append(html);
  	}
  	
  	function init(){
  		page = 1;
  		
  		$.ajax({
  			type: "post",
  			url: "/product/auction/1/" + page,
  			success:function(data){
  				
  				for ( var i in data.list) {
					console.log(data.list[i].name);
				}
  				print(data);
  			} 			
  		});
  	}
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
            <li class="active">Preparing Auction</li>
          </ul>
        </div>
      </section>

      <%-- product catalog--%>
      <section class="section section-lg bg-gray-lighter text-center">
        <div class="shell shell-wide" >
          <h3>product catalog</h3>
          <div class="divider divider-default"></div>
          <div class="range range-sm range-shop">
          
            <div class="cell-lg-10 ">
            
              <div class="range range-70 text-left">
              <%-- 여기에 자기 부분 넣어주세요 --%>
                  <div class="range range-30 auction-list" style="z-index:1;">
                 <%--  <c:if test="${type == 1}">
                    <c:forEach items="${list}" var="product">
                     리스트 한 단위 시작
                        <div class="cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3">
                          <div class="product product-counter product-auction">
                            <div class="product-counter-inner">
                              <div class="jjh-counter" >${product.auctionstart }</div>
                            </div>
                            <div class="product-image "><a href="product-page.html"><img src="/resources/pro-img/bicycle.jpg" alt="" width="331" height="245"/></a></div>
                            <div class="product-title">
                              <h5>${product.name }</h5>
                            </div>
                            <div class="product-price-wrap">
                              <div class="product-price">
                                <p>Start Price</p>
                                <h6>${product.basicprice }원</h6>
                              </div>
                            </div>
                            <div class="product-button"><a class="jjh-listButton button-secondary" href="shopping-cart.html">Detail</a></div>
                            <button class="jjh-favoriteButton"><img alt="favorite-register" src="/resources/images/empty-heart.png"></button>
                          </div>
                        </div>
                        리스트 한 단위 종료
                      <!-- </div><a class="button button-secondary" href="shop-3-columns-layout.html">view all auctions </a> -->
                </c:forEach>
              </c:if> --%>
            </div>
              
              	<span><a class="button-blog button button-default-outline jjh-pageLoader" href="#" >load more products</a></span>
                <div class="jjh-newButton"><button class="button button-secondary " type="button">New Auction</button></div>
              <br>
            </div>
          </div>
          
            <%-- Shop Sidebar START --%>
            <jsp:include page="/WEB-INF/views/include/rightSidebar.jsp"></jsp:include>
            <%-- Shop Sidebar END --%>
        </div>
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
    <script src="/resources/js/core.min.js"></script>
    <script src="/resources/js/script.js"></script>
    
  </body>
</html>