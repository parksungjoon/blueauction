<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link rel="stylesheet" href="/resources/css/jjh-style.css">
    <link rel="stylesheet" href="/resources/css/ksj-css.css">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/mdi.css">
    <link rel="stylesheet" href="/resources/css/fl-bigmug-line.css">
    
	<script src="/resources/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
	
	 $(document).ready(function(){
		 
		 var formObj = $("#modifyPage");
		 $("#removeBtn").click(function(event) {
				event.preventDefault();
				var productId = formObj.attr("action");
				
				formObj.attr("action", "/product/auction/remove/"+productId);    
				formObj.attr("method", "post");
				formObj.submit();
				
			});
		 
		
		 $("#modifyBtn").click(function(event) {
		 	event.preventDefault();
		 	var productId = formObj.attr("action");
		 	
		 	formObj.attr("action", "/product/auction/modifypage/"+productId);
	    	formObj.attr("method", "post");
	    	formObj.submit();
		 });
		 
		
		 
		$("#goListBtn").click(function(event){
			event.preventDefault();
			
			 window.history.back();
			
			/* var type = $("input[name=page]")[0].attr('value');
			var smallid = $("input[name=smallid]")[0].attr('value');
			
			formObj.attr("action", "/product/auction/"+type+"/"+smallid);    
			formObj.attr("method", "GET");
			
			alert("type : " + type);
			alert("smallid : " + smallid);
			alert("formObj : " + formObj.attr("action")); */
			
			/* formObj.submit(); */
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
      
      <!-- Breadcrumbs START -->
      <section class="breadcrumbs-custom breadcrumbs-custom-svg bg-gradient breadcrumbs-background-01">
        <div class="shell">
          <p class="breadcrumbs-custom-subtitle">Product </p>
          <p class="heading-1 breadcrumbs-custom-title">Autcion Product</p>
          <ul class="breadcrumbs-custom-path">
            <li><a href="index.html">Home</a></li>
            <li><a href="#">product</a></li>
            <li class="active">Auction</li>
          </ul>
        </div>
      </section>
      <!-- Breadcrumbs END -->
      
      <!-- Product Page START-->
      <section class="section section-lg bg-white">
        <div class="shell shell-bigger product-single ksj-marginLeft">
          <div class="range range-ten range-xs-center range-md-justify range-30 range-md-middle">
          
          	<!-- 상품 이미지 START -->
            <div class="cell-md-5 cell-lg-5 cell-xl-5">
              <div class="product-single-preview">
                <div class="unit unit-sm-horizontal unit-sm-middle unit-spacing-md-midle unit--inverse unit-sm">
                  <div class="unit-body">
                    <ul class="product-thumbnails">
                    	<c:forEach var="photo" items="${product.photo}" varStatus="status" >
                    	<c:choose>
                    		<c:when test='${(product.auctionstate).equals("AFTER")}'>
                    			<c:choose>
		                    		<c:when test="${status.count==1}">
		                    			<li class="active" data-large-image="/resources/images/img${photo}"><img class="jjh-finished" src="/resources/images/img${photo}" alt="" width="54" height="71"></li>
		                    		</c:when>
		                    		<c:otherwise>
		                    			<li  data-large-image="/resources/images/img${photo}"><img class="jjh-finished" src="/resources/images/img${photo}" alt="" width="54" height="71"></li>
		                    		</c:otherwise>
                    			</c:choose>
                    		</c:when>
                    		
                    		<c:otherwise>
                    			<c:choose>
		                    		<c:when test="${status.count==1}">
		                    			<li class="active" data-large-image="/resources/images/img${photo}"><img src="/resources/images/img${photo}" alt="" width="54" height="71"></li>
		                    		</c:when>
		                    		<c:otherwise>
		                    			<li data-large-image="/resources/images/img${photo}"><img src="/resources/images/img${photo}" alt="" width="54" height="71"></li>
		                    		</c:otherwise>
                    			</c:choose>
                    		</c:otherwise>
                    	</c:choose>
                    		
                    	</c:forEach>
                      </ul>
                  </div>
                  
                  <div class="unit-right product-single-image" style="">
                  	<c:choose>
	                  	<c:when test='${(product.auctionstate).equals("AFTER")}'>
				        	<div class="product-single-image-element ksj-divImg" ><img class="product-image-area animateImageIn ksj-imgSize jjh-finished"  src="/resources/images/img${product.photo[0]}" alt=""></div>
				    	</c:when>
				     	<c:otherwise>
				        	<div class="product-single-image-element ksj-divImg" ><img class="product-image-area animateImageIn ksj-imgSize"  src="/resources/images/img${product.photo[0]}" alt=""></div>
				      	</c:otherwise>
               		</c:choose>
                  </div>
                </div>
              </div>
            </div>
            <!-- 상품 이미지 END -->
            
            <div class="cell-md-5 cell-lg-4 cell-xl-4 text-center text-md-left">
              <div class="heading-5" id="smallName">
				<c:choose>
					<c:when test="${product.smallid == 1 }"> 의류 </c:when>
					<c:when test="${product.smallid == 2}"> 잡화 </c:when>
					<c:when test="${product.smallid == 3}"> 티켓 </c:when>
					<c:when test="${product.smallid == 4}"> 가전제품 </c:when>
				</c:choose>
			  </div>
              <h3 id="productName">${product.name}</h3>
              <div class="divider divider-default"></div>
              <div class="detail">
               <dl class="nv3 nfirst present">
               		<dt class="redprice">현재가</dt>
					<dd class="redprice">
						<div class="present_price" id="Price"><span class="present_num" id="presentNum">
						<c:choose>
							<c:when test="${bidList == null}">
							${product.basicprice}
							</c:when>
							<c:otherwise>
							${bidList.get(0).bidprice}
							</c:otherwise>
						</c:choose>
						</span> 원  </div>
						<div class="point"><span class="sf fc6">  시작가   <span class="num_thm" id="basicPrice">${product.basicprice}</span> 원 </span></div>
					</dd>
					<dt class="redprice">입찰수</dt ><dd class="redprice" id="bidCount">
					<c:choose>
							<c:when test="${bidList == null}">
							0
							</c:when>
							<c:otherwise>
							${bidList.size()}
							</c:otherwise>
						</c:choose>
						회
					</dd>
					<c:choose>
						<c:when test='${(product.auctionstate).equals("BEFORE")}'>
							<dt class="redprice">시작시간</dt >
							<dd class="redprice">
								<!-- <span class="auction_time">00:24:12</span> -->
								<div id="bidStartDate" class="jjh-counter">${product.auctionstart}</div>
							</dd>	
						</c:when>
						<c:otherwise>
							<dt class="redprice">남은시간</dt >
							<dd class="redprice">
							<!-- <span class="auction_time">00:24:12</span> -->
								<div id="bidendDate" class="countdown jjh-counter" data-time="${product.auctionend}" data-format="DDHMS" data-type="until" data-layout="{hnn}{sep}{mnn}{sep}{snn}"></div>
							</dd>
						</c:otherwise>
					</c:choose>
					<dt class="redprice">배송방식</dt> <dd class="redprice">${product.deliverytype}</dd>
					<dt class="redprice">판매자</dt> <dd class="redprice">${product.seller}</dd>
				</dl> 
				
				<c:if test='${(product.auctionstate).equals("DOING")}'>
				  <a class="button button-xs button-secondary" href="#">입찰하기</a>
				</c:if>
				
				<c:if test='${(product.auctionstate).equals("AFTER")}'>
					<button class="button button-xs btn" disabled="disabled">종료</button>
				</c:if>
				
              </div>
            </div>
          </div>
        </div>
        
         <!-- Hover Row Table (입찰 리스트) START -->
        <div class="shell">
          <div class="range range-xs-center">
            <div class="cell-sm-10 cell-lg-8">
              <h3> 입찰 리스트 </h3>
              <div class="table-novi table-custom-responsive">
                <table class="table-custom table-hover">
                  <thead>
                    <tr>
                      <th>#</th>
                      <th>입찰자 ID</th>
                      <th>입찰 일자</th>
                      <th>입찰 가격</th>
                    </tr>
                  </thead>
                  <tbody id="bidListTr">
                  <c:forEach var="bid" items="${bidList}" varStatus="status">
                  	<tr>
                      <td>${status.count}</td>
                      <td>${bid.memberId}****</td>
                      <td>${bid.biddate}</td>
                      <td>${bid.bidprice}원</td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
        <!-- Hover Row Table (입찰 리스트) END --> 
        
        <div class="shell">
          <div class="range range-xs-center">
            <div class="cell-sm-10 cell-lg-8">
            <p class="h3-alternate">상세 정보</p>
		            <p class="text-spacing-sm" id="productInfo">
		            	${product.productinfo}
		            </p>
            </div>
          </div>
        </div>
        
        <c:if test="${(login.memberId).equals(product.seller)}">
        	<c:if test='${(product.auctionstate).equals("BEFORE")}'>
        		<form role="form" action="${productId}" method="post" id="modifyPage">
				 	<%-- <input type='hidden' name='page' value="${page}"> 
					<input type='hidden' name='type' value="${type}">
					<input type='hidden' name='keyword' value="${keyword}">
					<input type='hidden' name='smallid' value="${smallid}"> --%>
				
		        <div class="shell"> 
		          <div class="range range-xs-right">
		            <div class="cell-sm-10 cell-lg-4">
		            	<button type="submit" class="btn" id="goListBtn">GO LIST</button>
			            <button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
						<button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
		            </div>
		          </div>
		        </div>
		        </form>
        	</c:if>
        </c:if>
        
        
      </section>
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