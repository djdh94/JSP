<%@page import="kr.co.ict.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.ict.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
//     String dbType="com.mysql.cj.jdbc.Driver";
//   	String dbUrl="jdbc:mysql://localhost:3306/jdbcprac1";
//   	String dbId = "root";
//   	String dbPw = "mysql";
//   	Connection con=null;
//   	PreparedStatement pstmt= null;
//   	ResultSet rs=null;
//   	List<UserVO> userList  =new ArrayList<>();
// 	try{
//   		Class.forName(dbType);
//   		con=DriverManager.getConnection(dbUrl,dbId,dbPw);
//   		String sql ="select * from userinfo";
//   		pstmt=con.prepareStatement(sql);
//   		rs=pstmt.executeQuery();
//   		while(rs.next()){
//   			String uName=rs.getString(1);
//   			String uId=rs.getString(2);
//   			String uPw = rs.getString(3);
//   			String uEmail = 	rs.getString(4);
//   			UserVO userData = new UserVO(uName,uId,uPw,uEmail); 
//   			userList.add(userData);
//   		}
//   	}catch(Exception e){
//   		e.printStackTrace();
//   	}

	UserDAO dao = UserDAO.getInstance();
	List<UserVO> userList = dao.getAllUserList();
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
		<%for(UserVO user:userList){ %>
			<tr>
				<td><%=user.getuName() %></td>
				<td><%=user.getuId() %></td>
				<td><%=user.getuPw() %></td>
				<td><%=user.getuEmail()%></td>
			</tr>
		<%} %>
		</tbody>
	</table>
</body>
</html>