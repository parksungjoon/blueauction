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
<link rel="stylesheet" href="/resources/css/kbh-css.css">

<%--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/">
    <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--%>

<script src="/resources/js/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="/resources/css/hideSearch.css">
<style type="text/css">
.pagination-custom > li {
    font-family: "Oswald", Helvetica, Arial, sans-serif;
    font-size: 16px;
    letter-spacing: 0.12em;
    min-width: 50px;
    color: #fff;
    background: #f2dede;
    vertical-align: middle;
}
.pagination-custom > li.active {
    color: #fff;
    background: #ff3366;
}

.pagination-custom > li > a:hover {
    color: #fff;
    background: #ff3366;
}

</style>

</head>

<body>
  <%-- Page preloader--%>
  <%-- <jsp:include page="/WEB-INF/views/include/pageloader.jsp" />
 --%>
  <%-- Page--%>
  <div class="page">

    <%-- page Header START --%>
    <jsp:include page="/WEB-INF/views/include/header.jsp" />
    <%-- page Header END --%>

    <!-- Breadcrumbs START -->
    <section
      class="breadcrumbs-custom breadcrumbs-custom-svg bg-gradient breadcrumbs-background-01">
    <div class="shell">
      <p class="breadcrumbs-custom-subtitle">Mypage</p>
      <p class="heading-1 breadcrumbs-custom-title">Note List</p>
      <ul class="breadcrumbs-custom-path">
        <li><a href="/">Home</a></li>
        <li><a href="/member/mypage">MyPage</a></li>
        <li class="active"><a href="/member/mypage/note/list">Note</a></li>
      </ul>
    </div>
    </section>
    <!-- Breadcrumbs END -->


  <!-- Product Page START-->
      <section class="section section-lg bg-white">
       
        
         <!-- Hover Row Table (입찰 리스트) START -->
        <div class="shell">
          <div class="range range-xs-center">
            <div class="cell-sm-10 cell-lg-10">
             <!--  <h3>쪽지함 </h3> -->
              <div class="form-wrap box-width-2" style="display: -webkit-inline-box;">
               <h3>쪽지함 </h3>
                <!-- Select 2-->
                <div style="margin-top: -4px; height: 5px;">
                <select class="form-control select-filter" data-placeholder="All" data-minimum-results-for-search="Infinity" data-constraints="@Selected" id="searchType" name="searchType">
                  <option value="R" <c:out value="${cri.keyword eq 'R'?'selected':''}"/>>받은편지함</option>
                  <option value="S" <c:out value="${cri.keyword eq 'S'?'selected':''}"/>>보낸편지함</option>
                </select>
                </div>
              </div>
              <div class="table-novi table-custom-responsive" style="margin-top: 19px;">
                <table  class="table table-striped table-hover">
                  <thead>
                    <tr class="danger">
                      <th>#</th>
                      <th>제목</th>
                      <c:if test="${cri.keyword=='R' || null}">
                      <th>보낸이</th>
                      </c:if>
                      <c:if test="${cri.keyword=='S'}">
                      <th>받는이</th>
                      </c:if>
                      <th>등록일</th>
                      <th>읽은시간</th>
                      
                      <!-- <th>판매 상태</th> -->
                    </tr>
                  </thead>
                  <tbody id="bidListTr">
                  <c:forEach var="note" items="${list}" varStatus="status">
                    <tr>
                      <td>${pageMaker.getTotalCount()-((pageMaker.cri.getPage()-1)*pageMaker.cri.getPerPageNum())-status.count}</td>
                      <td><a href="/member/mypage/note/read?noteId=${note.noteId}">${note.subject}</a></td>
                      <c:if test="${cri.keyword=='R' || null}">
                      <td>${note.sender}</td>
                      </c:if>
                      <c:if test="${cri.keyword=='S'}">
                      <td>${note.receiver}</td>
                      </c:if>
                      <td>${note.regdate}</td>
                      <td>${note.readdate}</td>
                      
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
              <div style="text-align: center;">
           <ul class="kbh">

          <c:if test="${pageMaker.prev}">
            <li class="prev"><a
              href="${pageMaker.makerSearch(pageMaker.startPage-1)}">이전목록</a></li>
          </c:if>

          <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
            <li <c:out value="${pageMaker.cri.page==idx?' class=active':''}"/>>
            <a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
            </li>
          </c:forEach>

          <c:if test="${pageMaker.next && pageMaker.endPage>0}">
            <li><a href="/member/mypage/note/list${pageMaker.makeSearch(pageMaker.endPage+1)}">다음목록</a></li>
          </c:if>
        </ul>
        </div>
            </div>
            <%-- Shop Sidebar START --%>
        <jsp:include page="/WEB-INF/views/include/mypageRightSidebar.jsp"></jsp:include>
        <%-- Shop Sidebar END --%>
            
          </div>
        </div>
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
  		$('#searchType').on("change", function(event){
  			self.location="/member/mypage/note/list"
  						+'${pageMaker.makeQuery(1)}'
  						+"&keyword="
  						+$("select option:selected").val();
  		});

  	});
  </script>
</body>
</html>