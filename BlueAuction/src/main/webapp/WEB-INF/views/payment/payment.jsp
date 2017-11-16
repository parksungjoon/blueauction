<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  </head>
  
  <body>
    <%-- Page preloader--%>
    <jsp:include page="/WEB-INF/views/include/pageloader.jsp"/>
    
    <%-- Page--%>
    <div class="page">
    
       <%-- page Header START --%>
      <jsp:include page="/WEB-INF/views/include/header.jsp" />
      <%-- page Header END --%>
      
      
      <%-- 본문 시작--%>
      <%-- small header 시작--%>
      <section class="breadcrumbs-custom breadcrumbs-custom-svg bg-gradient breadcrumbs-background-01">
        <div class="shell">
          <p class="breadcrumbs-custom-subtitle">Shop </p>
          <p class="heading-1 breadcrumbs-custom-title">Checkout</p>
          <ul class="breadcrumbs-custom-path">
            <li><a href="index.html">Home</a></li>
            <li><a href="#">Shop</a></li>
            <li class="active">Checkout</li>
          </ul>
        </div>
      </section>
      <%-- small header 종료--%>

      <%-- Product Page--%>
      <section class="section section-lg bg-white">
        <div class="shell shell-wide">
          <div class="range range-50 range-md-center">
            <div class="cell-md-11 cell-lg-10 cell-xl-6">
              <div class="tabs-custom tabs-horizontal tabs-line text-center" id="tabs-1">
                <%-- 메뉴 탭 시작--%>
                <ul class="nav nav-tabs nav-tabs-checkout">
                  <li class="active"><a href="#tabs-1-1" data-toggle="tab">Payment Info</a></li>
                  <!-- <li><a href="#tabs-1-2" data-toggle="tab">Payment Method</a></li> -->
                </ul>
                <%-- 메뉴 탭 종료--%>
                
                <%-- 내용 시작--%>
                <div class="tab-content">              
                  <div class="tab-pane fade in active" id="tabs-1-1">
                  
                  <%--정보 입력 form 시작 --%>
                    <form class="rd-mailform text-left" data-form-output="form-output-global" data-form-type="contact" method="post" action="/payment">
                                         <div class="table-checkout text-left jji-select">
                      <div class="table-novi table-custom-responsive">
                        <table class="table-custom">
                          <tbody>
                            <tr>
                              <td><strong class="jjh-proInfo">Product</strong></td>
                              <td>따듯한 롱패딩<%--주문하고자 하는 상품 이름 --%></td>
                            </tr>
                            <tr>
                              <td><strong class="jjh-proInfo">Price</strong></td>
                              <td>$58.00</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                      <div class="range range-20">
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                          <%--아이디는 로그인 세션값 받아와서 자동 입력되도록... readonly적용함 --%>
                            <label class="form-label-outside" for="forms-3-name">Id</label>
                            <input class="form-input" id="forms-3-name" type="text" name="memberid" data-constraints="@Required" readonly>
                          </div>
                        </div>
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-last-name">Name</label>
                            <input class="form-input" id="forms-3-last-name" type="text" name="name" data-constraints="@Required">
                          </div>
                        </div>
                        
                          <div class="cell-sm-6">
                           <label class="form-label-outside">Address</label>
                            <div class="form-wrap form-wrap-inline">
                                <input class="form-input" id="sample6_postcode" type="text" name="street-address" placeholder="우편번호">
                            </div>
                          </div>
                          <div class="cell-sm-6">
                            <div class="form-wrap-validation">
                              <button type="button" class="button button-secondary jjh-postCodeSearchBtn"  onclick="sample6_execDaumPostcode()">Postal code search</button>
                            </div>
                          </div>
                          <div class="cell-xs-12">
                          <div class="form-wrap form-wrap-inline">
                            <input class="form-input" id="sample6_address" type="text" name="basic_address" placeholder="기본주소">
                          </div>
                          <div class="form-wrap form-wrap-inline">
                            <input class="form-input" id="sample6_address2" type="text" name="detail_address" placeholder="상세주소">
                          </div>
                        </div>
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="form-1-email">E-mail</label>
                            <input class="form-input" id="form-1-email" type="email" name="email" data-constraints="@Email @Required">
                          </div>
                        </div>
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="form-1-phone">Phone</label>
                            <input class="form-input" id="form-1-phone" type="text" name="phone" data-constraints="@Numeric @Required">
                          </div>
                        </div>
                      </div>
                    </form>
                    <%--정보 입력 form 종료 --%>
                    
                    <div class="cell-md-12 offset-custom-1">
                          <div class="form-button text-sm-right">
                            <button class="button button-secondary" type="submit">checkout</button>
                          </div>
                        </div>
                  </div>

                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <%--본문 종료--%>
      
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
    
    <%--다음API 주소 적용 --%>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script type="text/javascript" >
        function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
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
                    if(data.userSelectedType === 'R'){
                        //법정동명이 있을 경우 추가한다.
                        if(data.bname !== ''){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있을 경우 추가한다.
                        if(data.buildingName !== ''){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                        fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                    }
    
                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                    document.getElementById('sample6_address').value = fullAddr;
    
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById('sample6_address2').focus();
                }
            }).open();
        }
    </script>
    
    
  </body>
</html>