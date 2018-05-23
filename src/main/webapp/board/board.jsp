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
	// 게시글 정보 삭제 버튼 클릭 이벤트 (삭제 발생 : post)
	$("#delete").click(function(){
			if(confirm("정말 삭제 하시겠습니까?")){
				$("#frm").attr("action","${pageContext.request.contextPath}/boardDelete");
				$("#frm").attr("method","post");
				$("#frm").submit();		
			}
	});
	
	//method = get : 조회할때, post : 서버상의 변경이 일어날때
	
	// 게시글 정보 수정 버튼 클릭 이벤트 (게시글 수정 화면으로 이동 : get)
	$("#modify").click(function(){
		$("#frm").attr("action","${pageContext.request.contextPath}/boardModify");
		$("#frm").attr("method","get");
		$("#frm").submit();
	});
	
	// 답글 
	$("#reWrite").click(function(){
		$("#frm").attr("action","${pageContext.request.contextPath}/boardReWrite");
		$("#frm").attr("method","get");
		$("#frm").submit();
	});
	
	
	$('#replyWriteTA').keyup(function (e){
	    var content = $(this).val();
	    if (content.length > 500){
	        alert("최대 500자까지 입력 가능합니다.");
	        $(this).val(content.substring(0, 500));
	    }
	});

	// 댓글 쓰기
	$("#replyWrite").click(function(){
		
		$("#frm").attr("action","${pageContext.request.contextPath}/replyWrite");
		$("#frm").attr("method","post");
		$("#frm").submit();
		
	});
	
	// 댓글 삭제
	$(".delbtn").click(function(){
		var reply_seq = $(this).attr('idx');
		$('#reply_seq').val(reply_seq);
		$("#frm").attr("action","${pageContext.request.contextPath}/replyDelete");
		$("#frm").attr("method","post");
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
			
				<form id="frm" class="form-horizontal" role="form">
					<input type="hidden" name="board_seq" value="${bvo.board_seq }">
					<input type="hidden" name="group_seq" value="${bvo.group_seq }">
					<input type="hidden" name="category_seq" value="${bvo.category_seq }">
					<input type="hidden" name="reply_seq" id="reply_seq">
					
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
						<c:if test="${bvo.board_mem_id == mem_id}">
							<button type="button" id="modify" class="btn btn-default">수정</button>
							<button type="button" id="delete" class="btn btn-default">삭제</button>					
						</c:if>
							<input class="btn btn-default" id="reWrite" type="button" value="답글">
							<br><br>
						<div class="writeBtn" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style=" width: 793px; height: 60px; ">
							<textarea id="replyWriteTA" name="replyWrite" rows="2" cols="101" style="height: 46px;vertical-align: middle;"></textarea> <input id="replyWrite" class="reg_id"class="btn btn-default"  type="button" value="등록" style="text-align: right; height: 46px;vertical-align: middle;" >
					   	</div>
							<div class="panel panel-default" style="width: 730px;">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>작성자</th>
											<th>내용</th>
											<th>작성시간</th>
											<th></th>
										</tr>
									</thead>
									<tbody id="reqly">
										<c:forEach items="${replyList}" var="reply">
										<tr>
											<td>${reply.reply_mem_id}</td>
											<td><p>${reply.reply_del_yn == 'N'?reply.reply_content : '삭제 된 댓글입니다'}</p></td>
											<td>${reply.reply_reg_dt}</td>
											<c:if test="${mem_id == reply.reply_mem_id}">
											<td><input idx="${reply.reply_seq}" type="button" class="btn btn-default delbtn" value="삭제"></td>
											</c:if>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
