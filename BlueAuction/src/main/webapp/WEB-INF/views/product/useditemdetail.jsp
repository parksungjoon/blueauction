<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
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
    <link rel="stylesheet" href="/resources/css/ksj-css.css">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/mdi.css">
    <link rel="stylesheet" href="/resources/css/fl-bigmug-line.css">
    <link rel="stylesheet" href="/resources/css/cms-pdetail.css">
    <link rel="stylesheet" href="/resources/css/hideSearch.css">
    
    <script src="/resources/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/resources/js/fileUpload.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
    
		<%--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/">
    <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--%> 
    
    <script type="text/javascript">
    
    var productId = ${product.productId};
    var page = 0;
    
    $(document).ready(function() {
    	
    	listPage(productId, page);
    	movePage();
    	
    	$("#btn-send").click(function() {
			addReply();
		});
    	
    	$(".btn-close").click(function() {
			$(".tarea-reply").val("");
		});
    	
    	$(".btn-register").click(function() {
    		
    		var type = $(".modal-title-reply").text();
    		
    		switch (type) {
    		
			case "댓글 작성":
				var parentId = $(this).attr("value");
    			addReply(parentId);	
				break;
				
			case "댓글 수정":
				var replyId = $(this).attr("value");
	    		modifyReply(replyId);	
				break;
				
			case "판매 철회":
				deleteItem();	
				break;
				
			default:
				var replyId = $(this).attr("value");
				deleteReply(replyId);
				break;
			}
    		
    		$(".btn-close").trigger("click");
    		
    	});
    	
    	
    	
    	
    	$(document).on("click", ".btn-reply", function() {
    		$(".modal-title-reply").text("댓글 작성");
    		$(".btn-register").text("Register");
    		var parentId = $(this).attr("value");
    		$(".btn-register").attr("value", parentId);
    	});
    	
    	$(document).on("click", ".btn-reply-modify", function() {
    		$(".modal-title-reply").text("댓글 수정");
    		$(".btn-register").text("Modify");
    		$(".tarea-reply").val($(this).attr("name"));
    		var replyId = $(this).attr("value");
    		$(".btn-register").attr("value", replyId);
    	});
    	
    	$(document).on("click", ".btn-reply-delete", function() {
    		$(".modal-title-reply").text("댓글 삭제");
    		$(".modal-title-delete").text("댓글 삭제");
    		$(".btn-register").text("Delete");
    		var replyId = $(this).attr("value");
    		$(".btn-register").attr("value", replyId);
    	});
    	
    	$(document).on("click", ".delete", function() {
    		$(".modal-title-reply").text("판매 철회");
    		$(".modal-title-delete").text("판매 철회");
    		$(".btn-register").text("Delete");
    	});
	});
    
    	/* 댓글 목록 출력 */
    	function listPage(productId, page) {
    		
    		var url = "/reply/" + productId + "/" + (page*10)
    		
    		$.getJSON(url , function(data) {
    			var list = data.list;
    			
    			$('#reply-list *').remove();
    			
        		for ( var i in list) {
        			var source;
        			var template;
        			
						if (list[i].deleteFlag == 'Y') {
							if (list[i].levelNo == 0) {
	    						source = $("#template3").html();
        					} else {
        						source = $("#template4").html();
        					}
						} else {
        					if (list[i].levelNo == 0) {
	    						source = $("#template").html();
        					} else {
        						source = $("#template2").html();
        					}
						}
						
    					template = Handlebars.compile(source);
   						list[i].levelNo *= 30;
    					$("#reply-list").append(template(list[i]));
    				}; 
    				
        		$(".reply-container").last().css("border-bottom", "1px solid gray");
        		$("#productId").attr("value", productId);
        		
        		if (${login.memberId == null}) {
        			$(".btn-reply, .btn-reply-modify, .btn-reply-delete").hide();
				} else if(${login.memberId != null}) {
					
        			var titles = $(".comment-header");
        			for(var i=0; i<titles.length; i++) {
        				if ($(titles[i]).children(".comment-title").html().trim() != '${login.memberId}') {
        					$(titles[i]).children(".comment-footer").children(".btn-reply-modify, .btn-reply-delete").hide();
    					} 
        			}
        			
				};
				
				if (data.pageMaker.totalCount <= 10) {
	    		} else {
	    			printPageNum(data.pageMaker)
	    		};
        		
	    		if (list.length == 0) {
					$("#reply-list").before($("#template5").html());
				}
    		});  
        		
    	};
    	
		/* 하단 페이지 번호 출력 */
		function printPageNum(pageMaker) {
			
			var pages = "";
			
			if (pageMaker.prev) {
				pages += "<li><a href='" + (pageMaker.startPage - 2) + "'>≪</a></li>";
			}
			
			for (var i = pageMaker.startPage; i <= pageMaker.endPage; i++) {
				var numClass = (pageMaker.cri.page/10)+1 == i ? 'class=active' : '';
				pages += "<li " + numClass +  "><a href='" + (i-1) + "'>" + i + "</a></li>";
			}
			
			if (pageMaker.next) {
				pages += "<li><a href='" + (pageMaker.endPage) + "'>≫</a></li>";
			}
			
			$('#pagination').html(pages);
		}
		
		/* 페이지 이동 */
		function movePage() {
			$('.pagination').on("click", "a", function() {
				event.preventDefault();
				page = $(this).attr("href");
				listPage(productId, page);
			})
		}
		
		/* 댓글 등록 */
		function addReply(parentId) {
			var memberId = $("#memberId").attr("value");
			var productId = $("#productId").attr("value");
			var content;
			if (parentId == undefined || parentId == null) {
				content = $("#form-comment-message").val();
			} else {
				content = $(".tarea-reply").val();
			}
			
			$.ajax({
				type: "post",
				url: "/reply",
				dataType: 'text',
				contentType: "application/json;charset=UTF-8",
				data: JSON.stringify({memberId:memberId, productId:productId, content:content, replyId:parentId}),
				success: function(data) {
					page = 0;
					$("#emptyList").remove();
					listPage(productId, page);
					$("#form-comment-message").val("");
				}
			});
		}
		
		/* 댓글 수정 */
		function modifyReply(replyId) {
			
			var url = "/reply/" + replyId
			var content = $(".tarea-reply").val();
			
			$.ajax({
				type: "put",
				url: url,
				headers: { 
		              "Content-Type": "application/json;charset=UTF-8",
		              "X-HTTP-Method-Override": "PUT" },
				dataType: 'text',
				data: JSON.stringify({replyId:replyId, content:content}),
				success: function(data) {
					page = 0;
					listPage(productId, page);
				}
			});
		}
		
		/* 댓글 삭제 */
		function deleteReply(replyId) {
			
			var url = "/reply/" + replyId
			
			$.ajax({
				type: "delete",
				url: url,
				headers: { 
		              "Content-Type": "application/json;charset=UTF-8",
		              "X-HTTP-Method-Override": "DELETE" },
				dataType: 'text',
				data: JSON.stringify({replyId:replyId}),
				success: function(data) {
					page = 0;
					listPage(productId, page);
				}
			});
		}
		
		/* 상품 리스트로 돌아가기 */
		var form = document.createElement("form");
		$(document).on("click", ".back", function() {
			form.setAttribute("method", "get");
			form.setAttribute("action", "/product/used");
			document.body.appendChild(form);
			form.submit();
		});
		
		/* 상품 삭제 */
		function deleteItem() {
			var deleteForm = document.createElement("form");
			deleteForm.setAttribute("method", "post");
			deleteForm.setAttribute("action", "/product/used/" + ${product.productId});
			
			var input = document.createElement('input');
			input.setAttribute("type", "hidden");
			input.setAttribute("name", "_method");
			input.setAttribute("value", "delete");
			
			deleteForm.appendChild(input);
			document.body.appendChild(deleteForm);
			deleteForm.submit();
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
      
      <!-- Breadcrumbs START -->
      <section class="breadcrumbs-custom breadcrumbs-custom-svg bg-gradient breadcrumbs-background-01">
        <div class="shell">
          <p class="breadcrumbs-custom-subtitle">Product </p>
          <p class="heading-1 breadcrumbs-custom-title">Used Product</p>
          <ul class="breadcrumbs-custom-path">
            <li><a href="/">Home</a></li>
            <li><a href="/product/used">Product</a></li>
            <li class="active">Used Product</li>
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
                    <ul id="imagelist" class="product-thumbnails">
                      <c:forEach var="image" items="${product.photo }" varStatus="status">
                        <c:choose>
                          <c:when test="${status.index == 0}">
                            <li class="active" data-large-image="/resources/images/img${image }"><img src="/resources/images/img${image }" alt="" width="54" height="71"></li>    
                          </c:when>
                          <c:otherwise>
                            <li data-large-image="/resources/images/img${image }"><img src="/resources/images/img${image }" alt="" width="54" height="71"></li>
                          </c:otherwise>
                        </c:choose>
                      </c:forEach>
                    </ul>
                  </div>
                  <div class="unit-right product-single-image">
                    <div class="product-single-image-element"><img class="product-image-area animateImageIn" src="/resources/images/img${product.photo[0] }" alt=""></div>
                  </div>
                </div>
              </div>
            </div>
            <!-- 상품 이미지 END -->
            
            <div class="cell-md-5 cell-lg-5 cell-xl-5 text-center text-md-left ksj-paddingR">
              <div class="heading-5">
                <c:choose>
                  <c:when test="${product.smallid == 1 }">의류</c:when>
                  <c:when test="${product.smallid == 2 }">잡화</c:when>
                  <c:when test="${product.smallid == 3 }">티켓</c:when>
                  <c:when test="${product.smallid == 4 }">가전제품</c:when>
                </c:choose>
              </div>
              <h3>${product.name}</h3>
              <div class="divider divider-default"></div>
              <div class="detail">
               <dl class="nv3 nfirst present">
               		<dt class="redprice">판매가</dt>
					<dd class="redprice">
						<div class="present_price" id="Price"><span class="present_num">${product.price }</span> 원  </div>
					</dd>
                    <dt class="redprice">배송방식</dt ><dd class="redprice">
                     <span class="">${product.deliverytype }</span>                  
                    </dd>
                    <dt class="redprice">판매자</dt>
                    <dd class="redprice">
                      <div class="" id="Price"><span class="">${product.seller }</span></div>
                    </dd> 
				</dl> 
                  <c:if test="${login.memberId!=product.seller}">
                  <c:if test="${product.auctionstate=='BEFORE'}">
                <a class="button button-xs button-secondary" id="purchase" href="/order/payment/${product.productId}">구매하기</a>
                </c:if>
                <c:if test="${product.auctionstate=='AFTER'}">
                <a class="button button-xs button-secondary" id="purchase" href="/product/used">판매완료.. 리스트 페이지로..</a>
                </c:if>
               </c:if>
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
        
        <div class="shell">
          <div class="range range-xs-center">
            <div class="cell-sm-10 cell-lg-8">
            <p class="h3-alternate">상세 정보</p>
		            <%-- <p class="text-spacing-sm">
		            ${product.productinfo }
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
        
        <!-- 댓글 시작 -->
        <section class="section section-lg bg-white reply-section" >
        <div class="shell-wide" id="writeReply">
        <div class="range range-xs-center">
               <div class="cell-md-10 cell-lg-8 cell-xl-6 sections-collapsable">
          <!-- 댓글 작성란 -->
              <c:choose>
                <c:when test="${not empty login }">
                  <div class="section-lg section-write" >
                    <p class="h3-alternate">문의 작성</p>
                      <div id="set-range" class="range">
                        <div class="cell-xs-12">
                          <div class="form-wrap form-wrap-validation">
                            <input id="memberId" type="hidden" name="memberId" value="${login.memberId}">
                            <input id="productId" type="hidden" name="productId">
                            <textarea class="form-input" id="form-comment-message" name="content" style="resize: none"></textarea>
                          </div>
                        </div>
                        <div class="cell-xs-12 offset-custom-1">
                          <div class="form-button">
                            <button id="btn-send" class="btn btn-primary send-comment" type="button">send comment</button>
                          </div>
                        </div>
                      </div>
                  </div>
                </c:when>
                <c:otherwise></c:otherwise>
              </c:choose>
              <!-- 댓글 작성란 끝 -->
          </div>
        </div>
        </div>
   
        <div class="shell-wide">
          <div class="range range-xs-center">
            <div class="cell-md-10 cell-lg-8 cell-xl-6 sections-collapsable">
              <div class="section-md qna">
                <p id="questions" class="h3-alternate">상품 문의</p>
                <div id="reply-list" class="comment-group">
                </div>
        <div class='text-center'>
          <ul id="pagination" class="pagination pagination-sm no-margin "></ul>
        </div>
              </div>
               <!-- 기능 버튼 시작 -->
              <c:choose>
                <c:when test="${not empty login }">
                  <div class="section-lg qna-write">
                    <form action="/product/used/modify/${product.productId}">
                          <div class="form-button btn-function">
                            <c:choose>
                              <c:when test="${login.memberId == product.seller }">
                                <button class="btn back" type="button">Go List</button>
                                <button class="btn btn-warning modify" type="submit">Modify</button>
                                <button class="btn btn-danger delete" type="button" data-toggle="modal" data-target="#deleteModal">Delete</button>
                              </c:when>
                              <c:otherwise>
                                <button class="btn btn-warning back" type="button">Go Back</button>
                              </c:otherwise>                              
                            </c:choose>
                          </div>
                    </form>
                  </div>
                </c:when>
                <c:otherwise></c:otherwise>
              </c:choose>
              <!-- 기능 버튼 끝 -->
            </div>
          </div>
        </div>
      </section>
        <!-- 댓글 끝 -->
      
      </section>
      <!-- Product Page END-->
      
     
      <%-- Page Footer--%>
      <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
     
    </div>
    <%-- PANEL--%>
    <%-- END PANEL--%>
    <%-- Global Mailform Output--%>
    <div class="snackbars" id="form-output-global"></div>
    
    <!-- 댓글 작성/수정 모달 -->
    <div id="myModal" class="modal fade" role="dialog">
      <div class="modal-dialog">
    
        <!-- 모달 내용-->
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title-reply"></h5>
          </div>
          <div class="modal-body"> 
            <textarea class="tarea-reply" rows="3"></textarea>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default btn-register" data-dismiss="modal"></button>
            <button type="button" class="btn btn-default btn-close" data-dismiss="modal">Cancel</button>
          </div>
        </div>
    
      </div>
    </div>
    <!-- 댓글 작성/수정 모달 끝 -->
    
    <!-- 댓글 삭제 모달 -->
    <div id="deleteModal" class="modal fade" role="dialog">
      <div class="modal-dialog modal-sm">
    
        <!-- 모달 내용-->
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title-delete">댓글 삭제</h5>
          </div>
          <div class="modal-body"> 
            <span>정말 삭제하시겠습니까?</span>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default btn-register" data-dismiss="modal">Delete</button>
            <button type="button" class="btn btn-default btn-close" data-dismiss="modal">Cancel</button>
          </div>
        </div>
    
      </div>
    </div>
    <!-- 댓글 삭제 모달 끝 -->
    
    <script id="template" type="text/x-handlebars-template">
  	<div class="reply-container">
      <article class="comment">
        <div class="comment-body">
        <div class="comment-header">
          <input class="productid" type="hidden" value="{{productId}}">
          <p class="comment-title" id="{{ memberId }}">{{ memberId }}</p>
            <time class="comment-time" datetime="2017">{{ regdate }}</time>
            <div class="comment-footer">
              <button type="button" class="btn btn-info btn-sm btn-reply" data-toggle="modal" data-target="#myModal" value="{{replyId}}">Reply</button>
                  <button type="button" name="{{content}}" class="btn btn-success btn-sm btn-reply-modify" data-toggle="modal" data-target="#myModal" value="{{replyId}}">Modify</button>
                  <button type="button" class="btn btn-danger btn-sm btn-reply-delete" data-toggle="modal" data-target="#deleteModal" value="{{replyId}}">Delete</button>
            </div>
          </div>
          <div class="comment-text">
            <p>{{content}}</p>
          </div>
        </div>
      </article>
  	</div>
    </script>
    
    <script id="template2" type="text/x-handlebars-template">
    <div class="reply-container rcontainer-type2">
      <article class="comment">
    <img class="replyicon" alt="reply" src="/resources/images/img/reply.png" width="20" height="20" style="left: {{levelNo}}px">
        <div class="comment-body" style="margin-left: {{levelNo}}px">
        <div class="comment-header">
          <input class="productid" type="hidden" value="{{productId}}">
          <p class="comment-title" id="{{ memberId }}">{{ memberId }}</p>
            <time class="comment-time" datetime="2017">{{ regdate }}</time>
            <div class="comment-footer">
              <button type="button" class="btn btn-info btn-sm btn-reply" data-toggle="modal" data-target="#myModal" value="{{replyId}}">Reply</button>
              <button type="button" name="{{content}}" class="btn btn-success btn-sm btn-reply-modify" data-toggle="modal" data-target="#myModal" value="{{replyId}}">Modify</button>
              <button type="button" class="btn btn-danger btn-sm btn-reply-delete" data-toggle="modal" data-target="#deleteModal" value="{{replyId}}">Delete</button>
            </div>
          </div>
          <div class="comment-text">
            <p>{{content}}</p>
          </div>
        </div>
     </article>
    </div>
    </script>
    
    <script id="template3" type="text/x-handlebars-template">
    <div class="reply-container">
      <article class="comment">
        <div class="comment-body" style="margin-left: {{levelNo}}px">
          <div class="comment-text">
            <p><strong>삭제된 글입니다.</strong></p>
          </div>
        </div>
     </article>
    </div>
    </script>
    
    <script id="template4" type="text/x-handlebars-template">
    <div class="reply-container rcontainer-type2">
      <article class="comment">
    <img class="replyicon" alt="reply" src="/resources/images/img/reply.png" width="20" height="20" style="left: {{levelNo}}px">
        <div class="comment-body" style="margin-left: {{levelNo}}px">
          <div class="comment-text">
            <p><strong>삭제된 글입니다.</strong></p>
          </div>
        </div>
     </article>
    </div>
    </script>
    
    <script id="template5" type="text/x-handlebars-template">
    	<div id="emptyList">등록된 문의가 없습니다.</div>
    </script>
    
    <%-- Javascript--%>
    <script src="/resources/js/core.min.js"></script>
    <script src="/resources/js/script.js"></script>
    <script>
function chatting() {
  window.open("http://192.168.78:7777/chat?productId=${product.productId}&memberId=${login.memberId}" ,'pbml_win','toolbar=no,location=no,directories=no, status=no,menubar=no,resizable=yes, scrollbars=yes,width=400,height=500,left=0,top=0' );
}
function noteSend(){
  window.open("/note/${product.seller}" ,'pbml_win','toolbar=no,location=no,directories=no, status=no,menubar=no,resizable=yes, scrollbars=yes,width=650,height=800,left=0,top=0' );  
}
</script>
  </body>
</html>