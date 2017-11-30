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
   <script src="/resources/js/countdown.js"></script>
   <script src="/resources/js/numberFmt.js"></script>
   <script type="text/javascript">
   	var page = 1;
	var type = ${type};
	var smallid = ${smallid};
	var keyword = null;
	 var arraytype = "recent";
	var lefth = 0;
	var leftm = 0;
	var lefts = 0;
	var auctionend;
	var hour;
	var minutes;
	var seconds;
	
	$(document).ready(function(){
    	
    	/* 정렬 종류 선택 */
    	$("#auction-array").change(function(event){
    		page = 1;
    		arraytype = $(this).attr("value");
    		
    		ajaxPost("html"); // post로 ajax
    	});
    	
    	/* 관심경매 버튼(하트 버튼) 클릭 시 관심경매 등록, 삭제 */
    	$(document).on("click", ".jjh-favoriteButton", function(event){
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
    	
    	/* 경매 검색 가능 */
    	$(".form-button").click(function(event){
    		if(type != 3){
    			page = 1;
    			keyword = $("#rd-navbar-search-form-input").val();

				ajaxPost("html");
    		}else{
    			$(".jjh-modalMessage").html("마감된 경매 페이지에서는 검색이 불가능 합니다.");
    			$("#cannotSearch").modal("show");
    		}
    	});
    	
    	/** 페이지 더보기 */
    	$(document).on("click", ".jjh-pageLoader", function(event){
			event.preventDefault(); // 페이지 이벤트 발생시 화면이 맨위로 올라가는 것 방지
  			page = page + 1; // 페이지 1증가
  			
  			ajaxPost("append"); // post로 ajax
    	});
   		
   		/** 새로운 경매 등록 */
    	 $("#registerAction").click(function () {
    		var form = document.createElement("form");
            form.setAttribute("action", "/product/auction/register");    
            form.setAttribute("method", "get");
            
            document.body.appendChild(form);
            form.submit();

		});
   		
   		function fromData(href){
   			var form = document.createElement("form");
   			form.setAttribute("action", href);	
   			form.setAttribute("method", "post");
   			
   			var type = document.createElement("input");
   			type.setAttribute("type", "hidden");
   			type.setAttribute("name", "type");
   			type.setAttribute("value", type);
   			
   			var smallid = document.createElement("input");
   			smallid.setAttribute("type", "hidden");
   			smallid.setAttribute("name", "smallid");
   			smallid.setAttribute("value", smallid);
   			
   			var page = document.createElement("input");
   			page.setAttribute("type", "hidden");
   			page.setAttribute("name", "page");
   			page.setAttribute("value", "1");
   			if(${page != null}){
   				page.setAttribute("value", page);
   			}
   			
   			var keyword = document.createElement("input");
   			keyword.setAttribute("type", "hidden");
   			keyword.setAttribute("name", "keyword");
   			keyword.setAttribute("value", "");
   			if(${keyword != null}){
   				keyword.setAttribute("value", keyword);
   			}
   			
   			form.appendChild(type);
   			form.appendChild(smallid);
   			form.appendChild(page);
   			form.appendChild(keyword);
   			
   			console.log(form);
   			
   			document.body.appendChild(form);
   			form.submit();
   		}
   		
   });
    
    /* post로 ajax */
   	function ajaxPost(data){
    	var patch = data // 붙이는 방식
   		$.ajax({
			type : "post",
			data : {page:page, keyword:keyword, arraytype:arraytype},
			dataType : "json",
			url:"/product/auction/" + type + "/" + smallid,
			success : function(data){
				var endpage = data.endpage;
	  				
	  			printPageLoader(endpage);
				
	  			if(patch == "html"){
	  				$(".auction-list").html(printList(data));
	  			}else{
	  				$(".auction-list").append(printList(data));
	  			}
			}
		});
   	}
   	
    /* 상품 리스트 출력 함수 */
    function printList(data){
    	var html = "";
    	type = data.type;
    	var list = data.list;
    	var favorite = data.favorite;
    	
    	if(list.length == 0){
    		html += "<h3 class='jjh-emptyList'>경매가 존재하지 않습니다.</h3>";
    	}else{
    		if(type == 2){
	 			getAuctionTime(list);
				setTime(seconds, minutes, hour); // 동적 생성 경매의 카운트 다운
	 		}
    		
    		for ( var i in list) {
        		html +="<div class='cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3'>";
      	  		html +="      <div class='product product-counter product-auction'>";
      	  		
      	  		if(type == 3){
      	  			html +="         <div class='product-counter-inner jjh-inner'>";
      	  		}else {
      	  			html +="         <div class='product-counter-inner'>";
      	  		}
      	  		
      	  		switch(type){
      	  		case 1 : html +="          <div class='jjh-counter' >" + list[i].auctionstart + "</div>"; break;
      	  		case 2 : html +="          <div class='countdown jjh-counter is-countdown jjh-timer' data-time='' data-format='DDHMS' data-type='until' data-layout='{hnn}{sep}{mnn}{sep}{snn}'></div>"; break;
      	  		case 3 : html +="          <div class='jjh-counter' >" + list[i].auctionend + " 종료</div>"; break;
      	  		}
      	  		
      	  		html +="        </div>";
      	  		
      	  		if(type ==3){
      	  			html +="        <div class='jjh-finished product-image jjh-image '><img src='/resources/images/img" + list[i].mainphoto + "' alt='images'/></div>";
      	  		}else{
      	  			html +="        <div class='product-image jjh-image'><img src='/resources/images/img" + list[i].mainphoto + "' alt='image'/></div>";
      	  		}
      	  		
      	  		html +="        <div class='product-title'>";
    	  		html +="          <h5>" + list[i].name +"</h5>";
    	  		html +="        </div>";
    	  		
    	  		if(type == 1){
    	  			html +="        <div class='product-price-wrap'>";
    	  	  		html +="          <div class='product-price'>";
    	  	  		html +="            <p>Start Price</p>";
    	  	  		html +="            <h6>" + setComma(list[i].basicprice) + "원</h6>";
    	  	  		html +="          </div>";
    	  	  		html +="        </div>";
    	  		}else if(type == 2){
    	  			html +="        <div class='jjh-price'>";
    	  	  		html +="          <div class='product-price'>";
    	  	  		html +="            <p>Start Price</p>";
    	  	  		html +="            <h6>" + setComma(list[i].basicprice) + "원</h6>";
    	  	  		html +="          </div>";
    	  	  		html +="          <br>";
    	  	  		html +="           <div class='jjh-currentPrice'>";
    	  	  		html +="             <p class=''><strong>Current Price</strong></p>";
    	  	  		
    	      	  	if(list[i].bidprice != 0){
    	            	html +="<h6>" + setComma(list[i].basicprice) + "원</h6>";
    	            }else{
    	            	html +="<h6 class='jjh-notSuccess'>" + setComma(list[i].basicprice) + "원</h6>";
    	            }
    	      	  	
    	  	  		html +="           </div>";
    	  	  		html +="        </div>";
    	  		}else{
    	  			html +="<div class='jjh-price'>";
    	            html +="<br>";
    	            html +="<div class='jjh-currentPrice'>";
    	            html +="<p class=''><strong>Successful bid</strong></p>";
    	            
    	            if(list[i].bidprice != 0){
    	            	html +="<h6>" + setComma(list[i].bidprice) + "원</h6>";
    	            }else{
    	            	html +="<h6 class='jjh-notSuccess'>" + setComma(list[i].basicprice) + "원</h6>";
    	            }
    	            
    	            html +="           </div>";
    	  	  		html +="        </div>";
    	  		}
    	  		
    	  		html +="        <div class='product-button'><a class='jjh-listButton button-secondary readPage' href='/product/auction/" + list[i].productId + "'>Detail</a></div>";
    	  		
    	  		if(type == 1){
      	  		if(${login ne null}){
          	  		// 관심경매 하트 표시
          	  		 for ( var j in favorite) {
          	  			var state = false; // 상품에 대한 관심경매 여부 초기화(false)
          				if(favorite[j].productId == list[i].productId){
          					state = true; // 관심경매로 등록된 상품이면 true
          					break;
          				}
          			}
          	  		
          	  		if(state){
          	  			html +="        <button class='jjh-favoriteButton' id='" + list[i].productId + "'><img alt='favorite-register' src='/resources/images/full-heart.png'></button>";
          	  		}else{
          	  			html +="        <button class='jjh-favoriteButton' id='" + list[i].productId + "'><img alt='favorite-register' src='/resources/images/empty-heart.png'></button>";
          	  		} 
        	  	}
      
    	  	}
    	  		html +="      </div>";
        	  	html +="    </div>";
        }
    }
    return html;
}
  	 
  	 /** 페이지 더보기 출력 */
  	 function printPageLoader(data){
  		 st = "";
  		 
  		 if(data == 'no'){
  			 st += "<a class='button-blog button button-default-outline jjh-pageLoader' href='#' >load more products</a>";
  		 }
  		 
  		 $(".jjh-pageMore").html(st);
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
          <p class="breadcrumbs-custom-subtitle">Auction Stuff</p>
          <p class="heading-1 breadcrumbs-custom-title">Product List</p>
          <ul class="breadcrumbs-custom-path">
            <li><a href="/">Home</a></li>
            <li><a href="#">Auction</a></li>
            <c:choose>
              <c:when test="${type == 1 }"><li class="active">Preparing Auction</li></c:when>
              <c:when test="${type == 2 }"><li class="active">Doing Auction</li></c:when>
              <c:when test="${type == 3 }"><li class="active">Finished Auction</li></c:when>
            </c:choose>
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
            
            <c:if test="${type == 1 }">
              <div id = "selectBox">
                <select id="auction-array">
                  <option value="recent" selected> 최근 등록 순</option>
                  <option value="fast"> 빠른 경매 순</option>
                </select>
              </div>
            </c:if>
            
              <div class="range range-70 text-left">
              <%-- 여기에 자기 부분 넣어주세요 --%>
                  <div class="range range-30 auction-list" style="z-index:1;">
                  
                  <c:choose>
                    <c:when test="${not empty list }">
                    <c:forEach items="${list}" var="product">
                        <div class="cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3">
                          <div class="product product-counter product-auction">
                          <c:choose>
                            <c:when test="${type == 1 }"><div class="product-counter-inner"></c:when>
                            <c:when test="${type == 2 }"><div class="product-counter-inner"></c:when>
                            <c:when test="${type == 3 }"><div class="product-counter-inner jjh-inner"></c:when>
                           </c:choose>
                              <c:choose>
                                <c:when test="${type == 1 }"><div class="jjh-counter" >${product.auctionstart }</div></c:when>
                                <c:when test="${type == 2 }"><div class="countdown jjh-counter" data-time="${product.auctionend }" data-format="DDHMS" data-type="until" data-layout="{hnn}{sep}{mnn}{sep}{snn}"></div></c:when>
                                <c:when test="${type == 3 }"><div class="jjh-counter" >${product.auctionend } 종료</div></c:when>
                              </c:choose>
                            </div>
                            <c:choose>
                              <c:when test="${type == 1 }"><div class="product-image jjh-image"><img src="/resources/images/img${product.mainphoto }" alt="image" /></div></c:when>
                              <c:when test="${type == 2 }"><div class="product-image jjh-image"><img src="/resources/images/img${product.mainphoto }" alt="image"/></div></c:when>
                              <c:when test="${type == 3 }"><div class="jjh-finished product-image jjh-image"><img src="/resources/images/img${product.mainphoto }" alt="image" /></div></c:when>
                            </c:choose>
                            <div class="product-title">
                              <h5>${product.name }</h5>
                            </div>
                            
                            <c:choose>
                              <c:when test="${type == 1 }">
                                <div class="product-price-wrap">
                                  <div class="product-price">
                                    <p>Start Price</p>
                                    <h6><fmt:formatNumber value="${product.basicprice }" pattern='#,###.##'/>원</h6>
                                  </div>
                                </div>
                              </c:when>
                              <c:when test="${type == 2 }">
                                <div class="jjh-price">
                                  <div class="product-price">
                                    <p>Start Price</p>
                                    <h6><fmt:formatNumber value="${product.basicprice }" pattern='#,###.##'/>원</h6>
                                  </div>
                                  <br>
                                  <div class="jjh-currentPrice">
                                    <p class=""><strong>Current Price</strong></p>
                                    <c:choose>
                                       <c:when test="${product.bidprice != 0 }">
                                        <h6> <fmt:formatNumber value="${product.bidprice }" pattern='#,###.##'/>원</h6>
                                       </c:when>
                                       <c:otherwise>
                                        <h6 class="jjh-notSuccess"><fmt:formatNumber value="${product.basicprice }" pattern='#,###.##'/>원</h6>
                                       </c:otherwise>
                                    </c:choose>
                                  </div>
                                </div>
                              </c:when>
                              <c:when test="${type == 3 }">
                                <div class="jjh-price">
                            <br>
                            <div class="jjh-currentPrice">
                              <p class=""><strong>Successful bid</strong></p>
                              <c:choose>
                                 <c:when test="${product.bidprice != 0 }">
                                    <h6><fmt:formatNumber value="${product.basicprice }" pattern='#,###.##'/>원</h6>
                                 </c:when>
                                 <c:otherwise>
                                   <h6 class="jjh-notSuccess"><fmt:formatNumber value="${product.basicprice }" pattern='#,###.##'/>원</h6>
                                  </c:otherwise>
                              </c:choose>
                            </div>
                          </div>
                              </c:when>
                            </c:choose>
                            
                            <div class="product-button"><a class="jjh-listButton button-secondary readPage" href="/product/auction/${product.productId }">Detail</a></div>
                            <c:if test="${type == 1 }">
                            
                            <c:if test="${not empty login}">
                              <%--for문 break를 위한 set --%>
                                <c:set value="false" var="doneLoop"/>
                                <c:forEach items="${favorite }" var="favorite">
                                  <c:if test="${not doneLoop }">
                                    <c:choose>
                                    <c:when test="${favorite.productId == product.productId }">
                                      <c:set value="true" var="state"/>
                                      <c:set value="true" var="doneLoop"/>
                                    </c:when>
                                    <c:otherwise>
                                      <c:set value = "false" var="state"/>
                                    </c:otherwise>
                                  </c:choose>
                                  </c:if>
                                </c:forEach>
                                
                                <c:choose>
                                  <c:when test="${state }">
                                    <button class="jjh-favoriteButton"  id="${product.productId }"><img alt="favorite-register" src="/resources/images/full-heart.png"></button>
                                  </c:when>
                                  <c:otherwise>
                                    <button class="jjh-favoriteButton"  id="${product.productId }"><img alt="favorite-register" src="/resources/images/empty-heart.png"></button>
                                  </c:otherwise>
                                </c:choose>
                             </c:if>

                            </c:if>
                          </div>
                        </div>
                </c:forEach>
                </c:when>
                <c:otherwise>
                  <h3 class="jjh-emptyList">경매가 존재하지 않습니다.</h3>
                </c:otherwise>
               </c:choose>
            </div>
                
              <span class="jjh-newBox" ><button class="button button-secondary jjh-newButton" type="button" id="registerAction">New Auction</button></span>
                
                <c:choose>
                  <c:when test="${endpage eq 'no' }">
                     <div class="jjh-pageMore"><a class="button-blog button button-default-outline jjh-pageLoader" href="#" >load more products</a></div>
                  </c:when>
                  <c:otherwise>
                      <div class="jjh-blanck"></div>
                  </c:otherwise>
                </c:choose>
              <br>
            </div>
          </div>
          
            <%-- Shop Sidebar START --%>
            <jsp:include page="/WEB-INF/views/include/productRightSidebar.jsp"></jsp:include>
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