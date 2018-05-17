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
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
    
    <%@ include file="/include/jquery.jsp" %>
<script>
$(function(){
	// 회원 정보 삭제 버튼 클릭 이벤트 (삭제 발생 : post)
	$("#delete").click(function(){
		$("#frm").attr("action","${pageContext.request.contextPath}/delete");
		$("#frm").attr("method","post");
		$("#frm").submit();
	});
	
	//method = get : 조회할때, post : 서버상의 변경이 일어날때
	
	// 회원 정보 수정 버튼 클릭 이벤트 (회원 수정 화면으로 이동 : get)
	$("#modify").click(function(){
		$("#frm").attr("action","${pageContext.request.contextPath}/boardModify");
		$("#frm").attr("method","get");
		$("#frm").submit();
	});
});
</script>
</head>

<body>
	<%@ include file="/layout/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<%@ include file="/layout/left.jsp"%>
		
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
				<form id="frm" class="form-horizontal" role="form" method="post">
					<input type="hidden" name="board_seq" value="${bvo.board_seq }">
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">글번호</label>
						<div class="col-sm-10">
						<label class="control-label">${bvo.board_seq}</label>
							
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">작성자</label>
						<div class="col-sm-10">
							<label class="control-label">${bvo.board_mem_id }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${bvo.board_title}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<label class="control-label">${bvo.board_content }</label>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" id="modify" class="btn btn-default">수정</button>
							<button type="button" id="delete" class="btn btn-default">삭제</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
