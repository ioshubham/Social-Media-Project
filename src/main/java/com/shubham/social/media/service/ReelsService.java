package com.shubham.social.media.service;

import java.util.List;

import com.shubham.social.media.models.Reel;
import com.shubham.social.media.models.User;

public interface ReelsService {
	
	public Reel createReel(Reel reel ,User user);
	
	public List<Reel> findAllReels();
	
	public List<Reel> findUsersReel(Integer userId) throws Exception;

}
