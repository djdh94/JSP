<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String city = request.getParameter("city"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if(city.equals("kunming")){
		response.sendRedirect("travel_kunming.jsp");
	}
	%>
</body>
</html>