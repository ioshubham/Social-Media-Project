package com.shubham.social.media.response;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.social.media.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
