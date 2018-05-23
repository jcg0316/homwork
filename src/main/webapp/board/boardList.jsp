<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title></title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

<%@ include file="/include/commonCss.jsp"%>
<%@ include file="/include/jquery.jsp"%>
<script>
$(function(){
	$("#boardList tr").on('click',function(){
		var board_del_yn = $(this).find(".del").val();
		if(board_del_yn == "Y"){
			alert("삭제 된 글은 볼 수 없습니다.")
		}else{
			var board_seq = $(this).find("td:eq(0)").text();
			$("#board_seq").val(board_seq);
			$("#getBoardFrm").submit();	
		}
	})
	
	$("#boardWrite").on('click',function(){
		$("#categoryFrm").submit();
	})
});
</script>
  </head>

  <body>
  	<%@include file="/layout/header.jsp" %>
<form id="getBoardFrm" method="get" action="${pageContext.request.contextPath}/getBoard">
	<input type="hidden" id="board_seq" name="board_seq">
</form>

<form id="categoryFrm" method="get" action="${pageContext.request.contextPath}/boardWrite">
	<input type="hidden" id="category_seq" name="category_seq" value="${category_seq}">
</form>

    <div class="container-fluid">
      <div class="row">
        <%@ include file="/layout/left.jsp" %>
        
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

          <h2 class="sub-header">공지사항</h2>
          <div class="table-responsive">
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th>번호</th>
                  <th>게시판종류</th>
                  <th>제목</th>
                  <th>날짜</th>
                  <th><input type="hidden" value="삭제여부"></th>
                </tr>
              </thead>
              <tbody id="boardList">
				<c:forEach items="${boardList}" var="board">
	               <tr>
	                 <td>${board.board_seq}</td>
	                 <td>${board.category_seq}</td>
	                 
	                 	<td>
	                 	<c:forEach begin="2" end="${board.level}">&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach>
	                 	<c:if test="${board.board_seq!=board.group_seq }">┕</c:if>
	                 	<a>${board.board_del_yn=='N'?board.board_title : '삭제 된 글입니다'}</a>
	                 </td>
	                 <td>${board.board_reg_dt}</td>
	                 <td><input type="hidden" value="${board.board_del_yn}" class="del"></td>
	               </tr>
				</c:forEach>
              </tbody>
            </table>
          </div>
        <c:if test="${mem_id != null}">
			<button type="button" id="boardWrite" class="btn btn-default">작성</button>
        </c:if>
		${pageNav }
			</div>
      </div>
    </div>

  </body>
</html>
