package notice;

import static org.junit.Assert.*;
import kr.or.ddit.notice.dao.NoticeDao;
import kr.or.ddit.notice.dao.NoticeDaoInf;
import kr.or.ddit.notice.model.NoticeVO;

import org.junit.Before;
import org.junit.Test;

public class NoticeDaoTest {


	@Test
	public void noticeActOntest() {
		/***Given***/
		NoticeDaoInf ndao = new NoticeDao();
		int notice_seq = 1;
		
		NoticeVO nvo = new NoticeVO();
		nvo.setNotice_seq(notice_seq);
		
		
		/***When***/
		ndao.noticeActOff(nvo);
		
		/***Then***/
		assertNotNull(nvo);
	}

}
