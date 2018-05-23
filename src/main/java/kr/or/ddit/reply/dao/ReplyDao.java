package kr.or.ddit.reply.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.reply.model.ReplyVO;

public class ReplyDao implements ReplyDaoInf {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public ReplyDao(){
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	* Method : getReplyList
	* 최초작성일 : 2018. 5. 19.
	* 작성자 : J.C.G
	* 변경이력 :
	* @return
	* Method 설명 : 댓글 조회
	 */
	@Override
	public List<ReplyVO> getReplyList(ReplyVO rvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ReplyVO> getReplyList = sqlSession.selectList("reply.getReplyList", rvo);
		sqlSession.close();
		return getReplyList;
	}
	
	/**
	 * 
	* Method : replyWrite
	* 최초작성일 : 2018. 5. 19.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param rvo
	* @return
	* Method 설명 : 댓글 쓰기
	 */
	@Override
	public int replyWrite(ReplyVO rvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int boardWrite = sqlSession.insert("reply.replyWrite",rvo);
		sqlSession.commit();
		sqlSession.close();
		return boardWrite;
	}
	
	/**
	 * 
	* Method : replyDelete
	* 최초작성일 : 2018. 5. 19.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param rvo
	* @return
	* Method 설명 : 댓글 삭제
	 */
	@Override
	public int replyDelete(ReplyVO rvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int boardWrite = sqlSession.update("reply.replyDelete",rvo);
		sqlSession.commit();
		sqlSession.close();
		return boardWrite;
	}


}
