package com.sigmacult.blog.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigmacult.blog.entities.Category;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryRepoProcessor {
	@Autowired
	CategoryRepo categoryRepo;
	
	//CREATE
	public Category createCategory(Category category) {
		Category check = categoryRepo.findByCategoryName(category.getCategoryName().toLowerCase());
		if(check == null) {
			category.setCategoryName(category.getCategoryName().toLowerCase());
			return categoryRepo.save(category);
		}
		log.info("Category already exists with name {}", category.getCategoryName());
		return check;
	}
	//READ
	public Category getCategory(String name) {
		Category check = categoryRepo.findByCategoryName(name);
		if(check == null) {
			log.info("No category with name {}", name);
		}
		return check;
	}
	
	
	//DELETE
	public boolean deleteCategory(String name) {
		Category check = categoryRepo.findByCategoryName(name);
		boolean status = false;
		if(check != null) {
			categoryRepo.delete(check);
			status = true;
		}
		else log.info("No category with name {}", name);
		return status;
	}
	
	//UPDATE
	public Category updateCategory(Category category) {
		Category check = categoryRepo.findByCategoryName(category.getCategoryName());
		if(check == null) {
			log.info("No category with name {}, saving this one", category.getCategoryName());
		}
		else {
			deleteCategory(category.getCategoryName());
		}
		createCategory(category);
		return category;
	}
	//GET ALL
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}
	
}
