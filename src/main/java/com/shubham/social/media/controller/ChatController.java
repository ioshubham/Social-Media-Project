package com.shubham.social.media.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.models.Chat;
import com.shubham.social.media.models.User;
import com.shubham.social.media.request.ChatRequest;
import com.shubham.social.media.service.ChatService;
import com.shubham.social.media.service.UserService;

@RestController
public class ChatController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ChatService chatService;
	
	@PostMapping("/api/chat")
	public Chat createChat(@RequestBody ChatRequest req,@RequestHeader("Authorization") String jwt) throws Exception {
		
		User reqUser = userService.findUserByJwt(jwt);
		User user2 = userService.findUserById(req.getUserId());
		Chat chat =chatService.createChat(reqUser,user2);
		
		return chat;
	}

	@GetMapping("/api/chat")
	public List<Chat> findUserChat(@RequestHeader("Authorization") String jwt) {
		
		User user = userService.findUserByJwt(jwt);
		
		List<Chat> chat =chatService.findUsersChat(user.getId());
		
		return chat;
	}

}
