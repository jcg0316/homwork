package kr.or.ddit.notice.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import kr.or.ddit.notice.model.NoticeVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NoticeDao implements NoticeDaoInf{

	private SqlSessionFactory sqlSessionFactory;
	
	public NoticeDao(){
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<NoticeVO> getNoticeList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<NoticeVO> noticeList = sqlSession.selectList("notice.getNoticeList");
		sqlSession.close();
		return noticeList;
	}
	
	@Override
	public List<NoticeVO> getNoticeListLayout() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<NoticeVO> noticeList = sqlSession.selectList("notice.getNoticeListLayout");
		sqlSession.close();
		return noticeList;
	}
	
	@Override
	public int noticeActOn(NoticeVO nvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int noticeOn = sqlSession.update("notice.noticeActOn",nvo);
		sqlSession.commit();
		sqlSession.close();
		return noticeOn;
	}

	@Override
	public int noticeActOff(NoticeVO nvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int noticeOff = sqlSession.update("notice.noticeActOff",nvo);
		sqlSession.commit();
		sqlSession.close();
		return noticeOff;
	}

	@Override
	public int noticeWrite(NoticeVO nvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int noticeWrite = sqlSession.insert("notice.noticeWrite",nvo);
		sqlSession.commit();
		sqlSession.close();
		return noticeWrite;
	}

	
}
