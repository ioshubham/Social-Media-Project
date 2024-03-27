package com.shubham.social.media.service;

import java.util.List;

import com.shubham.social.media.exceptions.PostException;
import com.shubham.social.media.exceptions.UserException;
import com.shubham.social.media.models.Post;

public interface PostService {
	
	Post createNewPost(Post post ,int userId) throws PostException, UserException;
	
	String deletePost(int postId , int userId) throws PostException, UserException;
	
	List<Post> findPostsByUserId(int user_id) throws PostException;
	
	Post findPostById(int postId) throws PostException;
	
	List<Post> findAllPost() throws PostException;
	
	Post savedPost(int postId,int userId) throws PostException, UserException;
	
	Post likePost(int postId , int userId) throws PostException, UserException;
	
	Post updatePostById(int postId, int userId) throws PostException;

}
