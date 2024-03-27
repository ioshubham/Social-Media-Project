package com.shubham.social.media.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Messages {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String content;
	private String image;
	
	@ManyToOne
	private User user;
	
	private LocalDateTime timeStamp;
	
	@JsonIgnore
	@ManyToOne
	private Chat chat;
	
	public Messages() {
		// TODO Auto-generated constructor stub
	}

	public Messages(int id, String content, String image, User user, LocalDateTime timeStamp, Chat chat) {
		super();
		this.id = id;
		this.content = content;
		this.image = image;
		this.user = user;
		this.timeStamp = timeStamp;
		this.chat = chat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}
	
	

}
