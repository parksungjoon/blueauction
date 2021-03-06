<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    <%-- Stylesheets --%>
    <link rel="stylesheet" href="/resources/css/jjh-style.css">
    <link rel="stylesheet" href="/resources/css/ksj-css.css">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/mdi.css">
    <link rel="stylesheet" href="/resources/css/fl-bigmug-line.css">
    <link rel="stylesheet" href="/resources/css/hideSearch.css">
    
	<script src="/resources/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
	var productId = ${product.productId};
	
	 $(document).ready(function(){
		 /* 관심경매 버튼(하트 버튼) 클릭 시 관심경매 등록, 삭제 */
	    	$(document).on("click", ".ksj-favoriteButton", function(event){
	    		var productId = $(this).attr("id");
	    		var st = "";
	    		
	    		$.ajax({
	    			type:"post",
	    			data:{productId:productId},
	    			dataType:"text",
	    			url:"/favorite",
	    			success: function(data){
	    				if(data == 'insert'){
	    					st = "<img alt='favorite-register' src='/resources/images/full-heart.png'>";
	    					$("#" + productId).html(st);
	    				}else if(data == 'delete'){
	    					st = "<img alt='favorite-register' src='/resources/images/empty-heart.png'>";
	    					$("#" + productId).html(st);
	    				}else {
	    					$(".jjh-modalMessage").html("관심경매 등록/삭제에  실패하였습니다.");
	    	    			$("#cannotSearch").modal("show");
	    				}
	    			}
	    		});
	    	});
		 
		 /* 글 삭제 버튼 이벤트 */
		 $("#remove").click(function(){
			 event.preventDefault();
			 $("#deleteModal").modal();
		 });
		 $("#removeBtn").click(function(event) {
				
				var deleteForm = document.createElement("form");
				deleteForm.setAttribute("method", "post");
				deleteForm.setAttribute("action", "/product/auction/"+productId);
				
				var input = document.createElement('input');
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "_method");
				input.setAttribute("value", "delete");
				
				deleteForm.appendChild(input);
				document.body.appendChild(deleteForm);
				deleteForm.submit();
				
			});
		 
		 /* 글 수정 버튼 이벤트 */
		 $("#modifyBtn").click(function(event) {
		 	
		 	var modifyForm = document.createElement("form");
		 	modifyForm.setAttribute("method", "get");
		 	modifyForm.setAttribute("action", "/product/auction/modify/"+productId);
		 	document.body.appendChild(modifyForm);
		 	modifyForm.submit();
		 });
		
		 /* 이전 목록으로 돌아가는 이벤트 */
		$("#goListBtn").click(function(event){
			event.preventDefault();
			
			var type = $("#type").attr('value');
			var smallid = ${product.smallid};
			
			window.location.href = "/product/auction/"+type+"/"+smallid+""; 
		});
	  });
	
	</script>
  </head>
  
  <body>
    <%-- Page preloader--%>
    <%--  <jsp:include page="/WEB-INF/views/include/pageloader.jsp"/> --%>
    
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
		                    			<li data-large-image="/resources/images/img${photo}"><img class="jjh-finished" src="/resources/images/img${photo}" alt="" width="54" height="71"></li>
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
                  <div class="unit-right product-single-image">
                  	<c:choose>
	                  	<c:when test='${(product.auctionstate).equals("AFTER")}'>
				        	<div class="product-single-image-element" ><img class="product-image-area animateImageIn ksj-imgSize jjh-finished"  src="/resources/images/img${product.photo[0]}" alt=""></div>
				    	</c:when>
				     	<c:otherwise>
				        	<div class="product-single-image-element" ><img class="product-image-area animateImageIn ksj-imgSize"  src="/resources/images/img${product.photo[0]}" alt=""></div>
				      	</c:otherwise>
               		</c:choose>
                  </div>
                </div>
              </div>
            </div>
            <!-- 상품 이미지 END -->
            
            <div class="cell-md-5 cell-lg-5 cell-xl-5 text-center text-md-left ksj-paddingR">
              <div class="heading-5" id="smallName">
				<c:choose>
					<c:when test="${product.smallid == 1 }"> 의류 </c:when>
					<c:when test="${product.smallid == 2}"> 잡화 </c:when>
					<c:when test="${product.smallid == 3}"> 티켓 </c:when>
					<c:when test="${product.smallid == 4}"> 가전제품 </c:when>
				</c:choose>
			  </div>
              <h3 id="productName">${product.name}   
              <button class="ksj-favoriteButton" id="${product.productId}">
              <c:if test='${not empty login && product.auctionstate eq "BEFORE"}'>
              <c:choose>
              	<c:when test="${favorite.favoriteId == 0}">
              		<img alt="favorite-register" src="/resources/images/empty-heart.png">
              	</c:when>
              	<c:otherwise>
              		<img alt="favorite-register" src="/resources/images/full-heart.png">
              	</c:otherwise>
              </c:choose>
              </c:if>
              </button></h3>
              <div class="divider divider-default"></div>
              <div class="detail">
               <dl class="nv3 nfirst present">
               		<dt class="redprice">현재가</dt>
					<dd class="redprice">
						<div class="present_price" id="Price"><span class="present_num" id="presentNum">
						<c:choose>
							<c:when test="${bidList eq null}">
							<fmt:formatNumber value="${product.basicprice}" pattern='#,###.##'/>
							</c:when>
							<c:otherwise>
							<fmt:formatNumber value="${bidList.get(0).bidprice}" pattern='#,###.##'/>
							</c:otherwise>
						</c:choose>
						</span> 원  </div>
						<div class="point"><span class="sf fc6">  시작가   <span class="num_thm" id="basicPrice"><fmt:formatNumber value="${product.basicprice}" pattern='#,###.##'/></span> 원 </span></div>
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
						<input type="hidden" id="type" value="1"> 
							<dt class="redprice">시작시간</dt >
							<dd class="redprice">
								<!-- <span class="auction_time">00:24:12</span> -->
								<div id="bidStartDate" class="jjh-counter">${product.auctionstart}</div>
							</dd>	
						</c:when>
						<c:when test='${(product.auctionstate).equals("DOING")}'>
						<input type="hidden" id="type" value="2"> 
							<dt class="redprice">남은시간</dt>
							<dd class="redprice">
							<!-- <span class="auction_time">00:24:12</span> -->
								<div id="bidendDate" class="countdown jjh-counter" data-time="${product.auctionend}" data-format="DDHMS" data-type="until" data-layout="{hnn}{sep}{mnn}{sep}{snn}"></div>
							</dd>
						</c:when>
						<c:otherwise>
						<input type="hidden" id="type" value="3"> 
							<dt class="redprice">남은시간</dt>
							<dd class="redprice">
							<!-- <span class="auction_time">00:24:12</span> -->
								<div id="bidendDate" class="countdown jjh-counter" data-time="${product.auctionend}" data-format="DDHMS" data-type="until" data-layout="{hnn}{sep}{mnn}{sep}{snn}"></div>
							</dd>
						</c:otherwise>
					</c:choose>
					<dt class="redprice">배송방식</dt> <dd class="redprice">${product.deliverytype}</dd>
					<dt class="redprice">판매자</dt> <dd class="redprice">${product.seller}</dd>
				</dl> 
				
				<c:if test='${(product.auctionstate).equals("DOING") && empty login}'>
				<a href="/member/login" style="text-align: center;"> 입찰하시려면 로그인을 해주세요 </a>
				</c:if>
				
				<c:if test='${(product.auctionstate).equals("DOING") && not empty login}'>
                  <c:if test="${login.memberId!=product.seller }">
				  <div id="clock">
				  <a class="button button-xs button-secondary" id='bidModalOpen' data-toggle="modal" data-target="#bidModal">입찰하기</a>
                 </c:if>
                  </div>
				</c:if>
                <!-- TEST 하시려면 푸세요. 대신 제가 서버를 켜야합니다. -->
				<!-- <a class="button button-xs button-secondary" id='bidModalOpen' data-toggle="modal" data-target="#bidModal">입찰하기</a> -->
                <c:if test="${not empty login }">
                <a class="button button-xs button-secondary" href="#" onclick="javascript:chatting()">채팅하기</a>
                <c:if test="${login.memberId!=product.seller }">
                <a class="button button-xs button-secondary" href="#" onclick="javascript:noteSend()">${product.seller}에게 쪽지</a>
                </c:if>
                </c:if>
              </div>
            </div>
          </div>
        </div>
         <!-- Hover Row Table (입찰 리스트) START -->
        <%-- <div class="shell">
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
        </div>  --%>
        <!-- 테스트 하시려면 주석을 푸세요요용. -->
        <%-- <iframe src="http://192.168.78:7778/?memberId=${login.memberId}" frameborder="0" style="visibility:hidden;"></iframe> --%>
        <div class="shell">
        <iframe id='child' src='http://192.168.0.78:7777/bid/?productId=${productId}&memberId=${login.memberId}' width=100%; frameborder='0' style="margin-bottom: 100px;" scrolling="no"></iframe>
        </div>
        <!-- Hover Row Table (입찰 리스트) END --> 
        
        
        <div class="shell">
          <div class="range range-xs-center">
            <div class="cell-sm-10 cell-lg-8">
            <p class="h3-alternate">상세 정보</p>
		            <%-- <p class="text-spacing-sm" id="productInfo">
		            	${product.productinfo}
		            </p> --%>
                <table class="table-custom table-hover" style="width:100%;">
                  <tr>
                  <td>상품명</td>
                  <td>${product.name}</td>
                  </tr>
                  <tr>
                  <td>판매이유</td>
                  <td>${product.salemotive}</td>
                  </tr>
                  <tr>
                    <td>사용기간</td>
                    <td>${product.usingtime}</td>
                  </tr>
                  <tr>
                    <td>판매형태</td>
                    <td>${product.deliverytype }</td>
                  </tr>
                  <tr>
                    <td>상세정보</td>
                    <td>
                      ${product.productinfo}
                    </td>
                  </tr>
                </table>
            </div>
          </div>
        </div>

			<div class="shell">
				<div class="range range-xs-right">
					<div class="cell-sm-10 cell-lg-4">
						<button class="btn" id="goListBtn">GO BACK</a></button>
						<c:if test="${(login.memberId).equals(product.seller)}">
							<c:if test='${(product.auctionstate).equals("BEFORE")}'>
								<button class="btn btn-warning" id="modifyBtn">Modify</button>
								<button class="btn btn-danger" id="remove">REMOVE</button>
							</c:if>
						</c:if>
					</div>
				</div>
			</div>

		</section>
      <!-- Product Page END-->
      
      <%-- Page Footer--%>
      <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
     
    </div>
    <%-- PANEL--%>
    <%-- END PANEL--%>
    <%-- Global Mailform Output--%>
    <div class="snackbars" id="form-output-global"></div>
    
     <div id="deleteModal" class="modal fade" role="dialog">
      <div class="modal-dialog modal-sm">
  		<!-- 모달 내용-->
		<div class="modal-content">
	    	<div class="modal-header">
	        	<h5 class="modal-title-delete">게시글 삭제</h5>
	        </div>
	        <div class="modal-body"> 
	        	<span>정말 삭제하시겠습니까?</span>
	        </div>
	        <div class="modal-footer">
	            <button type="button" id="removeBtn" class="btn btn-default btn-register" data-dismiss="modal">Delete</button>
	            <button type="button" class="btn btn-default btn-close" data-dismiss="modal">Cancel</button>
	        </div>
	    </div>
      </div>
    </div>
    
    <%-- Javascript--%>
    <script src="/resources/js/core.min.js"></script>
    <script src="/resources/js/script.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.0/moment.min.js"></script>
    <div id="bidModal" class="modal modal-primary fade" role="dialog">
      <div class="modal-dialog">
    <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">입찰하기</h4>
          </div>
        <div class="modal-body" data-rno>
          <p>최고가<span id='maxPrice'><c:out value="${bidList.get(0).bidprice eq undefined ? product.basicprice : bidList.get(0).bidprice}"/></span></p>
          <p><input type="hidden" id="memberId" class="form-control" value="${login.memberId}"></p>
          <p><input type="hidden" id="productId" class="form-control" value="${product.productId}"></p>
          <p><input type="text" id="bidprice" class="form-control"></p>
          <span></span>
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
        <button type="button" class="btn btn-danger" id="goBuy">확인</button>
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
  window.open("http://192.168.78:7777/chat?productId=${product.productId}&memberId=${login.memberId}" ,'pbml_win','toolbar=no,location=no,directories=no, status=no,menubar=no,resizable=yes, scrollbars=yes,width=400,height=500,left=0,top=0' );
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
    /* console.log( '자식으로부터 받은 메시지 ', e.data ); */
    if(e.data=='openModal'){
      openModal();
    }else if(e.data.maxprice!=null || e.data.maxprice!=undefined){
      /* console.log('자식으로부터 받은 최대값'+e.data.maxprice); */
      $('#maxPrice').html(e.data.maxprice);
      $('#presentNum').html(e.data.maxprice);
    }else if(e.data.title=='favorite'){
    	/* console.log('자식으로부터 받은 즐겨찾기 리스트'+e.data.list); */
    	$('#favorite').html(e.data.list);
    	$('#favoriteModal').modal('show');
    }else if(e.data.title=='noteCount'){
    	 $('#counter').html(e.data.noteCount);
    }else if(e.data.title=='iframeHeight'){
    	/* console.log('iframe의 높이'+e.data.height); */
    	$('#child').height(e.data.height);
    }
}

function openModal(){
  $('#winnerModal').modal('show');
}
</script>
<script>
window.onload=function(){
  
  $('#bid').on( 'click', function( e ) {
    /* console.log('입찰가'+parseInt($('#bidprice').val())+'최고가'+parseInt($('#maxPrice').html())); */
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
  
  $('#goBuy').on('click',function(e){
		 self.location="/order/payment/${productId}"; 
	  });
	  
	//경매 종료시 입찰 버튼 없애기 
	$('#bidendDate').countdown('option',{onExpiry: liftOff});
	  
}
function liftOff(){
	  $('#bidModalOpen').remove();
}
</script>
  </body>
</html>