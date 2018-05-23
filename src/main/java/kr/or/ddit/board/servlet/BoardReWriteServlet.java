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

@WebServlet("/boardReWrite")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
public class BoardReWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardServiceInf service;
	
	public BoardReWriteServlet() {
        super();
        service = new BoardService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int category_seq = Integer.parseInt((request.getParameter("category_seq")));
		int board_seq = Integer.parseInt((request.getParameter("board_seq")));
		int group_seq = Integer.parseInt((request.getParameter("group_seq")));
		
		request.setAttribute("category_seq", category_seq);
		request.setAttribute("board_seq", board_seq);
		request.setAttribute("group_seq", group_seq);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardReWrite.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("board_title");
		String content = request.getParameter("smarteditor");
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		int category_seq = Integer.parseInt((request.getParameter("category_seq")));
		int board_seq = Integer.parseInt((request.getParameter("board_seq")));
		int group_seq = Integer.parseInt((request.getParameter("group_seq")));
		
		request.setAttribute("category_seq", category_seq);
		request.setAttribute("board_seq", board_seq);
		request.setAttribute("group_seq", group_seq);
		
		
		BoardVO bvo = new BoardVO();
		bvo.setBoard_title(title);
		bvo.setBoard_content(content);
		bvo.setBoard_mem_id(mem_id);
		bvo.setCategory_seq(category_seq);
		bvo.setPboard_seq(board_seq);
		bvo.setGroup_seq(group_seq);
		
		int insertreWrite = service.boardReWrite(bvo);
		
		if(insertreWrite == 1){
			response.sendRedirect(request.getContextPath() + "/boardList?category_seq="+category_seq);
		}
		
		else{
			response.sendRedirect(request.getContextPath() + "/boardReWrite");
		}
		
	}

}
