package com.shubham.social.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.social.media.models.Story;

public interface StoryRepository extends JpaRepository<Story, Integer>{
	
	public List<Story> findByUserId(int userId);

}