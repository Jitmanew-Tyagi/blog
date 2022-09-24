package com.sigmacult.blog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sigmacult.blog.entities.Category;

public interface CategoryRepo extends MongoRepository<Category, String>{
	Category findByCategoryName(String name);
}
