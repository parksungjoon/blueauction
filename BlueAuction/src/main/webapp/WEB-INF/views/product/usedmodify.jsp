<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html class="wide wow-animation" lang="en">
  <head>
    <!-- Site Title-->
    <title>Modification</title>
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
    <script type="text/javascript" src="/resources/js/makeComma.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
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
			sendAttachment();
			autoUpload();
			setForm();
			fileSize = ${filesSize};
		});
		
		/* 첨부파일 임시 삭제 */
		$(document).on("click", ".uploadedList .delbtn", function(event) {
			event.preventDefault();
			$(this).parent().parent().remove();
		})
		
		var template = Handlebars.compile($("#template").html());
		
		/* 상품 정보 출력 */
		function setForm() {
			var options = $('option');
    		var product = ${jsonproduct};
			var images = product.photo;
    		
	 		for (var i = 0; i < options.length; i++) {
			    if (options[i].getAttribute("value") == product.smallid || options[i].getAttribute("value") == product.deliverytype) {
					options[i].setAttribute("selected", "selected");
				}
			}
	 		
	 		for (var i = 0; i < images.length; i++) {

	 			var imageName = images[i].substring(0,12) + 's_' + images[i].substring(12); 
	 			var fileInfo = getFileInfo(imageName);
	 			var html = template(fileInfo);
	 			 
	 			 $(".uploadedList").append(html);
			}
		}
		
		/* 상세 페이지로 돌아가기 */
		var form = document.createElement("form");
		$(document).on("click", ".cancel", function() {
			form.setAttribute("method", "get");
			form.setAttribute("action", "/product/used/" + ${product.productId});
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
          <p class="heading-1 breadcrumbs-custom-title">Modification Page</p> 
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
                    <form id="registerForm" method="post" action="/product/used/modify/${product.productId}">
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
                                <select id="smallcategory" class="form-control select-filter" data-placeholder="All" data-minimum-results-for-search="Infinity" name="smallid">
                                  <option value="1">의류</option>
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
                            <input class="form-input" id="forms-3-last-name" type="text" name="name" value="${product.name }" data-constraints="@Required" required="required">
                          </div>
                        </div>
                        <div class="cell-sm-8">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-last-name">Reason For Sale</label>
                            <input class="form-input" id="forms-3-last-name" type="text" name="salemotive" value="${product.salemotive }" data-constraints="@Required" >
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-company">Period Of Use</label>
                            <input class="form-input" id="forms-3-company" type="text" name="usingtime" value="${product.usingtime }" data-constraints="@Required" required="required">
                          </div>
                        </div>
                        <div id="pricediv" class="cell-sm-3">
                          <div class="form-wrap form-wrap-validation">
                            <label class="ksj-numberInput form-label-outside" for="forms-3-city">Price</label>
                            <input class="form-input" id="forms-3-city" type="text" onchange="getNumber(this);" onkeyup="getNumber(this);" min="1000" name="priceTmp" value="<fmt:formatNumber value="${product.price }" pattern='#,###.##'/>" data-constraints="@Required" required="required">
<%--                             <input class="form-input" id="forms-3-city" type="text" onchange="getNumber(this);" onkeyup="getNumber(this);" min="1000" name="price" value="<fmt:formatNumber value="${product.price }" pattern='#,###.##'/>" data-constraints="@Required" required="required"> --%>
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Delivery Type</label>
                              <div class="form-wrap box-width-1">
                                <select id="deliverytype" class="form-control select-filter" data-placeholder="All" data-minimum-results-for-search="Infinity" name="deliverytype">
                                  <option value="직거래">직거래</option>
                                  <option value="택배">택배</option>
                                </select>
                              </div>
                          </div>
                        </div>
                        <div class="cell-xs-12">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-street-address">Product Information</label>
                            <textarea class="form-input" rows="10" cols="100%" name="productinfo" data-constraints="@Required" style="resize: none" required="required">${product.productinfo }</textarea>
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
                            <button class="btn btn-warning modify" type="submit">Modify</button>
                            <button class="btn btn-danger cancel" type="button">Cancel</button>
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