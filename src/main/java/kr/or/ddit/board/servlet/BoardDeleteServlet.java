package kr.or.ddit.board.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardServiceInf service;
	
    public BoardDeleteServlet() {
        super();
        service = new BoardService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int board_seq = Integer.parseInt((request.getParameter("board_seq")));
		int category_seq = Integer.parseInt((request.getParameter("category_seq")));
		
		BoardVO bvo = new BoardVO();
		bvo.setBoard_seq(board_seq);
		
		int deleteboard = service.boardDelete(bvo);
		
		if(deleteboard != 0){
			response.sendRedirect(request.getContextPath() + "/boardList?category_seq=" + category_seq);
		}else{
			
		}
	}

}
