<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html class="wide wow-animation" lang="en">
  <head>
    <!-- Site Title-->
    <title>Register</title>
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
    <link rel="stylesheet" href="/resources/css/ksj-css.css">
    <link rel="stylesheet" href="/resources/css/cms-register.css">
    <link rel="stylesheet" href="/resources/css/cms-attachment.css">
    <link rel="stylesheet" href="/resources/css/hideSearch.css">
    
    <script src="/resources/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/resources/js/upload.js"></script>
    <script type="text/javascript" src="/resources/js/fileUpload.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
		<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--> 
    
    
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
    
		$(document).ready(function() {
			
			/* 첨부파일 유효성 검사 */
			$(function(){
				checkValidate();
				$("input:file").change(checkValidate);
			});
    
			sendAttachment();
			
			autoUpload();
			
		});
		
		/* 첨부파일 삭제 */
		$(document).on("click", ".uploadedList .delbtn", function(event){
			
			event.preventDefault();
			
			var that = $(this);
			 
		 	$.ajax({
			   url:"/product/attach/deleteFile",
			   type:"post",
			   data: {fileName:$(this).attr("href")},
			   dataType:"text",
			   success:function(result){
				   if(result == 'deleted'){
					   that.closest("li").remove();
				   }
			   }
		   }); 
		 	
		});
		
		/* 상품 리스트로 돌아가기 */
		var form = document.createElement("form");
		$(document).on("click", ".cancel", function() {
			form.setAttribute("method", "get");
			form.setAttribute("action", "/product/used");
			document.body.appendChild(form);
			form.submit();
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
          <p class="heading-1 breadcrumbs-custom-title">Used Stuff Register</p> 
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
                    <form id="registerForm" method="post" action="/product/used/register">
                      <input type="hidden" name="auctionFlag" value="N">
                      <input type="hidden" name="categoryId" value="1">
                      <div class="range range-20">
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-name">Seller</label>
                            <input class="form-input" id="forms-3-name" type="text" name="seller" data-constraints="@Required" value="${login.memberId }" readonly="readonly">
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Small Category</label>
                              <div class="form-wrap box-width-1">
                                <select class="form-control select-filter" data-placeholder="All" data-minimum-results-for-search="Infinity" name="smallid">
                                  <option value="1" selected="selected">의류</option>
                                  <option value="2">잡화</option>
                                  <option value="3">티켓</option>
                                  <option value="4">가전제품</option>
                                </select>
                              </div>
                          </div>
                        </div>
                        <div class="cell-sm-8">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-last-name">Product Name</label>
                            <input class="form-input" id="forms-3-last-name" type="text" name="name" data-constraints="@Required" required="required">
                          </div>
                        </div>
                        <div class="cell-sm-8">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-last-name">Reason For Sale</label>
                            <input class="form-input" id="forms-3-last-name" type="text" name="salemotive" data-constraints="@Required" >
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-company">Period Of Use</label>
                            <input class="form-input" id="forms-3-company" type="text" name="usingtime" data-constraints="@Required" required="required">
                          </div>
                        </div>
                        <div class="cell-sm-3">
                          <div class="form-wrap form-wrap-validation">
                            <label class="ksj-numberInput form-label-outside" for="forms-3-city">Price</label>
                            <input class="form-input" id="forms-3-city" type="number" min="1000" name="price" data-constraints="@Required" required="required">
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Delivery Type</label>
                              <div class="form-wrap box-width-1">
                                <select class="form-control select-filter" data-placeholder="All" data-minimum-results-for-search="Infinity" name="deliverytype">
                                  <option value="직거래" selected="selected">직거래</option>
                                  <option value="택배">택배</option>
                                </select>
                              </div>
                          </div>
                        </div>
                        <div class="cell-xs-12">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-street-address">Product Information</label>
                            <textarea class="form-input" rows="10" cols="100%" name="productinfo" data-constraints="@Required" style="resize: none" required="required"></textarea>
                          </div>
                        </div>
                      </div>
                        <div id="photodiv" class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label id="photholabel" class="form-label-outside" for="forms-3-city">Photos</label>
                            <button id="filebutton" class="btn btn-primary reg btn-select" type="button">Select File</button>
                            <input class="form-input file" id="photo" type="file" name="photo">
                          </div>
                        </div>
                        <div class="cell-md-12">
                          <ul class="mailbox-attachments clearfix uploadedList"></ul>
                        </div>
                        <div class="cell-md-12 offset-custom-1">
                          <div class="form-button text-sm-right">
                            <button class="btn btn-primary" type="submit">Register</button>
                            <button class="btn cancel" type="button">Cancel</button>
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