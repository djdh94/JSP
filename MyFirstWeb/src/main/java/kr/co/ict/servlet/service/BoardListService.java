package kr.co.ict.servlet.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class BoardListService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> boardList = dao.getAllBoardList();
		request.setAttribute("boardList", boardList);
		
		HttpSession session = request.getSession();
		String sId =(String)session.getAttribute("session_id");
		System.out.println("로그인여부: "+sId);
		request.setAttribute("sId", sId);
	}
	

}
