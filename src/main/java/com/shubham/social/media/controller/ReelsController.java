 package com.shubham.social.media.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.models.Reel;

@RestController
public class ReelsController {
	
	@GetMapping("/reel")
	public List<Reel> reelControler() {
		
		List<Reel> reels = new ArrayList<>();
		
		Reel r1 = new Reel("Shubham","10-03-2024");
		Reel r2 = new Reel("Bynny","10-03-2024");
		
		reels.add(r1);
		reels.add(r2);
		return reels;
	}

}
