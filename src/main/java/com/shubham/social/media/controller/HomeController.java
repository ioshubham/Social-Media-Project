package com.shubham.social.media.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // help spring to tell this is endpoint class
public class HomeController {
	
	@GetMapping
	public String homeControllerHandeler() {
		return "this is home controller";
	}
	
	@GetMapping("/home")
	public String homeControllerHandeler2() {
		return "this is home controller 2";
	}
	
	
//	@PutMapping
//	@PostMapping
//	@DeleteMapping

}
