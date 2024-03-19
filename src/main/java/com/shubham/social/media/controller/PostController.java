package com.shubham.social.media.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.models.Post;

@RestController
public class PostController {
	
	@GetMapping("/posts")
	public List<Post> getUserPostHandeler() {
		
		List<Post> posts = new ArrayList<>();
		
		Post post1 = new Post(1,"Shubham","@shubham","18-3-2024","Uttarakhand");
		Post post2 = new Post(2,"Bunny","@bunnu","18-3-2024","Navi");
		posts.add(post1);
		posts.add(post2);
		
		return posts;
	}
	
	@GetMapping("/posts/{postId}")
	public Post getUserPostbyId(@PathVariable("postId") int id) {
		
		Post post1 = new Post(1,"Shubham","@shubham","18-3-2024","Uttarakhand");
		post1.setPostId(id);
		
		return post1;
	}
	
	@PostMapping("/posts")
	public Post createPost(@RequestBody Post post) {
		
		Post newpost = new Post();
		
		newpost.setFirstName(post.getFirstName());
		newpost.setLocation(post.getLocation());
		newpost.setPostId(post.getPostId());
		newpost.setTimeStamp(post.getTimeStamp());
		newpost.setUsername(post.getUsername());

		return newpost;
	}
	
	@PutMapping("/posts")
	public Post updatePost(@RequestBody Post post) {
		
		Post post1 = new Post(1,"Shubham","@shubham","18-3-2024","Uttarakhand");
		
		if(post.getFirstName()!=null) {
			post1.setFirstName(post.getFirstName());
		}
		if(post.getLocation()!=null) {
			post1.setLocation(post.getLocation());
		}
		if(post.getUsername()!=null) {
			post1.setUsername(post.getUsername());
		}
		
		return post1;
		
	}
	
	@DeleteMapping("/posts/{postId}")
	public String deletePost(@PathVariable("postId") int id) {
		
		return "post deleted with id "+id;
	}
	
	
	

}
