package com.shubham.social.media.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.models.Comment;
import com.shubham.social.media.models.User;
import com.shubham.social.media.response.CommentRepository;
import com.shubham.social.media.service.CommentService;
import com.shubham.social.media.service.UserService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService; 
	
	@PostMapping("/api/comments/post/{postId}")
	public Comment createComment(@RequestBody Comment comment,@RequestHeader("Authorization") String jwt,@PathVariable Integer postId) throws Exception  {
		
		User user = userService.findUserByJwt(jwt);
		Comment createdComment = commentService.createComment(comment, postId, user.getId());
		
		return createdComment;
		
	}
	
	@PutMapping("/api/comments/like/{commentId}")
	public Comment likeComment(@RequestHeader("Authorization") String jwt,@PathVariable Integer commentId) throws Exception  {
		
		User user = userService.findUserByJwt(jwt);
		Comment likeComment = commentService.likeComment(commentId, user.getId());
		
		return likeComment;
		
	}
	
	@GetMapping("/api/comment/{commentId}")
	public Comment findComment(@PathVariable int commentId) throws Exception {
		
		Comment comment =commentService.findCommentById(commentId);
		
		return comment;
		
	}
	
	

}
