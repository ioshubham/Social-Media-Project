package com.shubham.social.media.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.models.Message;

@RestController
public class MessageController {
	
	@GetMapping("/message")
	public List<Message> messageControllerHandeler() {
		
		List<Message> messages = new ArrayList<>();
		
		Message m1 = new Message("Shubham","Bunyy","Hello bunny");
		Message m2 = new Message("Bunyy","Shubham","Hello Shubham");
		
		messages.add(m1);
		messages.add(m2);
		
		return messages;
	}
	

}
