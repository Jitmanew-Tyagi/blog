package com.sigmacult.blog.controllers;

import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sigmacult.blog.entities.User;
import com.sigmacult.blog.repositories.UserRepoProcessor;

@RestController
public class UserControllers {
	
	@Autowired
	UserRepoProcessor userRepoProcessor;
	
	@GetMapping("/user")
	public User getUser(@PathParam("email") String email) {
		return userRepoProcessor.getUser(email);
	}
	@GetMapping("/")
	public String home() {
		return "Working, up and running...";
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody Map<String, String> user) {
		User newUser = new User(user.get("name"), user.get("email"), user.get("password"));
		System.out.println(user.toString());
		return userRepoProcessor.addUser(newUser);		
	}
	
	
	@DeleteMapping("/user") 
	public User deleteUser(@PathParam("{email}") String email) {
		return userRepoProcessor.deleteUser(email);
	}
	
	@PutMapping("/user") 
	public User updateUser(@RequestBody  Map<String, String> user) {
		User newUser = new User(user.get("name"), user.get("email"), user.get("password"));
		return userRepoProcessor.updateUser(user.get("oldUserEmail"), newUser);
	}
}
