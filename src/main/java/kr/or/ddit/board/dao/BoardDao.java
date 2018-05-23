package kr.or.ddit.board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.board.model.BoardVO;

public class BoardDao implements BoardDaoInf {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public BoardDao(){
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
	public List<BoardVO> getBoardPageList(int category_seq, int page, int pageSize) {
		Map<String,Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("category_seq",category_seq);
		paramMap.put("page",page);
		paramMap.put("pageSize",pageSize);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardVO> boardList = sqlSession.selectList("board.getBoardPageList",paramMap);
		sqlSession.close();
		return boardList;
	}

	@Override
	public int getBoardTotalCnt(int getBoardTotalCnt) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int boardTotalCnt = sqlSession.selectOne("board.getBoardTotalCnt", getBoardTotalCnt);
		sqlSession.close();
		return boardTotalCnt;
	}
	
	/**
	 * 
	* Method : getBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 게시판 글 조회
	 */
	@Override
	public BoardVO getBoard(int board_seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardVO getBoard = sqlSession.selectOne("board.getBoard",board_seq);
		sqlSession.close();
		return getBoard;
	}
	
	/**
	 * 
	* Method : boardWrite
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param bvo
	* @return
	* Method 설명 : 게시판 글 작성
	 */
	@Override
	public int boardWrite(BoardVO bvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int boardWrite = sqlSession.insert("board.boardWrite",bvo);
		sqlSession.commit();
		sqlSession.close();
		return boardWrite;
	}
	
	/**
	 * 
	* Method : boardModify
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param bvo
	* @return
	* Method 설명 : 게시판 글 수정
	 */
	@Override
	public int boardModify(BoardVO bvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int boardModify = sqlSession.update("board.boardModify",bvo);
		sqlSession.commit();
		sqlSession.close();
		return boardModify;
	}
	
	/**
	 * 
	* Method : boardDelete
	* 최초작성일 : 2018. 5. 18.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param bvo
	* @return
	* Method 설명 : 게시판 글 삭제
	 */
	@Override
	public int boardDelete(BoardVO bvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int boardDelete = sqlSession.update("board.boardDelete",bvo);
		sqlSession.commit();
		sqlSession.close();
		return boardDelete;
	}
	
	/**
	 * 
	* Method : boardReWrite
	* 최초작성일 : 2018. 5. 19.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param bvo
	* @return
	* Method 설명 : 답글 입력
	 */
	@Override
	public int boardReWrite(BoardVO bvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int boardReWrite = sqlSession.insert("board.boardReWrite",bvo);
		sqlSession.commit();
		sqlSession.close();
		return boardReWrite;
	}


	
}
