<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    String sId =(String)session.getAttribute("session_id");
    %>
    <c:set var="sId" value="<%=sId %>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메인페이지</h1>
<a href="http://localhost:8181/MyFirstWeb/boardList.do">게시판 입장</a><br/>
<c:if test="${sId eq null }">
	<a href="http://localhost:8181/MyFirstWeb/users/login_form.jsp">로그인</a><br/>
	<a href="http://localhost:8181/MyFirstWeb/users/join_form.jsp">회원가입</a>	
</c:if>
<c:if test="${sessionScope_session_id ne null}">
<a href="http://localhost:8181/MyFirstWeb/users/logout.jsp">로그아웃</a>
</c:if>
</body>
</html>