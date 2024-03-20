package com.shubham.social.media.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.models.Post;
import com.shubham.social.media.response.ApiResponse;
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
	public ResponseEntity<ApiResponse> deletePost(@PathVariable int postId ,@PathVariable int userId) throws Exception {
		
		String message = postService.deletePost(postId, userId);
		
		ApiResponse response = new ApiResponse(message,true);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("/post/{postId}")
	public ResponseEntity<Post> findPostByIdHandeler(@PathVariable int postId) throws Exception {
		
		Post post = postService.findPostById(postId);

		return new ResponseEntity<Post>(post,HttpStatus.OK);	
	}
	
	@GetMapping("/post/user/{userId}")
	public ResponseEntity<List<Post>> findUserPost(@PathVariable int userId) throws Exception {
		
		List<Post> post = postService.findPostsByUserId(userId);
		
		return new ResponseEntity<List<Post>>(post,HttpStatus.OK);
	}
	
	@GetMapping("/post")
	public ResponseEntity<List<Post>> findAllPost() throws Exception  {
		
		List<Post> post = postService.findAllPost();
		
		return new ResponseEntity<List<Post>>(post,HttpStatus.OK);
	}
	
	@PutMapping("/post/{postId}/user/{userId}")
	public ResponseEntity<Post> savePostHandeler(@PathVariable int postId ,@PathVariable int userId) throws Exception {
		
		Post post = postService.savedPost(postId,userId);
		
		return new ResponseEntity<Post>(post,HttpStatus.OK);
	}
	
	@PutMapping("/post/like/{postId}/user/{userId}")
	public ResponseEntity<Post> likePostHandeler(@PathVariable int postId ,@PathVariable int userId) throws Exception {
		
		Post post = postService.likePost(postId,userId);
		
		return new ResponseEntity<Post>(post,HttpStatus.OK);
	}

}
