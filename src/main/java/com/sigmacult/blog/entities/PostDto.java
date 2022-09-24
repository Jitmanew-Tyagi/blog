package com.sigmacult.blog.entities;

import java.util.List;

import lombok.Data;

@Data
public class PostDto {
	String title;
	String content;
	String imageName;
	List<String> categoryNames;
	String userEmail;
}
