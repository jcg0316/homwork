<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
   
    <%@ include file="/include/commonCss.jsp"%>
    <%@ include file="/include/jquery.jsp"%>
    <script>
$(function(){
	$("#noticeList tr").on('click',function(){
		var notice_act = $(this).find("td:eq(3)").text();
		$("#notice_act").val(notice_act);
			if(notice_act == "Y"){
				var conOff = confirm("게시판을 비활성화 하시겠습니까?");
					if(conOff == true){
						var notice_seq = $(this).find("td:eq(0)").text();
						$("#notice_seq").val(notice_seq);
						$("#noticeFrm").submit();	
					}
			}else{
				var conOn = confirm("게시판을 활성화 하시겠습니까?");
					if(conOn == true){
						var notice_seq = $(this).find("td:eq(0)").text();
						$("#notice_seq").val(notice_seq);
						$("#noticeFrm").submit();
					}
			}
	})
	
	$("#noticeWrite").on('click',function(){
		document.location="${pageContext.request.contextPath}/notice/noticeWrite.jsp"
	})
	
	
});
</script>
    
  </head>

  <body>
  <%@include file="/layout/header.jsp" %>
  <%@ include file="/layout/left.jsp" %>


<form id="noticeFrm" method="get" action="${pageContext.request.contextPath}/noticeAct">
	<input type="hidden" id="notice_seq" name="notice_seq">
	<input type="hidden" id="notice_act" name="notice_act">
</form>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

		<h2 class="sub-header">게시판 관리</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>게시판 번호</th>
						<th>게시판 이름</th>
						<th>생성일</th>
						<th>사용가능여부</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="noticeList">
					<c:forEach items="${noticeList}" var="notice">
						<tr>
							<td>${notice.notice_seq}</td>
							<td>${notice.notice_name}</td>
							<td>${notice.notice_reg_dt}</td>
							<td>${notice.notice_act}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<button type="button" id="noticeWrite" class="btn btn-default">게시판 추가</button>
	</div>


</body>
</html>
