package com.shubham.social.media.service;

import com.shubham.social.media.models.Comment;

public interface CommentService {
	
	public Comment createComment(Comment comment , int postId ,int userId) throws Exception;
	
	public Comment likeComment(int commentId , int userId)throws Exception ; //reqUser (loggedIn user id)
	
	public Comment findCommentById(int commentId) throws Exception;

}
