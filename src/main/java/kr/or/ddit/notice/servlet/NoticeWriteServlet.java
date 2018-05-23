package kr.or.ddit.notice.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.service.NoticeServiceInf;


@WebServlet("/noticeWrite")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NoticeServiceInf service;
	
    public NoticeWriteServlet() {
        super();
        service = new NoticeService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String notice_name = request.getParameter("notice_name");
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		NoticeVO nvo = new NoticeVO();
		nvo.setNotice_name(notice_name);
		nvo.setNotice_mem_id(mem_id);
		
		int insertNotice = service.noticeWrite(nvo);
		
		if(insertNotice == 1){
			List<NoticeVO> noticeList = service.getNoticeList();
			List<NoticeVO> noticeListLayout = service.getNoticeListLayout();
			
			ServletContext application = getServletContext();
			application.setAttribute("noticeList",noticeList);
			application.setAttribute("noticeListLayout",noticeListLayout);
			
			response.sendRedirect("main/main.jsp");
			
		}
		
		else{
			response.sendRedirect(request.getContextPath() + "/noticeWrite");
		}
	}

}
