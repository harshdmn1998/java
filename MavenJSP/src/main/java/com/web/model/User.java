package com.web.model;

public class User {

	private int uid;
	private String uname;
	private String tech;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", tech=" + tech + "]";
	}
	
	
}
