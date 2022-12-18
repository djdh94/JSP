package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	
	//커넥션풀 처리로 인한 미사용
//	private	String dbType="com.mysql.cj.jdbc.Driver";
//	private String dbUrl="jdbc:mysql://localhost:3306/jdbcprac1";
//	private String dbId = "root";
//	private String dbPw = "mysql";
	private DataSource ds = null;
	Connection con=null;
  	PreparedStatement pstmt= null;
  	ResultSet rs=null;
  	List<UserVO> userList = new ArrayList<UserVO>();
  	UserVO user=null;
  	
//	public UserDAO() {
//		try {
//			Class.forName(dbType);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
  	
  	// 싱글턴 패턴처리
  	
  	// DAO 내부에 멤버변수로 UserDAO를 하나 생성합니다.
  	private static UserDAO dao = new UserDAO();
  	// 싱글턴 패턴은 요청시마다 DAO를 매번 생성하지 않고 , 먼저하나를 생성해둔 
  	// 사용자가 요청때는 이미 생성된 DAO 주소값만 공유해서 사용
  	
		private UserDAO() {
		try {
			Context ct = new InitialContext();
			ds =(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	// 2. static 키워드를 이용해서 단한번만 생성하고, 그 이후로
	// 주소를 공유하는 getInstance() 메서드를 공유
	public static UserDAO getInstance() {
		if(dao ==null) {
			dao = new UserDAO();
		}
		return dao;
	}
	
	public List<UserVO> getAllUserList(){
		try {
		con=ds.getConnection();
		String sql="select * from userinfo";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			String uName=rs.getString(1);
			String uId=rs.getString(2);
			String uPw=rs.getString(3);
			String uEmail=rs.getString(4);
			UserVO userData = new UserVO(uName, uId, uPw, uEmail);
			userList.add(userData);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			pstmt.close();
			rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}
	
	public UserVO getUserData(String sId) {
		try {
			con=ds.getConnection();
			String sql="select * from userinfo where uid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, sId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String uName=rs.getString(1);
				String uId=rs.getString(2);
				String uPw=rs.getString(3);
				String uEmail=rs.getString(4); 
				user = new UserVO(uName, uId, uPw, uEmail);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public void updateCheck(String id,String pw,String name,String email) {
		try {
			con=ds.getConnection();
		String sql = "update userinfo set uname=?,upw=?,uemail=? where uid=?";
		pstmt =con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, pw);
		pstmt.setString(3, email);
		pstmt.setString(4, id);
		pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void deleteUser(String sId) {
		try {
			con=ds.getConnection();
		String sql="delete from userinfo where uid=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sId);
		pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertUser(String name,String id,String pw,String email) {
		try {
			con=ds.getConnection();
			String sql="insert into userinfo values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}
}
