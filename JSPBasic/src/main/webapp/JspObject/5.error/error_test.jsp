<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@
    page errorPage="error_page.jsp"
    %>
    <%
    int a=3/0;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
나누기 결과값은 <%=a %>
</body>
</html>