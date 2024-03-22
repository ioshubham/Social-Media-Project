package com.shubham.social.media.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.social.media.models.Reel;
import com.shubham.social.media.models.User;
import com.shubham.social.media.repository.ReelsRepository;

@Service
public class ReelsServiceImplementation implements ReelsService {
	
	@Autowired
	ReelsRepository reelRepository;
	
	@Autowired
	UserService userService;

	@Override
	public Reel createReel(Reel reel, User user) {
		Reel createReel = new Reel();
		
		createReel.setTitle(reel.getTitle());
		createReel.setUser(user);
		createReel.setVideo(reel.getVideo());
		createReel.setCreatedAt(LocalDateTime.now());
		
		
		
		return reelRepository.save(createReel);
	}

	@Override
	public List<Reel> findAllReels() {
		
		return reelRepository.findAll();
	}

	@Override
	public List<Reel> findUsersReel(Integer userId) throws Exception {
		
		userService.findUserById(userId);
		return reelRepository.findByUserId(userId);
	}
	
	

}
