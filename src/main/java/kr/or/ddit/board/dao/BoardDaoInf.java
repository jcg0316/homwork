package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVO;

public interface BoardDaoInf {
	
	/**
	 * 
	* Method : getUserPageList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param page
	* @param pageSize
	* @return
	* Method 설명 : 게시판 페이지 list 조회
	 */
	public List<BoardVO> getBoardPageList(int category_seq,int page, int pageSize);
	
	/**
	 * 
	* Method : getUserTotalCnt
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : J.C.G
	* 변경이력 :
	* @return
	* Method 설명 : 전체 게시판 건수 조회
	 */
	public int getBoardTotalCnt(int getBoardTotalCnt);
	
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
	public BoardVO getBoard(int board_seq);
	
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
	public int boardWrite(BoardVO bvo);
	
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
	public int boardModify(BoardVO bvo);
	
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
	public int boardDelete(BoardVO bvo);
	
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
	public int boardReWrite(BoardVO bvo);
}
