<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html class="wide wow-animation" lang="en">
  <head>
    <!-- Site Title-->
    <title>Shop Checkout</title>
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <!-- Stylesheets -->
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/mdi.css">
    <link rel="stylesheet" href="/resources/css/fl-bigmug-line.css">
    <link rel="stylesheet" href="/resources/css/ksj-css.css">
    
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>$('.date').datepicker({ dateFormat: 'yyyy-mm-dd' }).val();</script>
    <style type="text/css">
      input.file {
        opacity: 0;
        position: relative;
        width: 165px;
      }
      
      button.reg {
        position: absolute;
        left: 0;
        min-width: 50px;
        min-height: 10px;
      }
      
    </style>
    
  </head>
  <body>
    <%-- Page preloader--%>
    <jsp:include page="/WEB-INF/views/include/pageloader.jsp"/>
    
    <%-- Page--%>
    <div class="page">
      
      <%-- page Header START --%>
      <jsp:include page="/WEB-INF/views/include/header.jsp" />
      <%-- page Header END --%>
      
      <!-- Breadcrumbs-->
      <section class="breadcrumbs-custom breadcrumbs-custom-svg bg-gradient breadcrumbs-background-01">
        <div class="shell">
          <p class="heading-1 breadcrumbs-custom-title">Used Stuff Auction</p>
          <br>
          <br>
          <br>
        </div>
      </section>
      <!-- Product Page-->
      <section class="section section-lg bg-white">
        <div class="shell shell-wide">
          <div class="range range-50 range-md-center">
            <div class="cell-md-11 cell-lg-10 cell-xl-6">
                <!-- Tab panes-->
                    <form class="rd-mailform text-left" data-form-output="form-output-global" data-form-type="contact" method="post" action="/product/modify/${product.productId}">
                      <div class="range range-20">
                        <div class="cell-sm-12">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-name">title</label>
                            <input class="form-input" id="forms-3-name" type="text" name="title" data-constraints="@Required" value="${product.name}">
                          </div>
                        </div>
                        <div class="cell-sm-12">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-last-name">seller</label>
                            <input class="form-input" id="forms-3-last-name" type="text" name="seller" data-constraints="@Required" readonly="readonly" value="${product.seller}">
                          </div>
                        </div>
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-company">Start Price</label>
                            <input class="form-input" id="forms-3-company" type="text" name="baseprice" data-constraints="@Required"  value="${product.basicprice}">
                          </div>
                        </div>
                        <div class="cell-sm-8">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Reason For Sale</label>
                            <input class="form-input" id="forms-3-city" type="text" name="salemotive" value="${product.salemotive}" >
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Period Of Use</label>
                            <input class="form-input" id="forms-3-city" type="text" name="usingtime" value="${product.usingtime}">
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Delivery Type</label>
                              <div class="form-wrap box-width-1">
                                <select class="form-control select-filter" data-placeholder="All" data-minimum-results-for-search="Infinity" data-constraints="@Selected" name="deliverytype">
                                  <c:choose>
                                  	<c:when test='${(product.deliverytype).equals("Direct Dealing")}'>
                                  		<option value="1" selected="selected">Direct Dealing</option>
                                  	</c:when>
                                  	<c:otherwise>
                                  		<option value="1">Direct Dealing</option>
                                  	</c:otherwise>
                                  </c:choose>
                                  
                                  <c:choose>
                                  	<c:when test='${(product.deliverytype).equals("Parcel Service")}'>
                                  		<option value="2" selected="selected">Parcel Service</option>
                                  	</c:when>
                                  	<c:otherwise>
                                  		<option value="2">Parcel Service</option>
                                  	</c:otherwise>
                                  </c:choose>
                                </select>
                              </div>
                          </div>
                        </div>
                         <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Auction Date</label>
                            <input class="form-input data" id="form-element-date" data-time-picker="date" name="date" value="${product.auctionstart}" >
                          </div>
                        </div>
                        <div class="cell-sm-3">
                          <div class="form-wrap form-wrap-validation row">
                            <label class="form-label-outside" for="forms-3-city">Photos</label>
                            <button class="button button-secondary reg" type="submit">Select File</button>
                            <input class="form-input file" id="forms-3-city" type="file" name="photo" required="required" >
                          </div>
                        </div>
                        
                        <!-- 사진 보여주는 곳 -->
                        
                        <div class="cell-sm-12">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-street-address">Product Information</label>
                            <textarea class="form-input" rows="6" cols="100%" name="productinfo" data-constraints="@Required"style="resize: none;">${product.productinfo}</textarea>
                          </div>
                        </div>
                        
                        <div class="cell-sm-12 offset-custom-1">
                          <div class="form-button text-sm-right">
                            <button class="button button-secondary" type="submit">Modify</button>
                          </div>
                        </div>
                      </div>
                    </form>
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