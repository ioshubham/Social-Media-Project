package com.shubham.social.media.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Chat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String chatName; // will be replaced with username in frontend
	
	private String chatImage; // replace with user image
	
	@ManyToMany
	private List<User> users = new ArrayList<>();
	
	private LocalDateTime timeStamp;
	
	@OneToMany(mappedBy="chat")
	private List<Messages> message = new ArrayList<>();
	
	public Chat() {
		// TODO Auto-generated constructor stub
	}

	public Chat(int id, String chatName, String chatImage, List<User> users, LocalDateTime timeStamp,
			List<Messages> message) {
		super();
		this.id = id;
		this.chatName = chatName;
		this.chatImage = chatImage;
		this.users = users;
		this.timeStamp = timeStamp;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChatName() {
		return chatName;
	}

	public void setChatName(String chatName) {
		this.chatName = chatName;
	}

	public String getChatImage() {
		return chatImage;
	}

	public void setChatImage(String chatImage) {
		this.chatImage = chatImage;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public List<Messages> getMessage() {
		return message;
	}

	public void setMessage(List<Messages> message) {
		this.message = message;
	}
	


}
