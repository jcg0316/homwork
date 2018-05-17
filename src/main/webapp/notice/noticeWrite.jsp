<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<!-- <link rel="icon" href="../../favicon.ico"> -->

<title>Dashboard Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/dashboard.css"
	rel="stylesheet">

<%@ include file="/include/jquery.jsp" %>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
$(function(){
	
	//화면 로딩시 회원 아이디 입력칸에 focus
	$("#notice_name").focus();
	
	//userReg 사용자 등록 버튼
	$("#noticewrite").click(function(){
		//validation
		if($("#notice_name").val().trim() == ""){
			alert("게시판 명이 입력 되지 않았습니다.");
			$("#notice_name").focus();
			return false;
		}
		
		//submit
		$("#noticewriteFrm").submit();
	});
});	
</script>    
</head>

<body>
	<%@ include file="/layout/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<%@ include file="/layout/left.jsp"%>

			<!-- <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="noticewriteFrm" action="${pageContext.request.contextPath}/noticeWrite" method="post" class="form-horizontal" role="form">
					  
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">게시판 명</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="notice_name" name="notice_name" placeholder="카테고리 명">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="noticewrite" type="button" class="btn btn-default">작성</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>	
</body>
</html>
