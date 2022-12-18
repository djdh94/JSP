package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCpstmtDelete {

	public static void main(String[] args) {
		String dbType="com.mysql.cj.jdbc.Driver";
		String dbUrl="jdbc:mysql://localhost:3306/jdbcprac1";
		String dbId = "root";
		String dbPw = "mysql";
		Connection con=null;
		PreparedStatement pstmt= null;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("아이디");
			String uId = scan.nextLine();
			Class.forName(dbType);
			con = DriverManager.getConnection(dbUrl,dbId,dbPw);
			String sql = "delete from userinfo where uid=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, uId);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
