package com.sds.board.vo;

public class BoardVO {
	private int seq, cnt;
	private String title, nickname, content, reg_date, userID;
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVO(int seq, int cnt, String title, String nickname,
			String content, String reg_date, String userID) {
		super();
		this.seq = seq;
		this.cnt = cnt;
		this.title = title;
		this.nickname = nickname;
		this.content = content;
		this.reg_date = reg_date;
		this.userID = userID;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", cnt=" + cnt + ", title=" + title
				+ ", nickname=" + nickname + ", content=" + content
				+ ", reg_date=" + reg_date + ", userID=" + userID + "]";
	}
	
	

}
