<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="/resources/css/ksj-css.css">

<%--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/">
    <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--%>
</head>
<script>
	function passwordCheck() {
		var passwd = document.getElementById("passwd").value;
		var passwdCheck = document.getElementById("passwdCheck").value;

		if (passwdCheck == "") {
			document.getElementById("passwordCheckText").innerHTML = "";
		} else if (passwd != passwdCheck) {
			document.getElementById("passwordCheckText").innerHTML = "<b><font color=#DF3F32 size=4pt> 비밀번호가 맞지 않습니다. </font></b>"
			$('#pwChk').val('N');		
		} else {
			document.getElementById("passwordCheckText").innerHTML = "<b><font color=#4F84C4 size=4pt> 비밀번호가 올바르게 입력 되었습니다. </font></b>"
				$('#pwChk').val('Y');	
		}
	};
	function idCheck() {
		var memberId = $('#memberId').val();

		if ($('#memberId').val() == "") {
			alert("ID를 입력하세요");
			return;
		}
		$.ajax({
			type : 'POST',
			data : "memberId=" + memberId,
			dataType : "text",
			url : '/member/memberCheck',
			success : function(rData, textStatus, xhr) {
				var chkRst = rData;
				if (chkRst == "null") {
					alert("사용 가능합니다");
					$("#idChk").val('Y');
				} else if (chkRst != null) {
					alert("중복 되어 있습니다");
					$("#idChk").val('N');
				}
				
			},
			error : function(xhr, status, e) {
				alert(e);
			}
		});
	};
	function emailCheck() {
		var email = $('#email').val();
		console.log('emailCheck() 실행');
		if ($('#email').val() == "") {
			alert("email 입력하세요");
			return;
		}
		$.ajax({
			type : 'POST',
			data : "email=" + email,
			dataType : "text",
			url : '/member/memberEmailCheck',
			success : function(rData, textStatus, xhr) {
				var chkRst = rData;
				if (chkRst == "null") {
					alert("사용 가능합니다");
					$("#emailChk").val('Y');
				} else if (chkRst != null) {
					alert("중복 되어 있습니다");
					$("#emailChk").val('N');
				}
			},
			error : function(xhr, status, e) {
				alert(e);
			}
		});
	};
	function emailAuthenCheck() {
		var email = $('#email').val();
		
		if($("#emailChk").val() =='Y'){
			alert("메일을 확인해주세요");
			$("#layerpop").modal();
		$.ajax({
			type : 'POST',
			data : "email=" + email,
			dataType : "text",
			url : '/member/emailAuthenCheck',
			success : function() {
			}
		}
		)}
		else{
			alert("이메일 중복을 확인해주세요");
		}
	}
	function uidCheck(){
		
		var uid = $('#uid').val();
		$.ajax({
			type: 'POST',
			data : "uid=" +uid,
			dataType : "text",
			url : '/member/uidCheck',
			success:function(data){
				if(data =="1"){
					alert("일치합니다");
					$("#emailAuthenChk").val('Y');
				}
				else{
					alert("일치하지 않습니다");
					$("#emailAuthenChk").val('N');
					}
				}
			})
	}
	

	 
	 function clickz(){
		 
		 if($("#idChk").val() =='N'){
		 		alert("아이디 중복을 확인해주세요");
		 		return;
		 }
		 if($("#emailChk").val() =='N'){
			 alert("이메일 중복을 확인해주세요");
			 return;
		 }
		 if($("#pwChk").val() =='N'){
			 alert("비밀번호가 일치하지 않습니다");
			 return;
		 }
		 if($("#emailAuthenChk").val()=='N'){
			 alert("이메일 인증을 진행하세요");
			 return;
		 }
		 $('#forrm').submit();
	 }
	 

</script>


