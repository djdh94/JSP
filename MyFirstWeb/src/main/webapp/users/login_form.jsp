<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String sId=(String)session.getAttribute("session_id");
    if(sId !=null){
    	response.sendRedirect("login_welcome.jsp");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login_check.jsp">
		아이디 : <input type="text" name="uId" placeholder="아이디" required/><br/>
		패스워드 : <input type="password" name="uPw" placeholder="패스워드" required/><br/>
		<input type="submit"/>
	</form>
	<a href="join_form.jsp"><button>회원가입</button></a>
</body>
</html>