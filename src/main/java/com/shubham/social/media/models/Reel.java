package com.shubham.social.media.models;

public class Reel {
	
	
	private String username;
	private String createdAt;

	public Reel() {
		// TODO Auto-generated constructor stub
	}

	public Reel(String username, String createdAt) {
		super();
		this.username = username;
		this.createdAt = createdAt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
