package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVO;


public class BoardService implements BoardServiceInf {
	
	BoardDaoInf bdao;
	
	public BoardService(){
		bdao = new BoardDao();
	}

	/**
	 * 
	* Method : getUserPageList
	* 최초작성일 : 2018. 5. 4.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param page
	* @param pageSize
	* @return
	* Method 설명 : 회원 페이지 list 조회
	 */
	@Override
	public Map<String, Object> getBoardPageList(int category_seq, int page, int pageSize) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		List<BoardVO> boardList = bdao.getBoardPageList(category_seq, page, pageSize);
		int boardTotalCnt = bdao.getBoardTotalCnt(category_seq);
		
		String pageNav = makePageNav(category_seq,page,bdao.getBoardTotalCnt(category_seq));
		
		resultMap.put("boardList",boardList);
		resultMap.put("pageNav", pageNav);
		
		return resultMap;
	}
	
	/**
	 * 
	* Method : makePageNav
	* 최초작성일 : 2018. 5. 4.
	* 작성자 : J.C.G
	* 변경이력 :
	* @param userTotalCnt
	* Method 설명 : 페이지 네비게이션 생성
	 */
	private String makePageNav(int category_seq, int page, int boardTotalCnt) {
		
		int pageTotalCnt = (int)Math.ceil((double)boardTotalCnt /10);
		
		int prePage = (page-1>0)?page-1:1;
		int nextPage = (page+1<pageTotalCnt)?page+1:pageTotalCnt;
		
		StringBuffer pageNav = new StringBuffer();
		pageNav.append("<nav>");
		pageNav.append("<ul class=\"pagination\">");
		pageNav.append("<li>");
		pageNav.append("<a href=\"boardList?page=1&pageSize=10&category_seq="+category_seq+"\" aria-label=\"GoTOFirst\">");
		pageNav.append("<span aria-hidden=\"true\">&laquo;</span>");
		pageNav.append("</a>");
		if(page <= 1){
			pageNav.append("<a href=\"#\" aria-label=\"Previous\">");
		}else{
			pageNav.append("<a href=\"boardList?page="+prePage+"&pageSize=10&category_seq="+category_seq+"\" aria-label=\"Previous\">");
		}
		pageNav.append("<span aria-hidden=\"true\">&lt;</span>");
		pageNav.append("</a>");
		pageNav.append("</li>");
		
		//pageToTalCnt
		for(int i=1; i<=pageTotalCnt; i++){
			if( i == page){
				pageNav.append("<li class=\"active\"><a href=\"boardList?page="+ i +"&pageSize=10&category_seq="+category_seq+"\">"+ i +"</a></li>");
			}else{
				pageNav.append("<li><a href=\"boardList?page="+ i +"&pageSize=10&category_seq="+category_seq+"\">"+ i +"</a></li>");				
			}
		}
		
		pageNav.append("<li>");
		if(page >= pageTotalCnt){
			pageNav.append("<a href=\"#\" aria-label=\"Next\">");
		}else{
			pageNav.append("<a href=\"boardList?page="+nextPage+"&pageSize=10&category_seq="+category_seq+"\" aria-label=\"Next\">");
			
		}
		pageNav.append("<span aria-hidden=\"true\">&gt;</span>");
		pageNav.append("</a>");
		pageNav.append("<a href=\"boardList?page="+pageTotalCnt+"&pageSize=10&category_seq="+category_seq+"\" aria-label=\"GoTOLast\">");
		pageNav.append("<span aria-hidden=\"true\">&raquo;</span>");
		pageNav.append("</a>");
		pageNav.append("</li>");
		pageNav.append("</ul>");
		pageNav.append("</nav>");
		      
		return pageNav.toString();	
	}

	@Override
	public BoardVO getBoard(int board_seq) {
		return bdao.getBoard(board_seq);
	}

	@Override
	public int boardWrite(BoardVO bvo) {
		return bdao.boardWrite(bvo);
	}

	@Override
	public int boardModify(BoardVO bvo) {
		return bdao.boardModify(bvo);
	}

	@Override
	public int boardDelete(BoardVO bvo) {
		return bdao.boardDelete(bvo);
	}

	@Override
	public int boardReWrite(BoardVO bvo) {
		return bdao.boardReWrite(bvo);
	}

	
}
