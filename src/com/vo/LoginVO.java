package com.vo;

public class LoginVO {
	private String id;
	private String pw;
	private String name;
	private String email;
	
	public LoginVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginVO(String id, String pw, String name, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}

	public LoginVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
