package com.shubham.social.media.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.models.Story;

@RestController
public class StoryController {
	
	@GetMapping("/story")
	public List<Story> storyHandeler() {
		List<Story> stories = new ArrayList<>();
		
		Story s1 = new Story("Shubham","18-03-2024");
		Story s2 = new Story("Bunny","18-03-2024");
		
		stories.add(s1);
		stories.add(s2);
		
		return stories;
	}

}
