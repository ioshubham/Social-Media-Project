package com.shubham.social.media.models;

public class Message {
	
	private String username1;
	private String username2;
	
	private String messageBody;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(String username1, String username2, String messageBody) {
		super();
		this.username1 = username1;
		this.username2 = username2;
		this.messageBody = messageBody;
	}

	public String getUsername1() {
		return username1;
	}

	public void setUsername1(String username1) {
		this.username1 = username1;
	}

	public String getUsername2() {
		return username2;
	}

	public void setUsername2(String username2) {
		this.username2 = username2;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	

}
