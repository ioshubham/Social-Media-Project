package com.shubham.social.media.models;

public class Story {
	
	private String username;
	private String createAt;
	
	public Story() {
		// TODO Auto-generated constructor stub
	}

	public Story(String username, String createAt) {
		super();
		this.username = username;
		this.createAt = createAt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	
	

}
