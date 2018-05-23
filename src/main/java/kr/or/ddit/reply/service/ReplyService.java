package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoInf;
import kr.or.ddit.reply.model.ReplyVO;

public class ReplyService implements ReplyServiceInf{
	
	ReplyDaoInf rdao;
	
	public ReplyService(){
		rdao = new ReplyDao();
	}

	@Override
	public int replyWrite(ReplyVO rvo) {
		return rdao.replyWrite(rvo);
	}

	@Override
	public int replyDelete(ReplyVO rvo) {
		return rdao.replyDelete(rvo);
	}

	@Override
	public List<ReplyVO> getReplyList(ReplyVO rvo) {
		return rdao.getReplyList(rvo);
	}
}
