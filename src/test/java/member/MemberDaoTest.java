package member;

import static org.junit.Assert.*;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;

import org.junit.Before;
import org.junit.Test;

public class MemberDaoTest {

	@Test
	public void getLogDatatest() {
		/***Given***/
		MemberDaoInf memdao = new MemberDao();
		
		MemberVO mvo = new MemberVO();
		mvo.setMem_id("b001");
		mvo.setMem_pass("1004");
		
		/***When***/
		MemberVO result = memdao.getLogData(mvo);
		
		/***Then***/
		assertEquals("b001", result.getMem_id());
	}

}
