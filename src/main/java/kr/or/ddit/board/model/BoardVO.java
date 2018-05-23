package kr.or.ddit.board.model;

public class BoardVO {
	private int board_seq;
	private int pboard_seq;
	private int category_seq;
	private int group_seq;
	private int level;
	private String board_title;
	private String board_content;
	private String board_reg_dt;
	private String board_del_yn;
	private String board_mem_id;
	
	public BoardVO() {
		super();
	}

	public BoardVO(int board_seq, int pboard_seq, int category_seq,
			int group_seq, String board_title, String board_content,
			String board_reg_dt, String board_del_yn, String board_mem_id, int level) {
			super();
			this.board_seq = board_seq;
			this.pboard_seq = pboard_seq;
			this.category_seq = category_seq;
			this.group_seq = group_seq;
			this.level = level;
			this.board_title = board_title;
			this.board_content = board_content;
			this.board_reg_dt = board_reg_dt;
			this.board_del_yn = board_del_yn;
			this.board_mem_id = board_mem_id;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public int getPboard_seq() {
		return pboard_seq;
	}

	public void setPboard_seq(int pboard_seq) {
		this.pboard_seq = pboard_seq;
	}

	public int getCategory_seq() {
		return category_seq;
	}

	public void setCategory_seq(int category_seq) {
		this.category_seq = category_seq;
	}

	public int getGroup_seq() {
		return group_seq;
	}

	public void setGroup_seq(int group_seq) {
		this.group_seq = group_seq;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_reg_dt() {
		return board_reg_dt;
	}

	public void setBoard_reg_dt(String board_reg_dt) {
		this.board_reg_dt = board_reg_dt;
	}

	public String getBoard_del_yn() {
		return board_del_yn;
	}

	public void setBoard_del_yn(String board_del_yn) {
		this.board_del_yn = board_del_yn;
	}

	public String getBoard_mem_id() {
		return board_mem_id;
	}

	public void setBoard_mem_id(String board_mem_id) {
		this.board_mem_id = board_mem_id;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "BoardVO [level="+level+"board_seq=" + board_seq + ", pboard_seq=" + pboard_seq
				+ ", category_seq=" + category_seq + ", group_seq=" + group_seq
				+ ", board_title=" + board_title + ", board_content="
				+ board_content + ", board_reg_dt=" + board_reg_dt
				+ ", board_del_yn=" + board_del_yn + ", board_mem_id="
				+ board_mem_id + "]\n";
	}
	
	

	
}
