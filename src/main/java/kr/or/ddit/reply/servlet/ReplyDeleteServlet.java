package kr.or.ddit.reply.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.model.ReplyVO;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceInf;

@WebServlet("/replyDelete")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ReplyServiceInf service;
	
    public ReplyDeleteServlet() {
        super();
        service = new ReplyService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int reply_seq = Integer.parseInt((request.getParameter("reply_seq")));
		int board_seq = Integer.parseInt((request.getParameter("board_seq")));

		ReplyVO rvo = new ReplyVO();
		rvo.setReply_seq(reply_seq);
		
		int deleteReply = service.replyDelete(rvo);
		
		if(deleteReply == 1){
			response.sendRedirect(request.getContextPath() + "/getBoard?board_seq="+board_seq);
		}
	}

}
