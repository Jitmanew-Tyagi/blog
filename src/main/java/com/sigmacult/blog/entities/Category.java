package com.sigmacult.blog.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Category {
	@Id
	String id;
	
	String categoryName;
	String categoryDescription;
}
