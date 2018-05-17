package kr.or.ddit.notice.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.service.NoticeServiceInf;


@WebServlet("/noticeAct")
public class NoticeActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NoticeServiceInf service;
	
    public NoticeActServlet() {
        super();
        service = new NoticeService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int notice_seq = Integer.parseInt((request.getParameter("notice_seq")));
		String notice_act = request.getParameter("notice_act");
		
		NoticeVO nvo = new NoticeVO();
		nvo.setNotice_seq(notice_seq);
		nvo.setNotice_act(notice_act);
		
		if(notice_act.equals("Y")){			
			service.noticeActOff(nvo);
		}else {
			service.noticeActOn(nvo);
		}
		
		List<NoticeVO> noticeList = service.getNoticeList();
		List<NoticeVO> noticeListLayout = service.getNoticeListLayout();
		
		ServletContext application = getServletContext();
		application.setAttribute("noticeList",noticeList);
		application.setAttribute("noticeListLayout",noticeListLayout);
		
		RequestDispatcher rd = request.getRequestDispatcher("main/main.jsp");
		rd.forward(request,response);
	}

}
