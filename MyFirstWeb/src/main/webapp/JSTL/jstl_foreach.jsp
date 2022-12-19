<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach begin="2" end="9" var="dan">
		<c:forEach begin="1" end="9" var="i">
			${dan } * ${i } = ${dan*i } <br/>
		</c:forEach>
	</c:forEach>
	
	<c:set var="arr" value="<%=new int[] {10,20,30,40} %>"/>
	<c:forEach var="i" items="${arr }">
		${i }
	</c:forEach>
</body>
</html>