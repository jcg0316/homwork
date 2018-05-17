<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/include/jquery.jsp"%>
<script>
$(function(){
	$("#board_li a").click(function(){
		var category_seq = $(this).attr("category_seq");
		$("#category_seq").val(category_seq);
		$("#boardListfrm").submit();
	});
})
</script>
<form id="boardListfrm" class="form-signin" action="${pageContext.request.contextPath }/boardList" method="get">
	<input type="hidden" id="category_seq" name="category_seq">
<div class="col-sm-3 col-md-2 sidebar">
	<ul id="board_li" class="nav nav-sidebar">
		<c:forEach items="${noticeListLayout}" var="notice">
			<li><a category_seq="${notice.notice_seq}"href="#">${notice.notice_name}</a></li>
		</c:forEach>
	</ul>
</div>
</form>