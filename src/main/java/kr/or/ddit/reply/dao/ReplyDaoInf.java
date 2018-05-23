package kr.or.ddit.reply.dao;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVO;

public interface ReplyDaoInf {
	
	/**
	 * 
	* Method : getReplyList
	* 최초작성일 : 2018. 5. 19.
	* 작성자 : J.C.G
	* 변경이력 :
	* @return
	* Method 설명 :
	 */
	public List<ReplyVO> getReplyList(ReplyVO rvo);
	
	/**
	 * 
	* Method : boardWrite
	* 최초작성일 : 2018. 5. 19.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param bvo
	* @return
	* Method 설명 : 댓글 쓰기
	 */
	public int replyWrite(ReplyVO rvo);
	
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
	public int replyDelete(ReplyVO rvo);
	
	
}
