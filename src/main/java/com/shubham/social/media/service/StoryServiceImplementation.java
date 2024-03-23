package com.shubham.social.media.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.social.media.models.Story;
import com.shubham.social.media.models.User;
import com.shubham.social.media.repository.StoryRepository;

@Service
public class StoryServiceImplementation implements StoryService {

	@Autowired
	StoryRepository storyRepository;
	
	@Autowired
	UserService userService;
	
	@Override
	public Story createStory(Story story, User user) {
		
		Story newStory = new Story();
		
		newStory.setCaption(story.getCaption());
		newStory.setCreateAt(LocalDateTime.now());
		newStory.setImage(story.getImage());
		newStory.setUser(user);
		
		
		return storyRepository.save(newStory);
	}

	@Override
	public List<Story> findStoryByUserId(int userId) throws Exception {
		
		User user = userService.findUserById(userId);
		
		return storyRepository.findByUserId(userId);
	}

}
