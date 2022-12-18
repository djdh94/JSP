<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String sId = (String)session.getAttribute("session_id");
    if(sId == null){
    	response.sendRedirect("login_form.jsp");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=sId %>님 환영합니다<br/>
	<a href="login_update.jsp">정보수정</a><br/>
	<a href="logout.jsp">로그아웃</a><br/>
	<a href="member_out.jsp">회원탈퇴</a><br/>
	<a href="#"></a>
</body>
</html>