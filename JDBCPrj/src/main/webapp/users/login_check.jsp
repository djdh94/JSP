<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String fId = request.getParameter("uId");
    String fPw = request.getParameter("uPw"); 
    System.out.println("폼에서 날린 아이디 : "+fId);
    System.out.println("폼에서 날린 패스워드 : "+fPw);
    String dbType="com.mysql.cj.jdbc.Driver";
   	String dbUrl="jdbc:mysql://localhost:3306/jdbcprac1";
   	String dbId = "root";
   	String dbPw = "mysql";
   	Connection con=null;
   	PreparedStatement pstmt= null;
   	ResultSet rs = null;
    try{
    	Class.forName(dbType);
    	con=DriverManager.getConnection(dbUrl,dbId,dbPw);
    	String sql = "select * from userinfo where uid=?";
    	pstmt = con.prepareStatement(sql);
    	pstmt.setString(1, fId);
    	rs = pstmt.executeQuery();
    	
    	if(rs.next()){
    		String uId =rs.getString("uid");
    		String uPw =rs.getString("upw");
    		 System.out.println("DB 에서 날린 아이디 : "+uId);
    		 System.out.println("DB 에서 날린 패스워드 : "+uPw);
    		 if(fId.equals(uId) && fPw.equals(uPw)){
    			 session.setAttribute("session_id", uId);
    			 session.setAttribute("session_pw", uPw);
    			 response.sendRedirect("login_welcome.jsp");
    		 }else{
    			 out.println("패스워드가 틀렸습니다.");
    		 }
    	}else{
    		out.println("아이디가 존재하지 않습니다.");
    	}
    	
    }catch(Exception e){
    	e.printStackTrace();
    }
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