package com.shubham.social.media.service;

import java.util.List;

import com.shubham.social.media.models.Story;
import com.shubham.social.media.models.User;

public interface StoryService {
	
	public Story createStory(Story story ,User user);
	
	public List<Story> findStoryByUserId(int userId) throws Exception;

}
