package com.shubham.social.media.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.models.Messages;
import com.shubham.social.media.models.User;
import com.shubham.social.media.service.MessageService;
import com.shubham.social.media.service.UserService;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/messages/chat/{chatId}")
	public Messages createMessage(@RequestBody Messages req,@RequestHeader("Authorization") String jwt,@PathVariable int chatId) throws Exception {
		
		User user = userService.findUserByJwt(jwt);
		
		Messages message = messageService.createMessages(user, chatId , req);
		
		
		return message;
	}
	
	@GetMapping("/api/messages/chat/{chatId}")
	public List<Messages> findChatMessage(@RequestHeader("Authorization") String jwt,@PathVariable int chatId) throws Exception {
		
		User user = userService.findUserByJwt(jwt);
		
		List<Messages> message = messageService.findChatsMessages(chatId);
		
		return message;
	}
	
	
}
