package kr.co.ict;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource ds = null;
	Connection con=null;
  	PreparedStatement pstmt= null;
  	ResultSet rs=null;
  	List<BoardVO> boardList = new ArrayList<BoardVO>();
  	BoardVO board=null;
	private static BoardDAO dao = new BoardDAO();
	private BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds =(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static BoardDAO getInstance() {
		if(dao ==null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	public List<BoardVO> getAllBoardList(){
		try {
		con=ds.getConnection();
		String sql="select * from boardinfo order by board_num desc";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			int board_num=rs.getInt(1);
			String title=rs.getString(2);
			String content=rs.getString(3);
			String writer=rs.getString(4);
			Date bdate=rs.getDate(5);
			Date mdate=rs.getDate(6);
			int hit=rs.getInt(7);
			BoardVO boardData = new BoardVO(board_num, title, content, writer, bdate, mdate, hit);
			boardList.add(boardData);
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
		return boardList;
	}
	
	public void insertBoard(String title,String content,String writer) {
		try {
			con=ds.getConnection();
			String sql = "insert into boardinfo(title,content,writer) values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writer);
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
	
	public BoardVO getBoardDetail(int bno) {
		try {
			con = ds.getConnection();
			String sql ="select * from boardinfo where board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int boardNum=rs.getInt(1);
				String title=rs.getString(2);
				String content=rs.getString(3);
				String writer=rs.getString(4);
				Date bdate = rs.getDate(5);
				Date mdate = rs.getDate(6);
				int hit = rs.getInt(7);
				board = new BoardVO(boardNum, title, content, writer, bdate, mdate, hit);
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
		return board;
	}
	
	public void BoardDelete(int board_num) {
		try {
			con =ds.getConnection();
			String sql ="delete from boardinfo where board_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
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
	
	public void BoardUpdate(String title, String Content,int board_num) {
		try {
			con =ds.getConnection();
			String sql ="update boardinfo set title=?,content=?,mdate=now() where board_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, Content);
			pstmt.setInt(3, board_num);
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

}
