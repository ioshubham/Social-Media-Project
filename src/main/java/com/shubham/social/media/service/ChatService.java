package com.shubham.social.media.service;

import java.util.List;

import com.shubham.social.media.models.Chat;
import com.shubham.social.media.models.User;

public interface ChatService {
	
	public Chat createChat(User reqUser , User user2);
	
	public Chat findChatById(int chatId) throws Exception;
	
	public List<Chat> findUsersChat(Integer userId);

}
