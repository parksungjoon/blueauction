<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Page Header-->
<link rel="stylesheet" href="/resources/css/jjh-style.css">
<script type="text/javascript">

</script>


<header class="section page-header">
	<!-- RD Navbar-->
	<div class="rd-navbar-wrap rd-navbar-shop-header">
		<nav class="rd-navbar" data-layout="rd-navbar-fixed"
			data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fullwidth"
			data-md-device-layout="rd-navbar-fixed"
			data-lg-layout="rd-navbar-static"
			data-lg-device-layout="rd-navbar-static"
			data-md-stick-up-offset="100px" data-lg-stick-up-offset="150px"
			data-stick-up="true" data-sm-stick-up="true" data-md-stick-up="true"
			data-lg-stick-up="true">
			
			<div class="rd-navbar-top-panel">
				<div class="rd-navbar-nav-wrap">
					<!-- RD Navbar Nav-->
                  <ul class="jjh-headerNav">
                    <li class="jjh-headerLi">
    					<ul class="rd-navbar-nav">
    						<li class="active"><a href="/">Home</a></li>
    						<li><a href="/product/used">중고상품</a></li>
    						<li><a href="/product/auction/1/0">경매상품</a> <!-- RD Navbar Dropdown-->
    							<ul class="rd-navbar-dropdown">
    								<li><a href="/product/auction/1/0">시작전 경매</a></li>
    								<li><a href="/product/auction/2/0">진행중 경매</a></li>
    								<li><a href="/product/auction/3/0">마감된 경매</a></li>
    							</ul></li>
    					</ul>
                    </li>
                    <li class="jjh-userHeader">
                      <ul class="jjh-userUl">
                        <c:if test="${not empty login}">
                         <!-- <li><form action="/logout" class="rd-mailform" method="get">  -->
                          <li class="jjh-userLi"><a href="/member/mypage"> ${login.memberId}</a>님</li>
                          <li class="jjh-userLi"><a href="/member/logout">Logout</a></li>
                          <li class="jjh-userLi"><span class="icon icon-md-smaller ksj-icon-primary mdi mdi-email"><span class="badge badge-primary" id="counter">4</span>
                          </span></li>
                        </c:if>
                        
                        <c:if test="${empty login}">
                        <li class="jjh-userLi"><a href="/member/login">Login</a></li>
                        <li class="jjh-userLi"><a href="/member/register">Join Us</a></li>
                        </c:if>
                      </ul>
                    <li>
                  </ul>
				</div>
			</div>
			<div class="rd-navbar-inner">
				<!-- RD Navbar Panel-->
				<div class="rd-navbar-panel">
					<!-- RD Navbar Toggle-->
					<button class="rd-navbar-toggle"
						data-rd-navbar-toggle=".rd-navbar-nav-wrap">
						<span></span>
					</button>
					<!-- RD Navbar Brand-->
					<div class="rd-navbar-brand">
						<a class="brand-name" href="index.html"> <img
							class="logo-default"
							src="/resources/images/logo-default-173x55.png" alt="" width="173"
							height="55" /> <img class="logo-inverse"
							src="/resources/images/logo-inverse-173x55.png" alt="" width="173"
							height="55" /></a>
					</div>
				</div>
				<div class="rd-navbar-aside-center">
					<!-- RD Navbar Search-->
					<div class="rd-navbar-search">
						<a class="rd-navbar-search-toggle"
							data-rd-navbar-toggle=".rd-navbar-search" href="#"><span></span></a>
<!-- 						<form class="rd-search" action="#" data-search-live="rd-search-results-live" method="POST"> -->
							<div class="rd-mailform-inline rd-mailform-sm rd-mailform-inline-modern search-box">
								<div class="rd-mailform-inline-inner">
									<div class="form-wrap form-wrap-icon mdi-magnify">
										<label class="form-label form-label"
											for="rd-navbar-search-form-input">Search...</label> <input
											class="rd-navbar-search-form-input form-input"
											id="rd-navbar-search-form-input" type="text" >
										<div class="rd-search-results-live"></div>
									</div>
									<button class="rd-search-form-submit rd-search-form-submit-icon mdi mdi-magnify"></button>
									<button class="rd-search-form-submit button form-button button-sm button-secondary" >search</button>
								</div>
							</div>
					<!-- 	</form> -->
					</div>
				</div>
				<div class="rd-navbar-aside-right">
					<div class="rd-navbar-shop">
						<!-- <a class="rd-navbar-shop-icon mdi mdi-cart"
							href="shopping-cart.html"><span>2</span></a> -->
              <%-- <iframe src="http://192.168.78:7778/?memberId=${login.memberId}" frameborder="0" style="visibility:hidden;"></iframe> --%>
					</div>
				</div>
			</div>
		</nav>
	</div>
</header>
<div id="favoriteModal" class="modal modal-primary fade" role="dialog">
    <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">10분전 알림</h4>
      </div>
      <div class="modal-body" data-rno>
        즐겨찾기하신 <span id='favorite'></span>번 상품에 대한 경매가 10분후 시작됩니다.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger">확인</button>
      </div>
    </div>
  </div>
</div>
<script>
//메시지 수신 받는 eventListener 등록
window.addEventListener( 'message', receiveMsgFromChild );
 
// 자식으로부터 메시지 수신
function receiveMsgFromChild( e ) {
    console.log( '자식으로부터 받은 메시지 ', e.data );
    if(e.data=='openModal'){
      openModal();
    }else if(e.data.maxprice!=null || e.data.maxprice!=undefined){
      console.log('자식으로부터 받은 최대값'+e.data.maxprice)
      $('#maxPrice').html(e.data.maxprice);
    }else if(e.data.title=='favorite'){
      console.log('자식으로부터 받은 즐겨찾기 리스트'+e.data.list);
      $('#favorite').html(e.data.list);
      $('#favoriteModal').modal('show');
    }else if(e.data.title=='noteCount'){
       $('#counter').html(e.data.noteCount);
    }
}

function openModal(){
  $('#winnerModal').modal('show');
}
</script>