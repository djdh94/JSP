<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입페이지</h2>
	<form action="join_check.jsp">
		아이디 : <input type="text" name="uId" placeholder="아이디" required/><br/>
		패스워드 : <input type="password" name="uPw" placeholder="패스워드" required/><br/>
		이름 : <input type="text" name="uName" placeholder="이름" required/><br/>
		이메일 : <input type="text" name="uEmail" placeholder="이메일"/><br/>
		<input type="submit"/>
	</form>
</body>
</html>