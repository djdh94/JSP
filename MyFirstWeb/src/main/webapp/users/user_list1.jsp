<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String dbType="com.mysql.cj.jdbc.Driver";
  	String dbUrl="jdbc:mysql://localhost:3306/jdbcprac1";
  	String dbId = "root";
  	String dbPw = "mysql";
  	Connection con=null;
  	PreparedStatement pstmt= null;
  	ResultSet rs=null;
  	try{
  		Class.forName(dbType);
  		con=DriverManager.getConnection(dbUrl,dbId,dbPw);
  		String sql ="select * from userinfo";
  		pstmt=con.prepareStatement(sql);
  		rs=pstmt.executeQuery();
  		while(rs.next()){
  			rs.getString(1);
  			rs.getString(2);
  			rs.getString(3);
  			rs.getString(4);
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
	<table border="1">
		<thead>
			<tr>
				<th>유저이름</th>
				<th>유저아이디</th>
				<th>유저비밀번호</th>
				<th>유저이메일</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
</body>
</html>