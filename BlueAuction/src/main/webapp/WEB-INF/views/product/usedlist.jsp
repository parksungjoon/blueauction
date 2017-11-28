<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html class="wide wow-animation" lang="en">

  <head>
    <!-- Site Title-->
    <title>Used Item</title>
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
    <link rel="stylesheet" href="/resources/css/usedlist.css">
    
    <script src="/resources/js/jquery-1.12.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
    
		<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--> 
    
    <script id="template" type="text/x-handlebars-template">
	{{#each .}}
    	 <div class="col-xs-12 col-sm-6 col-md-4 isotope-item template-list" data-filter="{{smallid}}">
			<a id="/product/used/{{productId}}" class="gallery-item titled-gallery-item item-image" href="#">
         		<div class="gallery-item-image">
         			<figure><img class="productimage" src="/resources/images/img{{mainphoto}}" alt="{{auctionstate}}" width="570" height="380"/></figure>
         			<div class="caption"></div>
         		</div>
			</a>
        	 <div class="titled-gallery-caption"><a class="godetail" href="/product/used/{{productId}}">{{name}}</a></div>
         </div>
	{{/each}}         
    </script>
    
    <script type="text/javascript">
    
    var page = 1;
    var perPageNum = 9;
    var keyword = null;
    var smallid = 0;
    
    $(document).ready(function() {
    	var list = ${list};
	    printList(list);
	});
    
    /* 상품 결제 여부 확인 */
    function isPaid() {
		var imgTags = $('.productimage');
		for (var i = 0; i < imgTags.length; i++) {
			if (imgTags.get(i).getAttribute('alt') == 'AFTER') {
				imgTags.get(i).setAttribute("class", "productimage paid");
			}	
		}
	}
    
    /* 중고물품 리스트 출력 */
    function printList(list) {
    	var template = Handlebars.compile($("#template").html());
        var html = template(list);
        $("#products").html(html);
	    var productCount = $(".template-list").size();
	    $("#btn-load").show();
		if (productCount >= ${count}) {
		$("#btn-load").hide();
		}
		isPaid();
		
    };
    
    /* 상품 더 보기 */
    $(document).on("click", ".load-more-products", function(){
    	perPageNum += 9;
  		getMoreList();
	});
    
    /* 분류별 상품 보기 */
    $(document).on("click", ".type", function(e) {
    	e.preventDefault();
		smallid = $(this).attr("data-isotope-filter");
		getMoreList();
		$(this).parents(".isotope-filters").find('.active').removeClass("active");
		$(this).addClass("active");
	})
    
    /* 리스트 불러오기 */
    function getMoreList() {
    	$.ajax({
  			type: "post",
  			data : {page:page, perPageNum:perPageNum, keyword:keyword, smallid:smallid},
  			dataType : "json ",
  			url: "/product/used/",
  			success : function(data){
  				$("#rd-navbar-search-form-input").val("");
  				printList(data.list)
  				var productCount = $(".template-list").size();
  				var height = (productCount/3) * 442;
  				$('#products').css('height', height + "px"); 
  				$("#btn-load").show();
  				if (productCount >= data.count) {
					$("#btn-load").hide();
				}
  				
  				isPaid();
  			} 			
  		});
	}
    
    /* 검색 */
	$(document).on("click", ".button-secondary", function() {
		keyword = $("#rd-navbar-search-form-input").val();
		perPageNum = 9;
		getMoreList();
	});
    
    
    $(document).on("click", ".item-image", function(e) {
		e.preventDefault();
		location.href = $(this).attr("id");
	})
    
    </script>
    
  </head>
  
  <body>
    <%-- Page preloader--%>
    <jsp:include page="/WEB-INF/views/include/pageloader.jsp"/>
    <!-- Page-->
    <div class="page">
      <%-- page Header START --%>
      <jsp:include page="/WEB-INF/views/include/header.jsp" />
      <%-- page Header END --%>
      
      <!-- Breadcrumbs-->
      <section class="breadcrumbs-custom breadcrumbs-custom-svg bg-gradient breadcrumbs-background-01">
        <div class="shell">
          <p class="breadcrumbs-custom-subtitle">Used Stuff</p>
          <p class="heading-1 breadcrumbs-custom-title">Product List</p>
          <ul class="breadcrumbs-custom-path">
            <li><a href="/">Home</a></li>
            <li><a href="/product/used">Used</a></li>
            <li class="active">List</li>
          </ul>
        </div>
      </section>

      <!-- titled Grid gallery-->
      <section class="section section-lg text-center bg-white">
      <a id="register" class="button-blog btn btn-primary" href="/product/used/register">Register Product</a>
        <div class="shell-wide">
          <h3>our products</h3>
          <div class="isotope-wrap range range-0">
            <!-- Isotope Filters-->
            <div class="cell-lg-12">
              <ul class="isotope-filters isotope-filters-horizontal">
                <li class="block-top-level">
                  <p class="big">Choose your category:</p>
                  <!-- Isotope Filters-->
                  <button class="isotope-filters-toggle button button-xs button-primary" data-custom-toggle=".isotope-filters-list" data-custom-toggle-hide-on-blur="true">Filter<span class="caret"></span></button>
                  <ul class="isotope-filters-list">
                    <li><a class="active type" data-isotope-filter="0" data-isotope-group="gallery-01" href="#">All Categories</a></li>
                    <li><a class="type" data-isotope-filter="1" data-isotope-group="gallery-01" href="#">Clothes</a></li>
                    <li><a class="type" data-isotope-filter="2" data-isotope-group="gallery-01" href="#">Sundries</a></li>
                    <li><a class="type" data-isotope-filter="3" data-isotope-group="gallery-01" href="#">Ticket</a></li>
                    <li><a class="type" data-isotope-filter="4" data-isotope-group="gallery-01" href="#">Electronics</a></li>
                  </ul>
                </li>
              </ul>
            </div>
            <!-- Isotope Content-->
            <div class="cell-lg-12">
              <div id="products" class="isotope isotope-titled-gallery" data-isotope-layout="fitRows" data-isotope-group="gallery-01" data-lightgallery="group">
              <div class="row"></div>
          </div>
        <button id="btn-load" class="button-blog button button-default-outline load-more-products" >load more products</button>
        </div>
        </div>
        </div>
      </section>

     <%-- Page Footer--%>
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