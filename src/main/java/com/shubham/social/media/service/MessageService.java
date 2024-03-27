package com.shubham.social.media.service;

import java.util.List;

import com.shubham.social.media.models.Messages;
import com.shubham.social.media.models.User;

public interface MessageService {
	
	public Messages createMessages(User user,int chatId,Messages msg) throws Exception;
	
	public List<Messages> findChatsMessages(int chatId) throws Exception;

}
