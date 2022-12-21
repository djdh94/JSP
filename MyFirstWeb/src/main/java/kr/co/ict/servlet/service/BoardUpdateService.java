package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

public class BoardUpdateService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String sbno = request.getParameter("board_num");
		int bno = Integer.parseInt(sbno);
		System.out.println("bno:"+bno);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardUpdate(title, content, bno);
		
	}

}
