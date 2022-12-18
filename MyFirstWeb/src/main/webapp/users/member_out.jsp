<%@page import="kr.co.ict.UserDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String uId =(String)session.getAttribute("session_id");
//     String dbType="com.mysql.cj.jdbc.Driver";
//   	String dbUrl="jdbc:mysql://localhost:3306/jdbcprac1";
//   	String dbId = "root";
//   	String dbPw = "mysql";
//   	Connection con=null;
//   	PreparedStatement pstmt= null;
//   	try{
//   		Class.forName(dbType);
//   		con=DriverManager.getConnection(dbUrl,dbId,dbPw);
//   		String sql ="delete from userinfo where uid=?";
//   		pstmt = con.prepareStatement(sql);
//   		pstmt.setString(1,uId);
//   		pstmt.executeUpdate();
//   	}catch(Exception e){ 
//   		e.printStackTrace();
//   	}finally{
//   		session.invalidate();
//   		response.sendRedirect("login_form.jsp");
//   	}
	UserDAO dao = UserDAO.getInstance();
	dao.deleteUser(uId);
	session.invalidate();
	response.sendRedirect("login_form.jsp");
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