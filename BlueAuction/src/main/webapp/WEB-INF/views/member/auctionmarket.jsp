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
      <p class="heading-1 breadcrumbs-custom-title">Autcion sell List</p>
      <ul class="breadcrumbs-custom-path">
        <li><a href="/">Home</a></li>
        <li><a href="/member/mypage">mypage</a></li>
        <li class="active">Auction product list</li>
      </ul>
    </div>
    </section>
    <!-- Breadcrumbs END -->


  <!-- Product Page START-->
      <section class="section section-lg bg-white">
       
        
         <!-- Hover Row Table (입찰 리스트) START -->
        <div class="shell">
          <div class="range range-xs-center">
            <div class="cell-sm-10 cell-lg-10">
              <h3>경매 판매 리스트 </h3>
              <div class="table-novi table-custom-responsive">
                <table  class="table table-striped table-hover">
                  <thead>
                    <tr class="danger">
                      <th>#</th>
                      <th>상품명</th>
                      <th>상품 정보</th>
                      <th>판매 가격</th>
                      <!-- <th>판매 상태</th> -->
                    </tr>
                  </thead>
                  <tbody id="bidListTr">
                  <c:forEach var="product" items="${products}" varStatus="status">
                   <tr style = "cursor:pointer;" onClick = " location.href='/product/auction/readpage/${product.productId}' ">
                      <td>${status.count}</td>
                      <td>${product.name}</a></td>  
                      <td>${product.productinfo}</td>
                      <td>${product.price}원</td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
                   </div>
          <div style="text-align: center;">
             <ul class="pagination">
              <c:if test="${pageMaker.prev}">
                <li><a href="/member/mypage/auctionmarket${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
              </c:if>

              <c:forEach begin="${pageMaker.startPage }"
                end="${pageMaker.endPage }" var="idx">
                <li
                  <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
                  <a href="/member/mypage/auctionmarket${pageMaker.makeSearch(idx)}">${idx}</a>
                </li>
              </c:forEach>

              <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                <li><a href="/member/mypage/auctionmarket${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
              </c:if>

            </ul>
          </div>

       
        <!-- /.box-footer-->
            </div>
            <%-- Shop Sidebar START --%>
        <jsp:include page="/WEB-INF/views/include/mypageRightSidebar.jsp"></jsp:include>
        <%-- Shop Sidebar END --%>
           
          </div>
        </div>
        <!-- Hover Row Table (입찰 리스트) END --> 
       
        
      </section>

    <!-- Product Page END-->

    <!-- Product Page END-->
    <%-- Page Footer--%>
    <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
  </div>
  <%-- PANEL--%>
  <%-- END PANEL--%>
  <%-- Global Mailform Output--%>
  <div class="snackbars" id="form-output-global"></div>
  
 
      <!-- Product Page END-->

  <%-- Javascript--%>
  <script src="/resources/js/core.min.js"></script>
  <script src="/resources/js/script.js"></script>
</body>
</html>