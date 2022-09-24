package com.sigmacult.blog.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sigmacult.blog.entities.Category;
import com.sigmacult.blog.repositories.CategoryRepoProcessor;
 
@RestController
public class CategoryController {
	@Autowired
	CategoryRepoProcessor categoryRepoProcessor;
	
	@GetMapping("/categories")
	public Category getCategory(@PathParam("name") String name) {
		return categoryRepoProcessor.getCategory(name);
	}
	
	@GetMapping("/allCategories")
	public List<Category> getAllCategory() {
		return categoryRepoProcessor.getAllCategories();
	}
	
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		return categoryRepoProcessor.createCategory(category);
	}
	
	@DeleteMapping("/categories")
	public boolean deleteCategory(@PathParam("name") String name) {
		return categoryRepoProcessor.deleteCategory(name);
	}
	
	@PutMapping("/categories") 
	public Category updateCategory(@RequestBody Category category) {
		return categoryRepoProcessor.updateCategory(category);
	}
	
}
