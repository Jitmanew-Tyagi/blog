package com.sigmacult.blog.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {
	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
}
