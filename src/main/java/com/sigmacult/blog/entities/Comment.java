package com.sigmacult.blog.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Comment {
	@Id
	private String id;
	private String content;
	private String postId;
}
