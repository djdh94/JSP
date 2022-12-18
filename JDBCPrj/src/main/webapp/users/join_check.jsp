<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String fId = request.getParameter("uId");
    String fPw = request.getParameter("uPw");
    String fName = request.getParameter("uName");
    String fEmail = request.getParameter("uEmail");
    String dbType="com.mysql.cj.jdbc.Driver";
  	String dbUrl="jdbc:mysql://localhost:3306/jdbcprac1";
  	String dbId = "root";
  	String dbPw = "mysql";
  	Connection con=null;
  	PreparedStatement pstmt= null;
    try{
    	Class.forName(dbType);
		con = DriverManager.getConnection(dbUrl,dbId,dbPw);
		String sql = "insert into userinfo values(?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, fName);
		pstmt.setString(2, fId);
		pstmt.setString(3, fPw);
		pstmt.setString(4, fEmail);
		pstmt.executeUpdate();
    }catch(Exception e){
    	e.printStackTrace();
    }finally{
    	out.println("회원가입완료");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="login_form.jsp">로그인창</a>
</body>
</html>