<body>
  <%-- Page preloader 시작--%>
  <jsp:include page="/WEB-INF/views/include/pageloader.jsp" />

  <%--Page 시작 --%>
  <div class="page">

   <%-- page Header START --%>
    <jsp:include page="/WEB-INF/views/include/header.jsp" />
    <%-- page Header END --%>
    
    
    <%-- Formatting forms START --%>
    <section class="section section-lg bg-white text-center">
    <div class="shell">
      <div class="range range-xs-center">
        <div class="cell-sm-10 cell-lg-8">
          <h3>Join Us</h3>
          <%-- RD Mailform--%>
          <form id="forrm" class="rd-mailform text-left"
          
            data-form-output="form-output-global"
            data-form-type="contact" method="post"
            action="/member/register">
            <div class="range range-20">

              <div class="cell-sm-8">
                <div class="form-wrap form-wrap-validation">
                  <label class="form-label-outside" for="forms-3-name">ID</label>
                  <input class="form-input" id="memberId" type="text"
                    name="memberId" placeholder="ID">
                </div>
              </div>
              <div class="cell-sm-3">
                <div class="form-wrap-validation">
                	<button class="ksj-btn btn btn-warning button-secondary" name="memberIdCheck" onclick="idCheck()">check ID</button>
                    <input type="hidden" id="idChk" value='N' />
                </div>
              </div>


              <div class="cell-sm-6">
                <div class="form-wrap form-wrap-validation">
                  <label class="form-label-outside" for="forms-3-name">Password</label>
                  <input class="form-input" id="passwd" type="password"
                    name="passwd" value="" data-constraints="@Required"
                    placeholder="Password">
                </div>
              </div>
              <div class="cell-sm-6">
                <div class="form-wrap form-wrap-validation">
                  <label class="form-label-outside" for="forms-3-name">Password
                    Check</label> <input class="form-input" id="passwdCheck"
                    type="password" name="passwdCheck" value=""
                    data-constraints="@Required"
                    onkeyup="passwordCheck()"
                    placeholder="Password Check">
                    <input type="hidden" id="pwChk" value='N' />
                </div>
              </div>
              <div class="cell-sm-5">
                <div class="form-wrap form-wrap-validation">
                  <span id="passwordCheckText" width=40></span>
                </div>
              </div>

              <div class="cell-sm-12">
                <div class="form-wrap form-wrap-validation">
                  <label class="form-label-outside"
                    for="forms-3-last-name">Name</label> <input
                    class="form-input" id="forms-3-last-name"
                    type="text" name="name" data-constraints="@Required"
                    placeholder="Name">
                </div>
              </div>

              <div class="cell-sm-7">
                <label class="form-label-outside">Address</label>
                <div class="form-wrap form-wrap-inline">
                  <input class="form-input" id="sample6_postcode"
                    type="text" name="zipcode" placeholder="우편번호">
                </div>
              </div>
              <div class="cell-sm-5">
                <div class="form-wrap-validation">
                <button class="ksj-btn btn btn-warning button-secondary" name="memberIdCheck" onclick="sample6_execDaumPostcode()">POSTAL CODE</button>
	                  <!-- <button type="button"
	                    class="button button-secondary jjh-postCodeSearchBtn"
	                    onclick="sample6_execDaumPostcode()">POSTAL CODE</button> -->
                </div>
              </div>
              <div class="cell-xs-12">
                <div class="form-wrap form-wrap-inline">
                  <input class="form-input" id="sample6_address"
                    type="text" name="baseaddress" placeholder="기본주소">
                </div>
                <div class="form-wrap form-wrap-inline">
                  <input class="form-input" id="sample6_address2"
                    type="text" name="detailaddress" placeholder="상세주소">
                </div>
              </div>


              <div class="cell-sm-8">
                <div class="form-wrap form-wrap-validation">
                  <label class="form-label-outside" for="forms-3-name">Email</label>
                  <input class="form-input" id="email" type="text" name="email" data-constraints="@Required"
                    placeholder="EMAIL">
                </div>
              </div>
              <div class="cell-sm-2">	
                <div class="form-wrap form-wrap-validation">
			    	<button class="ksj-btn btn btn-warning button-secondary" name="emailCheck" onclick="emailCheck()">check Email</button>
                  	<input type="hidden" id="emailChk" value='N' />
                </div>
              </div>
               <div class="cell-sm-2">
                <div class="form-wrap form-wrap-validation">
                	<button class="btn btn-warning button-secondary ksj-btn" name="authentification" onclick="emailAuthenCheck()">authentification</button>
                  <input type="hidden" id="emailAuthenChk" value='N' />
                </div>
              </div>
          

              <div class="cell-sm-10">
                <div class="form-wrap form-wrap-validation">
                  <label class="form-label-outside" for="forms-3-name">Phone</label>
                  <input class="form-input" id="forms-3-name"
                    		type="text" name="phoneNumber" placeholder="-없이 숫자만 입력해주세요">
                </div>
              </div>

              <div class="cell-sm-12">
                <label class="form-label-outside" for="forms-3-name">Account</label>
                <div class="form-wrap form-wrap-validation">
                  <div class="col-sm-3">
                    <!-- Dropdown list-->
                    <!-- Select 2-->
                    <select class="col-sm-2 form-control select-filter" data-placeholder="All" 
                    		data-minimum-results-for-search="Infinity" data-constraints="@Selected" name="bank">
                      <option label="계좌종류"> </option>
                      <option value="1">국민</option>
                      <option value="2">농협</option>
                      <option value="3">신한</option>
                      <option value="4">신협</option>
                      <option value="5">우리</option>
                      <option value="6">하나</option>
                      <option value="7">기업</option>
                    </select>
                  </div>
                  <div class="col-sm-9">
                    <input class="cell-sm-8 form-input" id="forms-3-name" type="text" name="accountNumber"
                      data-constraints="@Required" placeholder="-없이 숫자만 입력해주세요">
                  </div>
                </div>
              </div>

              <div class="cell-sm-3" >
                <input id="clickzz" type="button" name="memberIdCheck"
                    class="button button-secondary jjh-postCodeSearchBtn"
                    onclick="clickz()" value="SUBMIT"></input> 
                 <!--  <button id="clickzz" type="button" class="click" onclick="clickz()" >SUBMIT</button> -->
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
    <!--모달창 start  -->
    <div class="modal fade" id="layerpop">
      <div class="modal-dialog">
        <div class="modal-content">
          <!-- header -->
          <div class="modal-header">
            <!-- 닫기(x) 버튼 -->
            <button type="button" class="close" data-dismiss="modal">×</button>
            <!-- header title -->
            <h4 class="modal-title">uid를 입력해주세요</h4>
          </div>
          <!-- body -->
          <div class="modal-body">
            <input class="cell-sm-8 form-input" id="uid" type="text"
              name="accountNumber"
              placeholder="uid" >Body
          </div>
           <div class="modal-body">
            <button class="cell-sm-8 form-input" id="uid" type="text"
              name="accountNumber"  placeholder="uid" onclick="uidCheck()" >제출</button>
          </div>
          <!-- Footer -->
          <div class="modal-footer">
            Footer
            <button type="button" class="btn btn-default"
              data-dismiss="modal">닫기</button>
          </div>
        </div>
      </div>
    </div>

    <!--모달창 end  --> </section>
    <%-- Formatting forms END --%>

    <%-- Page Footer--%>
    <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>

  </div>
  <%-- PANEL--%>
  <%-- END PANEL--%>
  <%-- Global Mailform Output--%>
  <!-- <div class="snackbars" id="form-output-global"></div>
 -->
  <%-- Javascript--%>
  <script src="/resources/js/core.min.js"></script>
  <script src="/resources/js/script.js"></script>

  <%--다음API 주소 적용 --%>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
  <script type="text/javascript">
			function sample6_execDaumPostcode() {
				new daum.Postcode(
						{
							oncomplete : function(data) {
								// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

								// 각 주소의 노출 규칙에 따라 주소를 조합한다.
								// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
								var fullAddr = ''; // 최종 주소 변수
								var extraAddr = ''; // 조합형 주소 변수

								// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
								if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
									fullAddr = data.roadAddress;

								} else { // 사용자가 지번 주소를 선택했을 경우(J)
									fullAddr = data.jibunAddress;
								}

								// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
								if (data.userSelectedType === 'R') {
									//법정동명이 있을 경우 추가한다.
									if (data.bname !== '') {
										extraAddr += data.bname;
									}
									// 건물명이 있을 경우 추가한다.
									if (data.buildingName !== '') {
										extraAddr += (extraAddr !== '' ? ', '
												+ data.buildingName
												: data.buildingName);
									}
									// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
									fullAddr += (extraAddr !== '' ? ' ('
											+ extraAddr + ')' : '');
								}

								// 우편번호와 주소 정보를 해당 필드에 넣는다.
								document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
								document.getElementById('sample6_address').value = fullAddr;

								// 커서를 상세주소 필드로 이동한다.
								document.getElementById('sample6_address2')
										.focus();
							}
						}).open();
			}
		</script>
</body>
</html>