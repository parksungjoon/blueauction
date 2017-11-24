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
					<c:if test='${(product.auctionstate) ne ("BEFORE")}'>
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
					</c:if>
					
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
				  <a class="button button-xs button-secondary" id='bidModalOpen' data-toggle="modal" data-target="#bidModal">입찰하기</a>
				</c:if>
                <!-- TEST 하시려면 푸세요. 대신 제가 서버를 켜야합니다. -->
				<!-- <a class="button button-xs button-secondary" id='bidModalOpen' data-toggle="modal" data-target="#bidModal">입찰하기</a> -->
                <c:if test="${not empty login }">
                <a class="button button-xs button-secondary" href="#" onclick="javascript:chatting()">채팅하기</a>
                <a class="button button-xs button-secondary" href="#" onclick="javascript:noteSend()">${product.seller}에게 쪽지</a>
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
        <!-- 테스트 하시려면 자신의 아이피를 입력하세요. -->
        <%-- <iframe src="http://192.168.78:7778/?memberId=${login.memberId}" frameborder="0" style="visibility:hidden;"></iframe>
       <iframe id='child' src='http://192.168.0.78:7777/bid/?productId=${productId}&memberId=${login.memberId}' width=100%; frameborder='0' style="height:1000px;"></iframe> --%>
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
    <div id="bidModal" class="modal modal-primary fade" role="dialog">
      <div class="modal-dialog">
    <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">입찰하기</h4>
          </div>
        <div class="modal-body" data-rno>
          <p>최고가<span id='maxPrice'>${bidList.get(0).bidprice}</span></p>
          <p><input type="hidden" id="memberId" class="form-control" value="${login.memberId}"></p>
          <p><input type="hidden" id="productId" class="form-control" value="${product.productId}"></p>
          <p><input type="text" id="bidprice" class="form-control"></p>
        </div>
        <div class="modal-footer">
        <button type="button" class="btn btn-danger" id="bid">입찰</button>
        </div>
        </div>
      </div>
    </div>

<div id="winnerModal" class="modal modal-primary fade" role="dialog">
    <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">낙찰!!</h4>
      </div>
      <div class="modal-body" data-rno>
        <span>낙찰 되셨습니다. 확인을 누르면 결재페이지로 이동합니다.</span>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger">확인</button>
      </div>
    </div>
  </div>
</div>
<div id="favoriteModal" class="modal modal-primary fade" role="dialog">
    <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">10분전 알림</h4>
      </div>
      <div class="modal-body" data-rno>
        즐겨찾기하신 <span id='favorite'></span>번 상품에 대한 경매가 10분후 시작됩니다.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger">확인</button>
      </div>
    </div>
  </div>
</div> 
<script>
function chatting() {
  window.open("http://192.168.78:7777/chat?productId=${product.productId}&memberId=${login.memberId}" ,'pbml_win','toolbar=no,location=no,directories=no, status=no,menubar=no,resizable=yes, scrollbars=yes,width=650,height=700,left=0,top=0' );
}
function noteSend(){
  window.open("/note/${product.seller}" ,'pbml_win','toolbar=no,location=no,directories=no, status=no,menubar=no,resizable=yes, scrollbars=yes,width=650,height=800,left=0,top=0' );  
}
</script>
<script>
//메시지 수신 받는 eventListener 등록
window.addEventListener( 'message', receiveMsgFromChild );
 
// 자식으로부터 메시지 수신
function receiveMsgFromChild( e ) {
    console.log( '자식으로부터 받은 메시지 ', e.data );
    if(e.data=='openModal'){
      openModal();
    }else if(e.data.maxprice!=null || e.data.maxprice!=undefined){
      console.log('자식으로부터 받은 최대값'+e.data.maxprice)
      $('#maxPrice').html(e.data.maxprice);
    }else if(e.data.title=='favorite'){
    	console.log('자식으로부터 받은 즐겨찾기 리스트'+e.data.list);
    	$('#favorite').html(e.data.list);
    	$('#favoriteModal').modal('show');
    }else if(e.data.title=='noteCount'){
    	 $('#counter').html(e.data.noteCount);
    }
}

function openModal(){
  $('#winnerModal').modal('show');
}
</script>
<script>
window.onload=function(){
  
  $('#bid').on( 'click', function( e ) {
    console.log('입찰가'+parseInt($('#bidprice').val())+'최고가'+parseInt($('#maxPrice').html()));
    if(parseInt($('#bidprice').val())<=parseInt($('#maxPrice').html())){
      alert('더 큰 값을 부르세요!');
      $('#bidprice').val('');
      return false;
    }else{
    sendMsgToChild({memberId:$('#memberId').val(), productId:$('#productId').val(), bidprice:$('#bidprice').val()});
    $('#bidprice').val('');
    $('#bidModal').modal('hide');
    
    }
  });
  function sendMsgToChild( msg ) {
      document.getElementById('child').contentWindow.postMessage(msg, '*');
  }
}
</script>
  </body>
</html>