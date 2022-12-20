package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sbno = request.getParameter("board_num");
		int bno = Integer.parseInt(sbno);
		System.out.println("bno:"+bno);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardUpdate(title, content, bno);
		response.sendRedirect("http://localhost:8181/MyFirstWeb/boarddetail?board_num="+bno);
	}

}
