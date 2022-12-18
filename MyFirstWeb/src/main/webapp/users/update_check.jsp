<%@page import="kr.co.ict.UserDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.cj.jdbc.Driver"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%
      request.setCharacterEncoding("utf-8");
      String uId = (String)session.getAttribute("session_id");
      String uPw = request.getParameter("fpw");
      String uName = request.getParameter("fname");
      String uEmail = request.getParameter("femail");
//     String dbType="com.mysql.cj.jdbc.Driver";
//   	String dbUrl="jdbc:mysql://localhost:3306/jdbcprac1";
//   	String dbId = "root";
//   	String dbPw = "mysql";
//   	Connection con=null;
//   	PreparedStatement pstmt= null;
//   	try{
//   		Class.forName(dbType);
//   		con=DriverManager.getConnection(dbUrl,dbId,dbPw);
//   		String sql ="update userinfo set upw=?,uname=?,uemail=?where uid=?";
//   		pstmt =con.prepareStatement(sql);
//   		pstmt.setString(1, uPw);
//   		pstmt.setString(2, uName);
//   		pstmt.setString(3, uEmail);
//   		pstmt.setString(4, uId);
//   		pstmt.executeUpdate();
//   	}catch(Exception e){
//   		e.printStackTrace();
//   	}finally{
//   		response.sendRedirect("login_welcome.jsp");
//   	}
		UserDAO dao = UserDAO.getInstance();
		dao.updateCheck(uId, uPw, uName, uEmail);
		response.sendRedirect("login_update.jsp");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>