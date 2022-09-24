package com.sigmacult.blog.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sigmacult.blog.entities.Post;

public interface PostRepo extends MongoRepository<Post, String> {
	Optional<Post> findById(String id);
	List<Post> findByTitleContaining(String keywords);
}
