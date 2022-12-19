<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	%>
	<c:if test="${param.name eq '홍길동' }">
	${param.name }
	</c:if>
	<c:set var="name" value="${param.name }" />
	입력한값은 ${name }입니다.
</body>
</html>