package com.shubham.social.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shubham.social.media.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	@Query("select p from Post p where p.userId=:userId")
	List<Post> findPostByUserId(int userId);

}
