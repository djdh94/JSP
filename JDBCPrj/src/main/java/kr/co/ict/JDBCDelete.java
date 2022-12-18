package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDelete {

	public static void main(String[] args) {
		String dbType="com.mysql.cj.jdbc.Driver";
		String dbUrl="jdbc:mysql://localhost:3306/jdbcprac1";
		String dbId = "root";
		String dbPw = "mysql";
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("아이디입력");
			String uId = scan.nextLine();
			Class.forName(dbType);
			Connection con = DriverManager.getConnection(dbUrl,dbId,dbPw);
			Statement stmt = con.createStatement();
			stmt.executeUpdate("delete from userinfo where uid='"+uId+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
