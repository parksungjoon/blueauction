<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <link rel="stylesheet" href="/resources/css/cms-register.css">
    <link rel="stylesheet" href="/resources/css/cms-attachment.css">
    <link rel="stylesheet" href="/resources/css/hideSearch.css">
    
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
     <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <script src="/resources/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/resources/js/upload.js"></script>
    <script type="text/javascript" src="/resources/js/fileUpload.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
    <script type="text/javascript" src="/resources/js/makeComma.js"></script>
   
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
    
    <script id="template" type="text/x-handlebars-template">
      <li class="attachment">
           <span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
           <div class="mailbox-attachment-info">
           <a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
           <a href="{{fullName}}"  
           class="btn btn-default btn-xs pull-right delbtn">x<i class="fa fa-fw fa-remove"></i></a>
           </span>
           </div>
      </li>                
  </script>
    
    <script type="text/javascript">
    var template = Handlebars.compile($("#template").html());
    
      $(document).ready(function() {
    	  
    	  var list = ${jsonproduct};
    	  
    	  var smallid = list.smallid;
    	  $("#smallid").val(smallid).prop("selected", true);
    	  
    	  var now = new Date();
    	  var year = now.getFullYear();
    	  var month = now.getMonth() + 1;
    	  var day = now.getDate()+1;
    	  if(day >=1 || day <10){
				day = "0"+day;
			}
    	  var nowDate = year+"-"+month+"-"+day+"T00:00";
    	  
    	  /* 경매시간 유효성 검사 */
    	  var time = $("input[type=datetime-local]");
    	  time.attr("min", nowDate);
    	  time.attr("value", nowDate);
    	  
    	  /* 저장된 사진 있을경우 가져옴 */
    	  var photoList = list.photo;
    	  for (var i = 0; i < photoList.length; i++) {
    		  var photo = photoList[i];
    		  photo = photoList[i].substring(0, 12) + "s_" + photoList[i].substring(12);
    		  
    		  var fileInfo = getFileInfo(photo);
              
    		  var html = template(fileInfo);
              
              $(".uploadedList").append(html);
			}
    	  
    	  /* 경매 시작 날짜 */
    	  var date = list.auctionstart;
    	  date = date.substring(0, 10)+"T"+date.substring(11);
    	  $("#auctionstart").attr("value", date);
    	  
          sendAttachment();
          autoUpload();
          fileSize = ${filesSize};
      });
      
      /* 첨부파일 삭제 */
      $(document).on("click", ".uploadedList .delbtn", function(event){
         event.preventDefault();
         var that = $(this);
         that.closest("li").remove();
      });
      
	  /**  수정 취소 버튼 클릭 이벤트 */
	  $("#can").click(function(){
		  window.history.back();
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
                    <form class="rd-mailform text-left" id="registerForm" method="post" action="/product/auction/modify/${product.productId}">
                    	<input type="hidden" name="auctionFlag" value="Y">
                    	<input type="hidden" name="categoryId" value="2">
                      <div class="range range-20">
                      <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-name">Seller</label>
                            <input class="form-input" type="text" name="seller" data-constraints="@Required" value="${product.seller}" readonly="readonly"required="required">
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Small Category</label>
                              <div class="form-wrap box-width-1">
                                <select class="form-control select-filter" data-placeholder="All" data-minimum-results-for-search="Infinity" id="smallid" name="smallid" >
                                  <option value="1">옷</option>
                                  <option value="2">잡화</option>
                                  <option value="3">티켓</option>
                                  <option value="4">가전제품</option>
                                </select>
                              </div>
                          </div>
                        </div>
                        <div class="cell-sm-10">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-last-name">Product Name</label>
                            <input class="form-input" type="text" name="name" data-constraints="@Required" value="${product.name}" required="required">
                          </div>
                        </div>
                        <div class="cell-sm-10">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-last-name">Reason For Sale</label>
                            <input class="form-input" type="text" name="salemotive" value="${product.salemotive}"  >
                          </div>
                        </div>
                        <div class="cell-sm-5">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-company">Period Of Use</label>
                            <input class="form-input" type="text" name="usingtime" value="${product.usingtime}" data-constraints="@Required" required="required">
                          </div>
                        </div>
                        <div class="cell-sm-5">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside ksj-numberInput" for="forms-3-company">basicPrice</label>
                            <input class="form-input" type="text" onchange="getNumber(this);" onkeyup="getNumber(this);" step="1000" min="1000" value="<fmt:formatNumber value="${product.basicprice}" pattern='#,###.##'/>"
                           	       name="basicpriceTmp" data-constraints="@Required" required="required">
                           	<%-- <input class="form-input" type="text" onchange="getNumber(this);" onkeyup="getNumber(this);" step="1000" min="1000" value="<fmt:formatNumber value="${product.basicprice}" pattern='#,###.##'/>"
                           	       name="basicprice" data-constraints="@Required" required="required"> --%>
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Delivery Type</label>
                              <div class="form-wrap box-width-1">
                                <select class="form-control select-filter" data-placeholder="All" data-minimum-results-for-search="Infinity" data-constraints="@Selected" name="deliverytype" required>
                                  <option value="0"> 주문방식 선택 </option>
                                  <c:choose>
                                     <c:when test='${(product.deliverytype).equals("직거래")}'>
                                        <option value="직거래" selected="selected">직거래</option>
                                     </c:when>
                                     <c:otherwise>
                                        <option value="직거래">직거래</option>
                                     </c:otherwise>
                                  </c:choose>
                                  <c:choose>
                                     <c:when test='${(product.deliverytype).equals("택배")}'>
                                        <option value="택배" selected="selected">택배</option>
                                     </c:when>
                                     <c:otherwise>
                                        <option value="택배">택배</option>
                                     </c:otherwise>
                                  </c:choose>
                                </select>
                              </div>
                          </div>
                        </div>
                         <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Auction Date</label>
                           <input type="datetime-local" class="form-input" step='1800' id="auctionstart" name="auctionstart" data-constraints="@Required" required>
                          </div>
                        </div>
                        <div class="cell-sm-12">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-street-address">Product Information</label>
                            <textarea class="form-input" rows="6" cols="100%" id="info" name="productinfo" data-constraints="@Required" style="resize: none;" required>${product.productinfo}</textarea>
                          </div>
                        </div>
                        
                       <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Photos</label>
                            <button class="ksj-btn btn button-secondary reg" type="button">Select File</button>
                            <input class="form-input file" id="photo" type="file" multiple="multiple" name="photo">
                          </div>
                        </div>
                          <!-- 사진 보여주는 곳 -->
                        <div class="cell-md-12">
                          <ul class="mailbox-attachments clearfix uploadedList">
                          </ul>
                        </div>
                        
                        <div class="cell-sm-12 offset-custom-1">
                          <div class="form-button text-sm-right">
                          	<button type="submit" class="btn btn-warning" id="modify">Modify</button>
							<button id="can" class="btn btn-danger">Cancle</button>
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
    
     <!-- 첨부파일 경고 모달 시작 -->
    <div id="fileModal" class="modal fade" role="dialog">
      <div class="modal-dialog modal-sm">
    
        <!-- 모달 내용-->
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title-file">알림</h5>
          </div>
          <div class="modal-body"> 
            <span>5MB 이하로 파일을 첨부해 주세요.</span>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default btn-close" data-dismiss="modal">Close</button>
          </div>
        </div>
    
      </div>
    </div>
    <button id="btn-fileModal" class="btn btn-danger" type="button" data-toggle="modal" data-target="#fileModal"></button>
    <!-- 첨부파일 경고 모달 끝 -->
    
    <!-- PANEL-->
    <!-- END PANEL-->
    <!-- Global Mailform Output-->
    <div class="snackbars" id="form-output-global"></div>
    <!-- Javascript-->
    <script src="/resources/js/core.min.js"></script>
    <script src="/resources/js/script.js"></script>
  </body>
</html>