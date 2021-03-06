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

@WebServlet("/boardWrite")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardServiceInf service;
	
	public BoardWriteServlet() {
        super();
        service = new BoardService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int category_seq = Integer.parseInt((request.getParameter("category_seq")));
		request.setAttribute("category_seq", category_seq);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardWrite.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("board_title");
		String content = request.getParameter("smarteditor");
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");

		int category_seq = Integer.parseInt((request.getParameter("category_seq")));
		request.setAttribute("category_seq", category_seq);
		
		BoardVO bvo = new BoardVO();
		bvo.setBoard_title(title);
		bvo.setBoard_content(content);
		bvo.setBoard_mem_id(mem_id);
		bvo.setCategory_seq(category_seq);
		
		int insertBoard = service.boardWrite(bvo);
		
		if(insertBoard == 1){
			response.sendRedirect(request.getContextPath() + "/boardList?category_seq="+category_seq);
		}
		
		else{
			response.sendRedirect(request.getContextPath() + "/boardWrite");
		}
	}

}
