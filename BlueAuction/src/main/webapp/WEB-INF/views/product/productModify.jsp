<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
    
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
     <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <script src="/resources/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/resources/js/upload.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
   
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
      
      $(document).ready(function() {
    	  /* 첨부파일 선택지 자동 업로드 */
          $("input[type=file]").change(function() {
             handleUpload();
          });
          sendAttachment();
         
      });
      
      /* ajax로 이미지 파일 전송 및 썸네일 출력 */
      function handleUpload() {
   
         var template = Handlebars.compile($("#template").html());
         
         var file = $("input[type=file]")[0].files[0];
         
         var formData = new FormData();
         
         formData.append("file", file);
         
         $.ajax({
            
            url: "/product/attach/",
            data: formData,
            dataType: "text",
            processData: false,
            contentType: false,
            type: "POST",
            success: function(data) {
               var fileInfo = getFileInfo(data);
                 
                 var html = template(fileInfo);
                 
                 $(".uploadedList").append(html);
               $("#photo").val(""); 
            }
            
         });
         
      };
      
      /* 첨부파일 정보 Form에 추가 후 submit */
      function sendAttachment() {
          $("#modifyForm").submit(function(event){
            event.preventDefault();
            
            var that = $(this);
            
            var str ="";
            $(".uploadedList .delbtn").each(function(index){
               str += "<input type='hidden' name='photo["+index+"]' value='"+$(this).attr("href") +"'> ";
            });
            
            that.append(str);
            that.get(0).submit();
          });
      };		
      
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
                    <form class="rd-mailform text-left" id="modifyForm" method="post" action="/product/auction/modify/${product.productId}">
                    <input type="hidden" name="categoryId" value="2">
                    <input type="hidden" name="smallId" value="${product.smallid}">
                    
                      <div class="range range-20">
                        <div class="cell-sm-12">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-name">title</label>
                            <input class="form-input" id="forms-3-name" type="text" name="name" data-constraints="@Required" value="${product.name}">
                          </div>
                        </div>
                        <div class="cell-sm-12">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-last-name">seller</label>
                            <input class="form-input" id="forms-3-last-name" type="text" name="seller" data-constraints="@Required" readonly="readonly" value="${product.seller}">
                          </div>
                        </div>
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-company">Start Price</label>
                            <input class="form-input" id="forms-3-company" type="text" name="basicprice" data-constraints="@Required"  value="${product.basicprice}">
                          </div>
                        </div>
                        <div class="cell-sm-8">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Reason For Sale</label>
                            <input class="form-input" id="forms-3-city" type="text" name="salemotive" value="${product.salemotive}" >
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Period Of Use</label>
                            <input class="form-input" id="forms-3-city" type="text" name="usingtime" value="${product.usingtime}">
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Delivery Type</label>
                              <div class="form-wrap box-width-1">
                                <select class="form-control select-filter" data-placeholder="All" data-minimum-results-for-search="Infinity" data-constraints="@Selected" name="deliverytype">
                                  <option value="0"> 주문방식 선택 </option>
                                  <c:choose>
                                     <c:when test='${(product.deliverytype).equals("Direct Dealing")}'>
                                        <option value="Direct Dealing" selected="selected">Direct Dealing</option>
                                     </c:when>
                                     <c:otherwise>
                                        <option value="Direct Dealing">Direct Dealing</option>
                                     </c:otherwise>
                                  </c:choose>
                                  
                                  <c:choose>
                                     <c:when test='${(product.deliverytype).equals("Parcel Service")}'>
                                        <option value="Parcel Service" selected="selected">Parcel Service</option>
                                     </c:when>
                                     <c:otherwise>
                                        <option value="Parcel Service">Parcel Service</option>
                                     </c:otherwise>
                                  </c:choose>
                                </select>
                              </div>
                          </div>
                        </div>
                         <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Auction Date</label>
                           <%--  <input type="date" class="form-input data" id="form-element-date" data-time-picker="date" name="auctionstart" value="${product.auctionstart}" > --%>
                           <input type="datetime-local" class="form-input" step='3600' value="" name="auctionstart" data-constraints="@Required" >
                          </div>
                        </div>
                        
                        <div class="cell-sm-12">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-street-address">Product Information</label>
                            <textarea class="form-input" rows="6" cols="100%" name="productinfo" data-constraints="@Required" style="resize: none;">${product.productinfo}</textarea>
                          </div>
                        </div>
                        
                       <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Photos</label>
                            <button class="button button-secondary reg" type="button">Select File</button>
                            <input class="form-input file" id="photo" type="file" multiple="multiple" name="photo">
                          </div>
                        </div>
                          <!-- 사진 보여주는 곳 -->
                        <div class="cell-md-12">
                          <ul class="mailbox-attachments clearfix uploadedList"></ul>
                        </div>
                        
                       <%--  <input type='hidden' name='page' value="${page}"> 
                       <input type='hidden' name='type' value="${type}">
                       <input type='hidden' name='keyword' value="${keyword}"> --%>
                        
                        <div class="cell-sm-12 offset-custom-1">
                          <div class="form-button text-sm-right">
                            <button class="button button-secondary" type="submit">Modify</button>
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
    <!-- PANEL-->
    <!-- END PANEL-->
    <!-- Global Mailform Output-->
    <div class="snackbars" id="form-output-global"></div>
    <!-- Javascript-->
    <script src="/resources/js/core.min.js"></script>
    <script src="/resources/js/script.js"></script>
  </body>
</html>