package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class BoardUpdateFormService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String sbno = request.getParameter("bno");
		int bno = Integer.parseInt(sbno);
		System.out.println("bno:"+bno);

		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board = dao.getBoardDetail(bno);
		request.setAttribute("board", board);
		
	}

}
