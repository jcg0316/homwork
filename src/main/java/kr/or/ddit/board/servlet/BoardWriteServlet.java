package kr.or.ddit.board.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("board_title");
		String content = request.getParameter("smarteditor");
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		BoardVO bvo = new BoardVO();
		bvo.setBoard_title(title);
		bvo.setBoard_content(content);
		bvo.setBoard_mem_id(mem_id);
		
		int insertBoard = service.boardWrite(bvo);
		
		if(insertBoard == 1){
			response.sendRedirect(request.getContextPath() + "/boardList");
		}
		
		else{
			response.sendRedirect(request.getContextPath() + "/boardWrite");
		}
	}

}
