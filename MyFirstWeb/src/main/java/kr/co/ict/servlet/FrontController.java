package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.servlet.service.BoardDeleteService;
import kr.co.ict.servlet.service.BoardDetailService;
import kr.co.ict.servlet.service.BoardInsertFormService;
import kr.co.ict.servlet.service.BoardInsertService;
import kr.co.ict.servlet.service.BoardListService;
import kr.co.ict.servlet.service.BoardUpdateFormService;
import kr.co.ict.servlet.service.BoardUpdateService;
import kr.co.ict.servlet.service.IBoardService;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request,response);
	}
	
	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri=request.getRequestURI();
		String ui = null;
		IBoardService sv=null;
		
		if(uri.equals("/MyFirstWeb/boardList.do")) {
			sv = new BoardListService();
			sv.execute(request, response);
			ui = "/board/boardlist.jsp";
		}else if(uri.equals("/MyFirstWeb/boardDetail.do")){
			sv=new BoardDetailService();
			sv.execute(request, response);
			ui="/board/boarddetail.jsp";
		}else if(uri.equals("/MyFirstWeb/insertForm.do")){
			sv = new BoardInsertFormService();
			sv.execute(request, response);
			ui="/board/boardform.jsp";
		}else if(uri.equals("/MyFirstWeb/BoardInsert.do")){
			sv = new BoardInsertService();
			sv.execute(request, response);
			ui="/boardList.do";
		}else if(uri.equals("/MyFirstWeb/boardDelete.do")){
			sv=new BoardDeleteService();
			sv.execute(request, response);
			ui="/boardList.do";
		}else if(uri.equals("/MyFirstWeb/boardUpdateForm.do")){
			sv= new BoardUpdateFormService();
			sv.execute(request, response);
			ui="/board/boardUpdateForm.jsp";
		}else if(uri.equals("/MyFirstWeb/BoardUpdate.do")){
			sv = new BoardUpdateService();
			sv.execute(request, response);
			ui="/boardDetail.do?board_num="+request.getParameter("board_num");
		}else {
			ui="/";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}

}
