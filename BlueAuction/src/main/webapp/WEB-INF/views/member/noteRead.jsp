<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="wide wow-animation" lang="en">
<head>
<%-- Site Title--%>
<title>Home</title>
<meta name="format-detection" content="telephone=no">
<meta name="viewport"
  content="width=device-width, height=device-height, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="utf-8">
<link rel="icon" href="/resources/images/favicon.ico"
  type="image/x-icon">
<%-- Stylesheets --%>
<link rel="stylesheet" href="/resources/css/ksj-css.css">
<link rel="stylesheet" type="text/css"
  href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet" href="/resources/css/mdi.css">
<link rel="stylesheet" href="/resources/css/fl-bigmug-line.css">

<%--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/">
    <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--%>

<script src="/resources/js/jquery-1.12.4.min.js"></script>

</head>

<body>
  <%-- Page preloader--%>
  <jsp:include page="/WEB-INF/views/include/pageloader.jsp" />

  <%-- Page--%>
  <div class="page">

    <%-- page Header START --%>
    <jsp:include page="/WEB-INF/views/include/header.jsp" />
    <%-- page Header END --%>

    <!-- Breadcrumbs START -->
    <section
      class="breadcrumbs-custom breadcrumbs-custom-svg bg-gradient breadcrumbs-background-01">
    <div class="shell">
      <p class="breadcrumbs-custom-subtitle">Product</p>
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
       
        
         <!-- Hover Row Table (입찰 리스트) START -->
          <section class="section section-lg bg-white">
        <div class="shell shell-bigger">
          <div class="range range-ten range-50 range-sm-center range-lg-justify">
            <div class="cell-sm-9 cell-md-6">
              <h3>쪽지읽기</h3>
              <hr class="divider divider-left divider-default">
              <!-- RD Mailform-->
              <!-- <form class="rd-mailform" data-form-output="form-output-global" data-form-type="contact" method="post"> -->
                <div class="range range-20">
                  <div class="cell-sm-6">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="form-1-name">제목</label>
                      <input class="form-input" id="sender" type="text" name="sender" value="${note.subject}" data-constraints="@Required"/>
                    </div>
                  </div>
                  <div class="cell-sm-6">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="form-1-last-name">보낸사람</label>
                      <input class="form-input" id="receiver" type="text" name="receiver" value="${note.sender}" data-constraints="@Required"/>
                    </div>
                  </div>
                  <div class="cell-sm-12">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="form-1-phone">보낸날짜</label>
                      <input class="form-input" id="subject" type="text" name="subject" value="${note.regdate}" data-constraints="@Required"/>
                    </div>
                  </div>
                  <div class="cell-xs-12">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="form-1-message">내용</label>
                      <textarea class="form-input" id="content" name="content"  data-constraints="@Required">${note.content}</textarea>
                    </div>
                  </div>
                  <div class="cell-xs-12 offset-custom-1">
                    <div class="form-button">
                      <!-- <button class="button button-secondary" id="sendNote">답장하기</button> -->
                      <a class="button button-secondary" href="#" onclick="javascript:noteSend()">답장하기</a>
                      <button class="button button-secondary" id="removeNote">삭제하기</button>
                    </div>
                  </div>
                </div>
                <form role="form" method="post">
                  <input type="hidden" name="noteId" value="${note.noteId}">
                </form>
             <!--  </form> -->
            </div>
             <jsp:include page="/WEB-INF/views/include/mypageRightSidebar.jsp"></jsp:include>
          </div>
        </div>
      </section>
            <%-- Shop Sidebar START --%>
       
        <%-- Shop Sidebar END --%>
            
        
        <!-- Hover Row Table (입찰 리스트) END --> 
       
        
      </section>

    <!-- Product Page END-->

    <!-- Product Page END-->
    <%-- Page Footer--%>
    <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
  </div>
  <%-- PANEL--%>
  <%-- END PANEL--%>
  <%-- Global Mailform Output--%>
  <div class="snackbars" id="form-output-global"></div>
  
 
      <!-- Product Page END-->

  <%-- Javascript--%>
  <script src="/resources/js/core.min.js"></script>
  <script src="/resources/js/script.js"></script>
  
  <script type="text/javascript">
  	$(function(){
  		var formObj=$("form[role='form']");
  		console.log(formObj);
  		
  		$("#removeNote").on("click", function(){
  			formObj.attr("action","/member/mypage/note/delete");
  			formObj.submit();
  		});
  		
  	});
  </script>
  <script type="text/javascript">
  function noteSend(){
	  window.open("/note/${note.sender}" ,'pbml_win','toolbar=no,location=no,directories=no, status=no,menubar=no,resizable=yes, scrollbars=yes,width=650,height=800,left=0,top=0' );  
	}
  </script>
</body>
</html>