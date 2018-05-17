package kr.or.ddit.board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;


@WebServlet("/boardModify")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardServiceInf service;
	
    public BoardModifyServlet() {
        super();
        service = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_seq = Integer.parseInt((request.getParameter("board_seq")));
		
		BoardVO bvo = service.getBoard(board_seq);
		
		request.setAttribute("bvo", bvo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardModify.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int board_seq = Integer.parseInt((request.getParameter("board_seq")));
		
		String title = request.getParameter("board_title");
		String content = request.getParameter("smarteditor");
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		if(title.equals("")){
			BoardVO origin = service.getBoard(board_seq);
			title = origin.getBoard_title();
		}else if(content.equals("")){
			BoardVO origin = service.getBoard(board_seq);
			content = origin.getBoard_content();
		}
		
		BoardVO bvo = new BoardVO();
		bvo.setBoard_title(title);
		bvo.setBoard_content(content);
		bvo.setBoard_mem_id(mem_id);
		bvo.setBoard_seq(board_seq);
		
		int updateModify = service.boardModify(bvo);
		
		if(updateModify != 0){
			response.sendRedirect(request.getContextPath() + "/getBoard?board_seq=" + board_seq);
		}else{
			System.out.println("실패입니다");
			
		}
	}

}
