package com.shubham.social.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.social.media.models.Reel;

public interface ReelsRepository extends JpaRepository<Reel, Integer> {
	
	public List<Reel> findByUserId(int userId);

}
