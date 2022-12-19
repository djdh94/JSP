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
 <c:choose>
  <c:when test="${param.name eq '자바' }">
  	자바
  </c:when>
  <c:when test="${param.name eq '파이썬' }">
  파이썬
  </c:when>
  <c:when test="${param.name eq 'php' }">
   php
  </c:when>
 </c:choose>
</body>
</html>