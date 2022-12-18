package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsert {
	public static void main(String[] args) {
		String dbType="com.mysql.cj.jdbc.Driver";
		String dbUrl="jdbc:mysql://localhost:3306/jdbcprac1";
		String dbId = "root";
		String dbPw = "mysql";
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("아이디");
			String uId = scan.nextLine();
			System.out.println("패스워드");
			String uPw = scan.nextLine();
			System.out.println("이름");
			String name = scan.nextLine();
			System.out.println("이메일");
			String email = scan.nextLine();
			Class.forName(dbType);
			Connection con = DriverManager.getConnection(dbUrl,dbId,dbPw);
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into userinfo values('"+uId+"','"+uPw+"','"+name+"','"+email+"')");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
