<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String id=request.getParameter("id");
    String name = request.getParameter("name");
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(id.equals("abcd")){ %>
	중복된 아이디로 가입할수 없습니다.
	<%} else{%>
	<%=id %>(<%=name %>)님 회원가입을 축하합니다.
	<%} %>
</body>
</html>