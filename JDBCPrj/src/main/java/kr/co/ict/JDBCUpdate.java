package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCUpdate {
	public static void main(String[] args) {
		String dbType="com.mysql.cj.jdbc.Driver";
		String dbUrl="jdbc:mysql://localhost:3306/jdbcprac1";
		String dbId = "root";
		String dbPw = "mysql";
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("이름");
			String uname = scan.nextLine();
			System.out.println("패스워드");
			String upw = scan.nextLine();
			System.out.println("이메일");
			String uemail = scan.nextLine();
			System.out.println("아이디");
			String uid = scan.nextLine();
			Class.forName(dbType);
			Connection con = DriverManager.getConnection(dbUrl,dbId,dbPw);
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update userinfo set uname='"+uname+"',upw='"+upw+"',uemail='"+uemail+"' where uid='"+uid+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
