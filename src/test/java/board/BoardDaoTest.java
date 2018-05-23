package board;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVO;

import org.junit.Test;


public class BoardDaoTest {
	
	@Test
	public void boardWriteTest() {
	/***Given***/
	BoardDaoInf dao = new BoardDao();
	String title = "제목";
	String content ="내용";
	String mem_id = "아이디";
	
	BoardVO bvo = new BoardVO();
	bvo.setBoard_title(title);
	bvo.setBoard_content(content);
	bvo.setBoard_mem_id(mem_id);
	
	/***When***/
	int cnt = dao.boardWrite(bvo);
	/***Then***/
	assertNotNull(cnt);
	assertEquals(1,cnt);
	}
}
