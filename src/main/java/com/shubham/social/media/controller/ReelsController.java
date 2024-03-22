 package com.shubham.social.media.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.models.Reel;
import com.shubham.social.media.models.User;
import com.shubham.social.media.service.ReelsService;
import com.shubham.social.media.service.UserService;

@RestController
public class ReelsController {
	
	@Autowired
	private ReelsService reelService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/api/reel")
	public Reel createReal(@RequestBody Reel reel,@RequestHeader("Authorization") String jwt) {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		Reel createReel = reelService.createReel(reel, reqUser);
		
		return createReel;
		
	}
	
	@GetMapping("/api/reel")
	public List<Reel> findAllReal() {
		
		List<Reel> reels = reelService.findAllReels();
		
		return reels;
		
	}
	
	@GetMapping("/api/reel/user/{userId}")
	public List<Reel> findAllReal(@PathVariable int userId) throws Exception {
		
		List<Reel> reels = reelService.findUsersReel(userId);
		
		return reels;
		
	}
	
	
}
