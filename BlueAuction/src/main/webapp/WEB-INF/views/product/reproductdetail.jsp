<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="wide wow-animation" lang="en">
  <head>
    <%-- Site Title--%>
    <title>Home</title>
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <link rel="icon" href="resources/images/favicon.ico" type="image/x-icon">
    <%-- Stylesheets --%>
    <link rel="stylesheet" href="resources/css/ksj-css.css">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/mdi.css">
    <link rel="stylesheet" href="resources/css/fl-bigmug-line.css">
    <link rel="stylesheet" href="resources/css/cms-pdetail.css">
     
		<%--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/">
    <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--%> 
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
        <div class="shell shell-bigger product-single">
          <div class="range range-ten range-xs-center range-md-justify range-30 range-md-middle">
          
          	<!-- 상품 이미지 START -->
            <div class="cell-md-4 cell-lg-5 cell-xl-4">
              <div class="product-single-preview">
                <div class="unit unit-sm-horizontal unit-sm-middle unit-spacing-md-midle unit--inverse unit-sm">
                  <div class="unit-body">
                    <ul class="product-thumbnails">
                      <li class="active" data-large-image="images/shop-01-420x550.png"><img src="resources/images/shop-01-54x71.png" alt="" width="54" height="71"></li>
                      <li data-large-image="images/shop-02-420x550.png"><img src="resources/images/shop-02-54x71.png" alt="" width="54" height="71"></li>
                    </ul>
                  </div>
                  <div class="unit-right product-single-image">
                    <div class="product-single-image-element"><img class="product-image-area animateImageIn" src="resources/images/shop-01-420x550.png" alt=""></div>
                  </div>
                </div>
              </div>
            </div>
            <!-- 상품 이미지 END -->
            
            <div class="cell-md-6 cell-lg-5 cell-xl-5 text-center text-md-left">
              <div class="heading-5">소분류명</div>
              <h3>제품명(title)</h3>
              <div class="divider divider-default"></div>
              <div class="detail">
               <dl class="nv3 nfirst present">
               		<dt class="redprice">현재가</dt>
					<dd class="redprice">
						<div class="present_price" id="Price"><span class="present_num">152,000</span> 원  </div>
						<div class="point"><span class="sf fc6">  시작가   <span class="num_thm">1,000</span> 원 </span></div>
					</dd>
					<dt class="redprice">입찰수</dt ><dd class="redprice">141회</dd>
					<dt class="redprice">남은시간</dt ><dd class="redprice"><span class="auction_time">00:24:12</span>
                    <dt class="redprice">배송방식</dt ><dd class="redprice"><span class="">택배</span>
                    </dd> 
				</dl> 
                <a class="button button-xs button-secondary" href="#">입찰하기</a>
              </div>
            </div>
          </div>
        </div>
        
        <div class="shell">
          <div class="range range-xs-center">
            <div class="cell-sm-10 cell-lg-8">
            <p class="h3-alternate">상세 정보</p>
		            <p class="text-spacing-sm">
		            We are proud to offer you our hi-tech original goods. 
		            The products of our store are the real bestsellers and we have a great number of faithful customers. 
		            Their testimonials prove that the reputation of our company is simply perfect. 
		            We observe the policy of providing only branded commodities. 
		            This fact confirms that we sell only high quality goods at a fair price. 
		            </p>
            </div>
          </div>
        </div>
        
        <!-- 댓글 시작 -->
        <section class="section section-lg bg-white reply-section">
        <div class="shell-wide">
          <div class="range range-xs-center">
            <div class="cell-md-10 cell-lg-8 cell-xl-6 sections-collapsable">
              <div class="section-md qna">
                <p class="h3-alternate">상품 관련 문의</p>
                <div class="comment-group">
                  <!-- 댓글 -->
                  <div class="reply-container">
                  <article class="comment">
                    <div class="comment-body">
                      <div class="comment-header">
                        <p class="comment-title">김봉환</p>
                        <time class="comment-time" datetime="2017">2 days ago</time>
                        <div class="comment-footer"><a class="comment-link-reply" href="#">Reply</a></div>
                      </div>
                      <div class="comment-text">
                        <p>이거 별로에요.</p>
                      </div>
                    </div>
                  </article>
                  </div>
                    <!-- 댓글 -->
                    <div class="reply-container reply-flag">
                    <article class="comment reply">
                    <img src="resources/images/img/reply.png" alt="" width="20" height="20"/>
                      <div class="comment-body">
                        <div class="comment-header">
                          <p class="comment-title">수리님</p>
                          <time class="comment-time" datetime="2017">2 days ago</time>
                          <div class="comment-footer"><a class="comment-link-reply" href="#">Reply</a></div>
                        </div>
                        <div class="comment-text">
                          <p>그쪽도 별로에요.</p>
                        </div>
                      </div>
                    </article>
                    </div>
                  <!-- 댓글 -->
                  <div class="reply-container" style="border-bottom: 1px solid gray">  
                  <article class="comment">
                    <div class="comment-body">
                      <div class="comment-header">
                        <p class="comment-title">김수진</p>
                        <time class="comment-time" datetime="2017">2 days ago</time>
                        <div class="comment-footer"><a class="comment-link-reply" href="#">Reply</a></div>
                      </div>
                      <div class="comment-text">
                        <p>여기 이상해요.</p>
                      </div>
                    </div>
                  </article>
                  </div>
                </div>
              </div>
              <!-- 댓글 작성란 -->
              <div class="section-lg qna-write">
                <p class="h3-alternate">문의 작성</p>
                <form class="rd-mailform" data-form-output="form-output-global" data-form-type="contact" method="post" action="bat/rd-mailform.php">
                  <div class="range range-20">
                    <div class="cell-xs-12">
                      <div class="form-wrap form-wrap-validation">
                        <textarea class="form-input" id="form-comment-message" name="message" data-constraints="@Required"></textarea>
                      </div>
                    </div>
                    <div class="cell-xs-12 offset-custom-1">
                      <div class="form-button">
                        <button class="button button-secondary" type="submit">send comment</button>
                      </div>
                    </div>
                  </div>
                      <div class="form-button btn-function">
                        <button class="button button-secondary" type="submit">Modify</button>
                        <button class="button button-secondary back" type="submit">Go Back</button>
                      </div>
                </form>
              </div>
              <!-- 댓글 작성란 끝 -->
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
    
    <%-- Javascript--%>
    <script src="resources/js/core.min.js"></script>
    <script src="resources/js/script.js"></script>
  </body>
</html>