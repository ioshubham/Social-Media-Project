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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.models.Post;
import com.shubham.social.media.models.User;
import com.shubham.social.media.response.ApiResponse;
import com.shubham.social.media.service.PostService;
import com.shubham.social.media.service.UserService;

import jakarta.persistence.PostRemove;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/api/posts")
	public ResponseEntity<Post> createPost(@RequestBody Post post , @RequestHeader("Authorization")String jwt) throws Exception {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		Post createdPost = postService.createNewPost(post,reqUser.getId()) ;
		
		return new ResponseEntity<>(createdPost,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/api/posts/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable int postId , @RequestHeader("Authorization")String jwt) throws Exception {
		
		User reqUser = userService.findUserByJwt(jwt);
		String message = postService.deletePost(postId, reqUser.getId());
		
		ApiResponse response = new ApiResponse(message,true);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("/post/{postId}")
	public ResponseEntity<Post> findPostByIdHandeler(@PathVariable int postId) throws Exception {
		
		Post post = postService.findPostById(postId);

		return new ResponseEntity<Post>(post,HttpStatus.OK);	
	}
	
	@GetMapping("/post/user/{user_id}")
	public ResponseEntity<List<Post>> findUserPost(@PathVariable int user_id) throws Exception {
		
		List<Post> post = postService.findPostsByUserId(user_id);
		
		return new ResponseEntity<List<Post>>(post,HttpStatus.OK);
	}
	
	@GetMapping("/post")
	public ResponseEntity<List<Post>> findAllPost() throws Exception  {
		
		List<Post> post = postService.findAllPost();
		
		return new ResponseEntity<List<Post>>(post,HttpStatus.OK);
	}
	
	@PutMapping("/api/post/{postId}")
	public ResponseEntity<Post> savePostHandeler(@PathVariable int postId ,@RequestHeader("Authorization")String jwt) throws Exception {
		
		User reqUser = userService.findUserByJwt(jwt);
		Post post = postService.savedPost(postId,reqUser.getId());
		
		return new ResponseEntity<Post>(post,HttpStatus.OK);
	}
	
	@PutMapping("/api/post/like/{postId}")
	public ResponseEntity<Post> likePostHandeler(@PathVariable int postId ,@RequestHeader("Authorization")String jwt) throws Exception {
		
		User reqUser = userService.findUserByJwt(jwt);
		Post post = postService.likePost(postId,reqUser.getId());
		
		return new ResponseEntity<Post>(post,HttpStatus.OK);
	}

}
