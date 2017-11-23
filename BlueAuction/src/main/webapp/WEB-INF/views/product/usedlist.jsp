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
    
    <script src="/resources/js/jquery-1.12.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
		<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--> 
    
    <script id="template" type="text/x-handlebars-template">
	{{#each .}}
    	 <div class="col-xs-12 col-sm-6 col-md-4 isotope-item template-list" data-filter="{{smallid}}">
			<a class="gallery-item titled-gallery-item" href="/resources/images/img{{mainphoto}}" data-lightgallery="group-item">
         		<div class="gallery-item-image">
         			<figure><img class="productimage" src="/resources/images/img{{mainphoto}}" alt="" width="570" height="380"/></figure>
         			<div class="caption"></div>
         		</div>
			</a>
        	 <div class="titled-gallery-caption"><a class="godetail" href="/product/used/{{productId}}">{{name}}</a></div>
         </div>
	{{/each}}         
    </script>
    
    <style type="text/css">
      .productimage {
        max-width: 570px;
        max-height: 380px;
      }
    </style>
    
    <script type="text/javascript">
    
    var page = 9;
    var keyword = null;
    
    $(document).ready(function() {
    	var list = ${list};
	    printList(list);
	    
	});
    
    /* 중고물품 리스트 출력 */
    function printList(list) {

    	var template = Handlebars.compile($("#template").html());
				
        var html = template(list);
        
        $("#products").html(html);
    	
    };
    
    /* 상품 더 보기 */
    $(document).on("click", ".load-more-products", function(){
			
    	page += 9;
    	
  		getMoreList();
	  		
	});
    
    /* 리스트 불러오기 */
    function getMoreList() {
    	$.ajax({
  			type: "post",
  			data : {page:page, keyword:keyword},
  			dataType : "json ",
  			url: "/product/used/",
  			success : function(data){
  				printList(data.list)
  				var productCount = $(".template-list").size();
  				$("#btn-load").show();
  				if (productCount >= data.count) {
					$("#btn-load").hide();
				}
  			} 			
  		});
	}
	
    
    /* 검색 */
	$(document).on("click", ".button-secondary", function() {
		
		keyword = $("#rd-navbar-search-form-input").val();
		page = 9;
		getMoreList();
		
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
            <li><a href="index.html">Home</a></li>
            <li><a href="#">Used</a></li>
            <li class="active">List</li>
          </ul>
        </div>
      </section>

      <!-- titled Grid gallery-->
      <section class="section section-lg text-center bg-white">
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
                    <li><a class="active type" data-isotope-filter="*" data-isotope-group="gallery-01" href="#">All Categories</a></li>
                    <li><a class="type" data-isotope-filter="1" data-isotope-group="gallery-01" href="#">Clothes</a></li>
                    <li><a class="type" data-isotope-filter="3" data-isotope-group="gallery-01" href="#">Ticket</a></li>
                    <li><a class="type" data-isotope-filter="4" data-isotope-group="gallery-01" href="#">Electronics</a></li>
                    <li><a class="type" data-isotope-filter="2" data-isotope-group="gallery-01" href="#">Others</a></li>
                  </ul>
                </li>
              </ul>
            </div>
            <!-- Isotope Content-->
            <div class="cell-lg-12">
              <div class="isotope isotope-titled-gallery" data-isotope-layout="fitRows" data-isotope-group="gallery-01" data-lightgallery="group">
              <div id="products" class="row">
              
              </div>
              </div>
            </div>
          </div>
        </div>
        <button id="btn-load" class="button-blog button button-default-outline load-more-products" >load more products</button>
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