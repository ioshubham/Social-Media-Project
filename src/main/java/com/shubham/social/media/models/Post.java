package com.shubham.social.media.models;


public class Post {
	
	private int postId;
	private String FirstName;
	private String username;
	private String timeStamp;
	private String Location;
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(int postId, String firstName, String username, String timeStamp, String location) {
		super();
		this.postId = postId;
		FirstName = firstName;
		this.username = username;
		this.timeStamp = timeStamp;
		Location = location;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}


	
	
	

}
