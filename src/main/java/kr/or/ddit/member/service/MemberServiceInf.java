package kr.or.ddit.member.service;

import kr.or.ddit.member.model.MemberVO;

public interface MemberServiceInf {
	
	/**
	 * 
	* Method : getLogData
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : J.C.G
	* 변경이력 :
	* @return
	* Method 설명 : 로그인에 필요한 아이디,비밀번호 얻어오는 메소드 
	 */
	public MemberVO getLogData(MemberVO mvo);
}
