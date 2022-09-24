package com.sigmacult.blog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sigmacult.blog.entities.User;

@Repository
public interface UserRepo extends MongoRepository<User, String>{
	User findByEmail(String email);
}
