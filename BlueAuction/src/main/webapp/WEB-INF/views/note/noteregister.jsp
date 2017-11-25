<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="wide wow-animation" lang="en">
<head>
<%-- Site Title--%>
<title>Home</title>
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<meta name="format-detection" content="telephone=no">
<meta name="viewport"
  content="width=device-width, height=device-height, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="utf-8">
<link rel="icon" href="/resources/images/favicon.ico"
  type="image/x-icon">
<%-- Stylesheets --%>
<link rel="stylesheet" type="text/css"
  href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
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
</head>

<body>
  <%-- Page preloader 시작--%>
  <jsp:include page="/WEB-INF/views/include/pageloader.jsp" />

  <%--Page 시작 --%>
  <div class="page">

    <%-- Page Header 시작--%>
    <%-- <jsp:include page="/WEB-INF/views/include/header.jsp" />  --%> 
    <%-- Page Header 종료--%>


    <%-- Formatting forms START --%>
    <!-- Contact information-->
      <section class="section section-lg bg-white">
        <div class="shell shell-bigger">
          <div class="range range-ten range-50 range-sm-center range-lg-justify">
            <div class="cell-sm-9 cell-md-6">
              <h3>쪽지쓰기</h3>
              <hr class="divider divider-left divider-default">
              <!-- RD Mailform-->
              <!-- <form class="rd-mailform" data-form-output="form-output-global" data-form-type="contact" method="post"> -->
                <div class="range range-20">
                  <div class="cell-sm-6">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="form-1-name">보내는 사람</label>
                      <input class="form-input" id="sender" type="text" name="sender" readonly value="${login.memberId}" data-constraints="@Required"/>
                    </div>
                  </div>
                  <div class="cell-sm-6">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="form-1-last-name">받는 사람</label>
                      <input class="form-input" id="receiver" type="text" name="receiver" readonly value="${receiver}" data-constraints="@Required"/>
                    </div>
                  </div>
                  <div class="cell-sm-12">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="form-1-phone">제목</label>
                      <input class="form-input" id="subject" type="text" name="subject" data-constraints="@Required"/>
                    </div>
                  </div>
                  <div class="cell-xs-12">
                    <div class="form-wrap form-wrap-validation">
                      <label class="form-label-outside" for="form-1-message">내용</label>
                      <textarea class="form-input" id="content" name="content" data-constraints="@Required"></textarea>
                    </div>
                  </div>
                  <div class="cell-xs-12 offset-custom-1">
                    <div class="form-button">
                      <button class="button button-secondary" id="sendNote">send message</button>
                    </div>
                  </div>
                </div>
             <!--  </form> -->
            </div>
          </div>
        </div>
      </section>
    <%-- Formatting forms END --%>

    <%-- Page Footer--%>
    <%-- <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include> --%>

  </div>
  <%-- PANEL--%>
  <%-- END PANEL--%>
  <%-- Global Mailform Output--%>
  <!-- <div class="snackbars" id="form-output-global"></div> -->

  <%-- Javascript--%>
  <script src="/resources/js/core.min.js"></script>
  <script src="/resources/js/script.js"></script>
  <script type="text/javascript">
  	$(function(){
  		$("#sendNote").on("click",function(){
  		     var senderObj = $("#sender");
  		     var receiverObj = $("#receiver");
  		     var subjectObj=$('#subject');
  		     var contentObj=$('#content');
  		     var sender = senderObj.val();
  		     var receiver = receiverObj.val();
  		     var subject=subjectObj.val();
  		     var content=contentObj.val();
  		    
  		      
  		      $.ajax({
  		        type:'post',
  		        url:'/note/',
  		        headers: { 
  		              "Content-Type": "application/json",
  		              "X-HTTP-Method-Override": "POST" },
  		        dataType:'text',
  		        data: JSON.stringify({sender:sender, receiver:receiver, subject:subject, content:content}),
  		        success:function(result){
  		          console.log("result: " + result);
  		          if(result == 'SUCCESS'){
  		            alert("전송 되었습니다.");
  		          	subjectObj.val("");
  		        	contentObj.val("");
  		          }
  		      }});
  		  });
  	});
  
  </script>
</body>
</html>