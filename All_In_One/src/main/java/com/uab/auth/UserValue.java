package com.uab.auth;

public class UserValue {
	
	private Long uname;
	
	private String upassword;

	public Long getUname() {
		return uname;
	}

	public void setUname(Long uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public UserValue(Long uname, String upassword) {
		super();
		this.uname = uname;
		this.upassword = upassword;
	}

	public UserValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserValue [uname=" + uname + ", upassword=" + upassword + "]";
	}
	
	

}
