package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;

public class BoardDeleteService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String sbno = request.getParameter("bno");
		int bno = Integer.parseInt(sbno);
		String writer = request.getParameter("writer");
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
		if(sId.equals(writer)) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardDelete(bno);
		}
		
	}

}
