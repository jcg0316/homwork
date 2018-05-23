package kr.or.ddit.board.servlet;

import java.io.IOException;
import java.util.List;

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
import kr.or.ddit.reply.model.ReplyVO;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

@WebServlet("/getBoard")
public class GetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardServiceInf service;
	private ReplyServiceInf rService;
	
    public GetBoardServlet() {
        super();
        service = new BoardService();
        try {
			
        	rService = new ReplyService();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_seq = Integer.parseInt((request.getParameter("board_seq")));
		
		BoardVO bvo = service.getBoard(board_seq);
		
		ReplyVO rvo = new ReplyVO();
		rvo.setReply_board_seq(bvo.getBoard_seq());
				
		List<ReplyVO> replyList = rService.getReplyList(rvo);

		request.setAttribute("replyList", replyList);
		request.setAttribute("bvo", bvo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/board.jsp");
		rd.forward(request, response);
		
	}


}
