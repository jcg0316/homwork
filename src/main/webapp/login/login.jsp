<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

      <form id="frm" class="form-signin" action="${pageContext.request.contextPath }/getLogData" method="get">
        
        <label for="userId" class="sr-only">아이디</label>
        <input type="text" id="mem_id" name= "mem_id" class="form-control" placeholder="아이디를 입력해주세요" required autofocus><br>
  
        <label for="password" class="sr-only">비밀번호</label>
        <input type="password" id="mem_pass" name= "mem_pass" class="form-control" placeholder="비밀번호를 입력해주세요" required>
        
        <button id="signinbtn" class="btn btn-lg btn-primary btn-block" type="submit">접속</button>
      </form>

    </div> <!-- /container -->
</body>
</html>