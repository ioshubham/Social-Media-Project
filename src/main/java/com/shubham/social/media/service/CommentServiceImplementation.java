package com.shubham.social.media.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.social.media.models.Comment;
import com.shubham.social.media.models.Post;
import com.shubham.social.media.models.User;
import com.shubham.social.media.repository.PostRepository;
import com.shubham.social.media.response.CommentRepository;

@Service
public class CommentServiceImplementation implements CommentService{

	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Comment createComment(Comment comment, int postId, int userId) throws Exception {
		
		User user = userService.findUserById(userId);
		Post post = postService.findPostById(postId);
		
		comment.setUser(user);
		comment.setContent(comment.getContent());
		comment.setCreatedAt(LocalDateTime.now());
		
		Comment savedComment = commentRepository.save(comment);
		
		post.getComments().add(savedComment);
		
		postRepository.save(post);
		
		
		return savedComment;
	}

	@Override
	public Comment findCommentById(int commentId) throws Exception {
		Optional<Comment> opt = commentRepository.findById(commentId);
		
		if(opt.isEmpty()) {
			throw new Exception("comment not exists");
		}
		return opt.get();
	}

	@Override
	public Comment likeComment(int commentId, int userId) throws Exception {
		
		Comment comment = findCommentById(commentId);
		
		User user = userService.findUserById(userId);
		
		if(!comment.getLiked().contains(user)) {
			comment.getLiked().add(user);
		}
		else {
			comment.getLiked().remove(user);
		}
		
		return commentRepository.save(comment);
	}

}
