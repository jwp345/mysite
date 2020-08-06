package com.bit2020.mysite.vo;

public class BoardVo {
	private long no;
	private String Title;
	private String Content;
	private long Hit;
	private String RegDate;
	private long UserNo;
	private String Name;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public long getHit() {
		return Hit;
	}
	public void setHit(long hit) {
		Hit = hit;
	}
	public String getRegDate() {
		return RegDate;
	}
	public void setRegDate(String regDate) {
		RegDate = regDate;
	}
	public long getUserNo() {
		return UserNo;
	}
	public void setUserNo(long userNo) {
		UserNo = userNo;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", Title=" + Title + ", Content=" + Content + ", Hit=" + Hit + ", RegDate="
				+ RegDate + ", UserNo=" + UserNo + ", Name=" + Name + "]";
	}
	

}
