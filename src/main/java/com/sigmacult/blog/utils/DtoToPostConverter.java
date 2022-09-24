package com.sigmacult.blog.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigmacult.blog.entities.Category;
import com.sigmacult.blog.entities.Post;
import com.sigmacult.blog.entities.PostDto;
import com.sigmacult.blog.repositories.CategoryRepo;
import com.sigmacult.blog.repositories.CommentRepo;
import com.sigmacult.blog.repositories.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DtoToPostConverter {
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired 
	CommentRepo commentRepo;
	
	public Post dtoToPost(PostDto postDto) {
		Post post = new Post();
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		List<Category> listOfCategories = new ArrayList<>();
		try {
			for(String name : postDto.getCategoryNames()) // to be sorted by front-end
				listOfCategories.add(categoryRepo.findByCategoryName(name));
			post.setCategories(listOfCategories);
		} 
		
		catch(Exception e){
			log.info("Categories not set");
		}
		post.setAddedDate(new Date());
		post.setUser(userRepo.findByEmail(postDto.getUserEmail()));
		log.info(commentRepo.findByPostId(post.getId()).toString());
		return post;
	}
}