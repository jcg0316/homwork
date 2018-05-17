package kr.or.ddit.notice.model;

public class NoticeVO {
	private Integer notice_seq;
	private String notice_name;
	private String notice_reg_dt;
	private String notice_act;
	private String notice_mem_id;
	
	public NoticeVO() {
		super();
	}

	public NoticeVO(Integer notice_seq, String notice_name,
			String notice_reg_dt, String notice_act, String notice_mem_id) {
		super();
		this.notice_seq = notice_seq;
		this.notice_name = notice_name;
		this.notice_reg_dt = notice_reg_dt;
		this.notice_act = notice_act;
		this.notice_mem_id = notice_mem_id;
	}

	public Integer getNotice_seq() {
		return notice_seq;
	}

	public void setNotice_seq(Integer notice_seq) {
		this.notice_seq = notice_seq;
	}

	public String getNotice_name() {
		return notice_name;
	}

	public void setNotice_name(String notice_name) {
		this.notice_name = notice_name;
	}

	public String getNotice_reg_dt() {
		return notice_reg_dt;
	}

	public void setNotice_reg_dt(String notice_reg_dt) {
		this.notice_reg_dt = notice_reg_dt;
	}

	public String getNotice_act() {
		return notice_act;
	}

	public void setNotice_act(String notice_act) {
		this.notice_act = notice_act;
	}

	public String getNotice_mem_id() {
		return notice_mem_id;
	}

	public void setNotice_mem_id(String notice_mem_id) {
		this.notice_mem_id = notice_mem_id;
	}
	
	
	
	
}
