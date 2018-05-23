package kr.or.ddit.board.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardServiceInf service;
	
    public BoardListServlet() {
        super();
        service = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int category_seq = Integer.parseInt(request.getParameter("category_seq"));
		request.setAttribute("category_seq",category_seq);
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		
		String pageSizeString = request.getParameter("pageSize");
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
	
		Map<String, Object> resultMap = service.getBoardPageList(category_seq, page, pageSize);
		request.setAttribute("boardList", resultMap.get("boardList"));
		request.setAttribute("pageNav", resultMap.get("pageNav"));
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.jsp");
		rd.forward(request, response);
	}

}
