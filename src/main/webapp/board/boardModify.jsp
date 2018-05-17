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

<!-- <script>
$(function(){
	
	//화면 로딩시 회원 아이디 입력칸에 focus
	$("#board_title").focus();
	
	//userReg 사용자 등록 버튼
	$("#boardModify").click(function(){
		//validation
		if($("#board_title").val().trim() == ""){
			alert("글 제목이 입력 되지 않았습니다.");
			$("#board_title").focus();
			return false;
		}
		
		if($("#board_content").val().trim() == ""){
			alert("내용이 입력되지 않았습니다.");
			$("#board_content").focus();
			return false;
		}
		
		//submit
		$("#boardModifyFrm").submit();
	});
});	
</script> -->
<script src="${pageContext.request.contextPath}/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">

$(function(){

	$("#board_title").focus();
	
	$("#savebutton").click(function(){
		//validation
		if($("#board_title").val().trim() == ""){
			alert("글 제목이 입력 되지 않았습니다.");
			$("#board_title").focus();
			return false;
		}
		
		//submit
		$("#boardModifyFrm").submit();
	});
});	

var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "${pageContext.request.contextPath}/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("수정하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#boardModifyFrm").submit();
			}
		}
	})
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
}

</script>   
</head>

<body>
	<%@ include file="/layout/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<%@ include file="/layout/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="boardModifyFrm" action="${pageContext.request.contextPath}/boardModify" method="post" class="form-horizontal" role="form"
					  enctype="multipart/form-data">
					 <input type="hidden" name="board_seq" value="${bvo.board_seq}">
					 
					 <div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="board_title" name="board_title" placeholder="제목" value="${bvo.board_title}">
						</div>
					</div>
				<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;">${bvo.board_content}</textarea> 
				</form>
				<button id="savebutton" type="button" class="btn btn-default">수정</button>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>	
</body>

</html>
