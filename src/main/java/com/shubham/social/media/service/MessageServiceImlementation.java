package com.shubham.social.media.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.social.media.models.Chat;
import com.shubham.social.media.models.Messages;
import com.shubham.social.media.models.User;
import com.shubham.social.media.repository.ChatRepository;
import com.shubham.social.media.repository.MessageRepository;

@Service
public class MessageServiceImlementation implements MessageService {
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private ChatRepository chatRepository;

	@Override
	public Messages createMessages(User user, int chatId, Messages msg) throws Exception {
		
		Messages newMessage = new Messages();
		
		Chat chat = chatService.findChatById(chatId);
		
		newMessage.setChat(chat);
		newMessage.setContent(msg.getContent());
		newMessage.setImage(msg.getImage());
		newMessage.setUser(user);
		newMessage.setTimeStamp(LocalDateTime.now());
		
		Messages savedMessage = messageRepository.save(newMessage);
		chat.getMessage().add(savedMessage);
		chatRepository.save(chat);
		
		return savedMessage;
	}

	@Override
	public List<Messages> findChatsMessages(int chatId) throws Exception {
		
		Chat chat = chatService.findChatById(chatId);
		
		return messageRepository.findByChatId(chatId);
	}

}
