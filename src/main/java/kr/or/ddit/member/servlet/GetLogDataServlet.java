package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceInf;
import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.service.NoticeServiceInf;

@WebServlet("/getLogData")
public class GetLogDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberServiceInf service;
	private NoticeServiceInf nService;
	
    public GetLogDataServlet() {
        super();
        service = new MemberService();
        nService = new NoticeService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		MemberVO mvo = new MemberVO();
		mvo.setMem_id(mem_id);
		mvo.setMem_pass(mem_pass);
		
		MemberVO memVO = service.getLogData(mvo);
		List<NoticeVO> noticeList = nService.getNoticeList();
		List<NoticeVO> noticeListLayout = nService.getNoticeListLayout();
		
		if(memVO != null){	
			request.setAttribute("memVO", memVO);
			
			ServletContext application = getServletContext();
			application.setAttribute("noticeList",noticeList);
			application.setAttribute("noticeListLayout",noticeListLayout);
			
			HttpSession session = request.getSession();
			session.setAttribute("mem_id", mem_id);
			
			RequestDispatcher rd = request.getRequestDispatcher("main/main.jsp");
			rd.forward(request,response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("login/login.jsp");
			rd.forward(request,response);	
		}
	}
}
	
