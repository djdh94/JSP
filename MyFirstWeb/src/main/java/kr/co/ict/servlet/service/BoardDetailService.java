package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class BoardDetailService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String sbNum = request.getParameter("board_num");
		int bNum=0;
		if(sbNum != null) {
		 bNum = Integer.parseInt(sbNum);
		}else {
			bNum=1;
		}
		//System.out.println(bNum);
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board = dao.getBoardDetail(bNum);
		System.out.println(board);
		request.setAttribute("board", board);
		
	}

}
