<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="icon" href="/resources/images/favicon.ico" type="image/x-icon">

<%-- Stylesheets --%>
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet" href="/resources/css/mdi.css">
<link rel="stylesheet" href="/resources/css/fl-bigmug-line.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/">
    <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--%>
<link rel="stylesheet" href="/resources/css/hideSearch.css">

</head>

<body>
<script type="text/javascript">

$(document).ready(function(){
	var a=${member.bank};
	if(a="1"){
		$('#input-bank').val('국민');
			}
	if(a="2"){
		$('#input-bank').val('농협');
			}
	if(a="3"){
		$('#input-bank').val('신한');
			}
	if(a="4"){
		$('#input-bank').val('신협');
			}
	if(a="5"){
		$('#input-bank').val('우리');
			}
	if(a="6"){
		$('#input-bank').val('하나');
			}
	if(a="7"){
		$('#input-bank').val('기업');
			}
	
}); 
</script>

	<%-- Page preloader--%>
	<jsp:include page="/WEB-INF/views/include/pageloader.jsp" />

	<%-- Page--%>
	<div class="page">

		<%-- page Header START --%>
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<%-- page Header END --%>

		<%-- Breadcrumbs--%>
		<section class="breadcrumbs-custom breadcrumbs-custom-svg bg-gradient breadcrumbs-background-01">
		<div class="shell">
			<p class="breadcrumbs-custom-subtitle"></p>
			<p class="heading-1 breadcrumbs-custom-title">mypage</p>
			<ul class="breadcrumbs-custom-path">
				<li><a href="/">Home</a></li>
				<li><a href="#">mypage</a></li>
			</ul>
		</div>
		</section>

		<%-- product catalog--%>
		<section class="section section-lg bg-gray-lighter text-center">
		
		<div class="shell shell-wide">
		<h3>회원 정보</h3>	
			<div class="divider divider-default"></div>	
			<div class="range range-sm range-shop">

				<div class="cell-lg-10">
					<div class="range range-70 text-left">
						<div class="tab-content">
						
							<div class="tab-pane fade in active" id="tabs-1-1">
								<form class="rd-mailform text-left"
									data-form-output="form-output-global" data-form-type="contact"
									method="post" action="bat/rd-mailform.php">
									<div class="range range-20">
										<div class="cell-sm-6">
											<div class="form-wrap form-wrap-validation">
												<label class="form-label-outside" for="forms-3-name">name
													</label> <input class="form-input" id="forms-3-name" value=${member.name}
													type="text" name="name" data-constraints="@Required" disabled>
											</div>
										</div>
										<div class="cell-sm-6">
											<div class="form-wrap form-wrap-validation">
												<label class="form-label-outside" for="forms-3-last-name">email
													</label> <input class="form-input" id="forms-3-last-name" value=${member.email}
													type="text" name="last-name" data-constraints="@Required" disabled>
											</div>
										</div>
										<div class="cell-sm-6">
											<div class="form-wrap form-wrap-validation">
												<label class="form-label-outside" for="forms-3-company">zipcode</label>
												<input class="form-input" id="forms-3-company" type="text" value=${member.zipcode}
													name="company" disabled>
											</div>
										</div>
										<div class="cell-sm-6">
											<div class="form-wrap form-wrap-validation">
												<label class="form-label-outside" for="forms-3-city">baseaddress</label>
												<input class="form-input" id="forms-3-city" type="text" value=${member.baseaddress}
													name="city" disabled >
											</div>
										</div>
										<div class="cell-sm-6">
											<div class="form-wrap form-wrap-validation">
												<label class="form-label-outside" for="form-1-email">detailadress</label>
												<input class="form-input" id="form-1-email" type="email" value=${member.detailaddress}
													name="email" data-constraints="@Email @Required" disabled>
											</div>
										</div>

										<div class="cell-sm-6">
											<div class="form-wrap form-wrap-validation">
												<label class="form-label-outside" for="form-1-phone">accountNumber</label>
												<input class="form-input" id="form-1-phone" type="text" value=${member.accountNumber}
													name="phone" data-constraints="@Numeric @Required" disabled>
											</div>
										</div>
										<!-- <div class="cell-xs-12"> -->
										<div class="cell-sm-6">
											<div class="form-wrap form-wrap-validation">
												<label class="form-label-outside"
													for="input-bank">bank</label>
                                           <input class="form-input" id="input-bank" type="text" value="기업" name="street-address" disabled>
											</div>
										</div>
										<div class="cell-sm-6">
											<div class="form-wrap form-wrap-validation">
												<label class="form-label-outside"
													for="forms-3-street-address">phoneNumber</label> <input
													class="form-input" id="forms-3-street-address" type="text" value=${member.phoneNumber}
													name="street-address" disabled>
											</div>
										</div>
										
									</div>
								</form>
							</div>

						</div>
					</div>

				</div>

				<%-- Shop Sidebar START --%>
				<jsp:include page="/WEB-INF/views/include/mypageRightSidebar.jsp"></jsp:include>
				<%-- Shop Sidebar END --%>

			</div>
		</div>
		</section>

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

</body>
</html>