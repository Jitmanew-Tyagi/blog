package com.sigmacult.blog.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sigmacult.blog.entities.Comment;

public interface CommentRepo extends MongoRepository<Comment, String>{
	List<Comment> findByPostId(String id);
}
