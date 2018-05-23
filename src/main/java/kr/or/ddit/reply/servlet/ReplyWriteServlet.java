package kr.or.ddit.reply.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.reply.model.ReplyVO;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

@WebServlet("/replyWrite")
public class ReplyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private ReplyServiceInf service;
	
	public ReplyWriteServlet() {
        super();
        service = new ReplyService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int board_seq = Integer.parseInt((request.getParameter("board_seq")));
		request.setAttribute("board_seq", board_seq);
		
		String content = request.getParameter("replyWrite");

		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setReply_board_seq(board_seq);
		rvo.setReply_content(content);
		rvo.setReply_mem_id(mem_id);
		
		int insertReply = service.replyWrite(rvo);
		
		if(insertReply == 1){
			response.sendRedirect(request.getContextPath() + "/getBoard?board_seq="+board_seq);
		}
	}

}
