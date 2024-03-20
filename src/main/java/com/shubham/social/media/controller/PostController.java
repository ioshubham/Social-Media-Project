package com.shubham.social.media.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.models.Post;
import com.shubham.social.media.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("/posts/users/{userId}")
	public ResponseEntity<Post> createPost(@RequestBody Post post , @PathVariable int userId) throws Exception {
		
		Post createdPost = postService.createNewPost(post, userId);
		
		return new ResponseEntity<>(createdPost,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/posts/{postId}/user/{userId}")
	public ResponseEntity<String> deletePost(@PathVariable int postId ,@PathVariable int userId) throws Exception {
		
		String message = postService.deletePost(postId, userId);
		
		return null;
		
	}

}
