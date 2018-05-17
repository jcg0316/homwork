package kr.or.ddit.notice.service;

import java.util.List;

import kr.or.ddit.notice.dao.NoticeDao;
import kr.or.ddit.notice.dao.NoticeDaoInf;
import kr.or.ddit.notice.model.NoticeVO;

public class NoticeService implements NoticeServiceInf{
	
	NoticeDaoInf ndao;
	
	public NoticeService(){
		ndao = new NoticeDao();
	}

	@Override
	public List<NoticeVO> getNoticeList() {
		return ndao.getNoticeList();
	}

	@Override
	public List<NoticeVO> getNoticeListLayout() {
		return ndao.getNoticeListLayout();
	}
	
	@Override
	public int noticeActOn(NoticeVO nvo) {
		return ndao.noticeActOn(nvo);
	}

	@Override
	public int noticeActOff(NoticeVO nvo) {
		return ndao.noticeActOff(nvo);
	}

	@Override
	public int noticeWrite(NoticeVO nvo) {
		return ndao.noticeWrite(nvo);
	}

	
	
}
