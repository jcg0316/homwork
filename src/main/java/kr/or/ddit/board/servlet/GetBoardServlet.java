package kr.or.ddit.board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/getBoard")
public class GetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardServiceInf service;
	
    public GetBoardServlet() {
        super();
        service = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_seq = Integer.parseInt((request.getParameter("board_seq")));
		
		BoardVO bvo = service.getBoard(board_seq);
		
		request.setAttribute("bvo", bvo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/board.jsp");
		rd.forward(request, response);
		
	}


}
