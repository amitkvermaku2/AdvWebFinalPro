package com.uab.sauth;

public class SUserValue {
	
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

	public SUserValue(Long uname, String upassword) {
		super();
		this.uname = uname;
		this.upassword = upassword;
	}

	public SUserValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserValue [uname=" + uname + ", upassword=" + upassword + "]";
	}
	
	

}
