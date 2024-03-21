package com.shubham.social.media.request;

public class LoginRequst {
	
	private String email;
	private String password;
	
	public LoginRequst() {
		// TODO Auto-generated constructor stub
	}

	public LoginRequst(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
