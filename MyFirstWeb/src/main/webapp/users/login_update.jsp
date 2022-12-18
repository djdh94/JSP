<%@page import="kr.co.ict.UserVO"%>
<%@page import="kr.co.ict.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
  String uId = (String)session.getAttribute("session_id");
  if(uId ==null){
	  response.sendRedirect("login_form.jsp");
  }
 
//   String dbType="com.mysql.cj.jdbc.Driver";
// 	String dbUrl="jdbc:mysql://localhost:3306/jdbcprac1";
// 	String dbId = "root";
// 	String dbPw = "mysql";
// 	Connection con=null;
// 	PreparedStatement pstmt= null;
// 	ResultSet rs = null;
// 	String fName=null;
// 	String fEmail=null;
	
// 	try{
// 		Class.forName(dbType);
// 		con=DriverManager.getConnection(dbUrl,dbId,dbPw);
// 		String sql = "select * from userinfo where uid=?";
// 		pstmt = con.prepareStatement(sql);
// 		pstmt.setString(1, uId);
// 		rs=pstmt.executeQuery();
// 		if(rs.next()){
// 		fName= rs.getString("uname");
// 		fEmail= rs.getString("uemail");
// 		}
// 	}catch(Exception e){
// 		e.printStackTrace();
// 	}

	UserDAO dao = UserDAO.getInstance();
	UserVO user = dao.getUserData(uId);
	out.println(user+"<br/>");
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update_check.jsp" method="post">
		<input type="password" name=fpw placeholder="비밀번호"/><br/>
		<input type="text" name=fname placeholder="이름" value="<%=user.getuName()%>"/><br/>
		<input type="text" name=femail placeholder="이메일" value="<%=user.getuEmail()%>"/><br/>
		<input type="submit" value="수정"/>
	</form>
</body>
</html>