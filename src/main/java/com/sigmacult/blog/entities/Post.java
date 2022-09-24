package com.sigmacult.blog.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Post {
	
	@Id
	private String id;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private List<Category> categories;
	private User user;
	private List<Comment> comments;
}
