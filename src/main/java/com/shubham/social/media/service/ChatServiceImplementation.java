package com.shubham.social.media.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.social.media.models.Chat;
import com.shubham.social.media.models.User;
import com.shubham.social.media.repository.ChatRepository;

@Service
public class ChatServiceImplementation implements ChatService {
	
	@Autowired
	ChatRepository chatRepository;

	@Override
	public Chat createChat(User reqUser, User user2) {
		
		Chat isExist = chatRepository.findChatByUserId(user2, reqUser);
		
		if(isExist !=null) {
			return isExist;
		}
		
		Chat chat = new Chat();
		chat.getUsers().add(user2);
		chat.getUsers().add(reqUser);
		chat.setTimeStamp(LocalDateTime.now());
		
		
		return chatRepository.save(chat);
	}

	@Override
	public Chat findChatById(int chatId) throws Exception {
		
		Optional<Chat> chat = chatRepository.findById(chatId);
		
		if(chat.isEmpty()) {
			throw new Exception("Chat not found with id-"+chatId);
		}
		
		return chat.get();
	}

	@Override
	public List<Chat> findUsersChat(Integer userId) {
		
		return  chatRepository.findByUsersId(userId);
	}

}
