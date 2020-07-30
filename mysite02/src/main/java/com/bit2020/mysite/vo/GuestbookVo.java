package com.bit2020.mysite.vo;


public class GuestbookVo {
	private long no;
	private String Name;
	private String Password;
	private String Message;
	private String RegDate;
	
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getRegDate() {
		return RegDate;
	}
	public void setRegDate(String regDate) {
		RegDate = regDate;
	}
	@Override
	public String toString() {
		return "GuestbookVo [no=" + no + ", Name=" + Name + ", Password=" + Password + ", Message=" + Message
				+ ", RegDate=" + RegDate + "]";
	}
	
	
}
