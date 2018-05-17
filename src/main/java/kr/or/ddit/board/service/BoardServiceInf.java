package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVO;


public interface BoardServiceInf {
	
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
	public Map<String, Object> getBoardPageList(int category_seq, int page, int pageSize);
	
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
}
