<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String autoLoign = request.getParameter("auto");
    System.out.println(autoLoign);
    if(id.equals("a") && pw.equals("a")){
   	 if(autoLoign !=null){
    		Cookie auto = new Cookie("auto_login",id);
    		auto.setMaxAge(20);
    		response.addCookie(auto);
    		
    	}
   	 response.sendRedirect("cookie_welcome.jsp");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인실패</h2>
<a href="cookie_login.jsp">로그인화면</a>
</body>
</html>