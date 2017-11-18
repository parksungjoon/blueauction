<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="wide wow-animation" lang="en">
<head>
<%-- Site Title--%>
<title>Home</title>
<meta name="format-detection" content="telephone=no">
<meta name="viewport"
  content="width=device-width, height=device-height, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="utf-8">
<link rel="icon" href="/resources/images/favicon.ico"
  type="image/x-icon">
<%-- Stylesheets --%>
<link rel="stylesheet" href="/resources/css/ksj-css.css">
<link rel="stylesheet" type="text/css"
  href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet" href="/resources/css/mdi.css">
<link rel="stylesheet" href="/resources/css/fl-bigmug-line.css">

<%--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/">
    <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--%>

<script src="/resources/js/jquery-1.12.4.min.js"></script>

</head>

<body>
  <%-- Page preloader--%>
  <jsp:include page="/WEB-INF/views/include/pageloader.jsp" />

  <%-- Page--%>
  <div class="page">

    <%-- page Header START --%>
    <jsp:include page="/WEB-INF/views/include/header.jsp" />
    <%-- page Header END --%>

    <!-- Breadcrumbs START -->
    <section
      class="breadcrumbs-custom breadcrumbs-custom-svg bg-gradient breadcrumbs-background-01">
    <div class="shell">
      <p class="breadcrumbs-custom-subtitle">Product</p>
      <p class="heading-1 breadcrumbs-custom-title">Autcion Product</p>
      <ul class="breadcrumbs-custom-path">
        <li><a href="index.html">Home</a></li>
        <li><a href="#">product</a></li>
        <li class="active">Auction</li>
      </ul>
    </div>
    </section>
    <!-- Breadcrumbs END -->


    <section class="section section-lg bg-white"> 
    <c:if test="${not empty products}">
    <c:forEach var="product" items="${products}" varStatus="status">
      <div class="shell shell-bigger product-single">
        <div
          class="range range-ten range-xs-center range-md-justify range-30 range-md-middle">

          <img class="product-image-area animateImageIn"
            src="/resources/images/img/${product.photo[0]}" alt=""
            width="300">

          <div
            class="cell-md-6 cell-lg-5 cell-xl-5 text-center text-md-left">
            <div class="heading-5" id="smallName"></div>
            <li><a href="../../product/auction/readpage/${product.productId}"> ${product.name} </a></li>
            <div class="divider divider-default"></div>
            <div class="detail">
              <dl class="nv3 nfirst present">
                
                <dd class="redprice">
                <dt class="redprice">판매가</dt>
                  <div class="present_price" id="Price">
                    <span class="present_num" id="presentNum">${product.price}</span>
                    원
                  </div>
                  <div class="shell">
                    <div class="range range-xs-center">
                      <div class="cell-sm-11 cell-lg-8">
                        <p class="h3-alternate">상세 정보</p>
                        <p class="text-spacing-sm" id="productInfo">
                          ${product.productinfo}</p>
                      </div>
                    </div>
                  </div>
                </dd>


              </dl>

            </div>
          </div>
        </div>
      </div>




    </c:forEach> </section>
    </c:if>
    <c:if test="${empty products}">
    <h5> 판매 상품이 없습니다</h5>
    </c:if>
    <!-- Product Page END-->

    <!-- Product Page END-->
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