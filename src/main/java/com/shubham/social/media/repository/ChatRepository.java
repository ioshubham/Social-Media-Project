package com.shubham.social.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shubham.social.media.models.Chat;
import com.shubham.social.media.models.User;

public interface ChatRepository extends JpaRepository<Chat,Integer> {
	
	public List<Chat> findByUsersId(int userId);
	
	@Query("select c from Chat c where :user Member of c.users And reqUser Member of c.users")
	public Chat findChatByUserId(@Param("user") User user, @Param("reqUser") User reqUser);

}
