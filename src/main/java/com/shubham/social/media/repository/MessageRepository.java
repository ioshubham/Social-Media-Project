package com.shubham.social.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.social.media.models.Messages;

public interface MessageRepository extends JpaRepository<Messages, Integer>{
	
	public List<Messages> findByChatId(int chatId);

}
