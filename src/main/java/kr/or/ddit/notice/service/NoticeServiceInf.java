package kr.or.ddit.notice.service;

import java.util.List;

import kr.or.ddit.notice.model.NoticeVO;

public interface NoticeServiceInf {
	
	/**
	 * 
	* Method : getNoticeList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : J.C.G
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 리스트 조회
	 */
	public List<NoticeVO> getNoticeList();
	
	/**
	 * 
	* Method : getNoticeList
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : J.C.G
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 리스트 레이아웃 조회
	 */
	public List<NoticeVO> getNoticeListLayout();
	
	/**
	 * 
	* Method : noticeActOn
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param nvo
	* @return
	* Method 설명 : 게시판 활성화
	 */
	public int noticeActOn(NoticeVO nvo);
	
	/**
	 * 
	 * Method : noticeActOn
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : J.C.G
	 * 변경이력 :
	 * @param nvo
	 * @return
	 * Method 설명 : 게시판 비활성화
	 */
	public int noticeActOff(NoticeVO nvo);
	
	/**
	 * 
	* Method : noticeWrite
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param nvo
	* @return
	* Method 설명 : 게시판 카테고리 추가
	 */
	public int noticeWrite(NoticeVO nvo);
}
