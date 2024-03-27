package com.shubham.social.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.social.media.models.Chat;

public interface ChatRepository extends JpaRepository<Chat,Integer> {
	
	public List<Chat> findByUsersId(int userId);

}
