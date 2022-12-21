package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

public class BoardDeleteService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String sbno = request.getParameter("bno");
		int bno = Integer.parseInt(sbno);
		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardDelete(bno);
		
	}

}
