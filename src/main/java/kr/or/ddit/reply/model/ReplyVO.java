package kr.or.ddit.reply.model;

public class ReplyVO {
	private int reply_seq;
	private int reply_board_seq;
	private String reply_content;
	private String reply_reg_dt;
	private String reply_del_yn;
	private String reply_mem_id;
	
	public ReplyVO() {
		super();
	}

	public ReplyVO(int reply_seq, int reply_board_seq, String reply_content,
			String reply_reg_dt, String reply_del_yn, String reply_mem_id) {
		super();
		this.reply_seq = reply_seq;
		this.reply_board_seq = reply_board_seq;
		this.reply_content = reply_content;
		this.reply_reg_dt = reply_reg_dt;
		this.reply_del_yn = reply_del_yn;
		this.reply_mem_id = reply_mem_id;
	}

	public int getReply_seq() {
		return reply_seq;
	}

	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}

	public int getReply_board_seq() {
		return reply_board_seq;
	}

	public void setReply_board_seq(int reply_board_seq) {
		this.reply_board_seq = reply_board_seq;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public String getReply_reg_dt() {
		return reply_reg_dt;
	}

	public void setReply_reg_dt(String reply_reg_dt) {
		this.reply_reg_dt = reply_reg_dt;
	}

	public String getReply_del_yn() {
		return reply_del_yn;
	}

	public void setReply_del_yn(String reply_del_yn) {
		this.reply_del_yn = reply_del_yn;
	}

	public String getReply_mem_id() {
		return reply_mem_id;
	}

	public void setReply_mem_id(String reply_mem_id) {
		this.reply_mem_id = reply_mem_id;
	}

	@Override
	public String toString() {
		return "ReplyVO [reply_seq=" + reply_seq + ", reply_board_seq="
				+ reply_board_seq + ", reply_content=" + reply_content
				+ ", reply_reg_dt=" + reply_reg_dt + ", reply_del_yn="
				+ reply_del_yn + ", reply_mem_id=" + reply_mem_id + "\n<br>]";
	}
	
	
	
	
}
