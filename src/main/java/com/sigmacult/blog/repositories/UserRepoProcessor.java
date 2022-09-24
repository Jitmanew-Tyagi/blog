package com.sigmacult.blog.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigmacult.blog.entities.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserRepoProcessor {
	@Autowired
	UserRepo userRepo;
	
	// CREATE
	public User addUser(User user) {
		User check = userRepo.findByEmail(user.getEmail());
		if(check != null) {
			log.info("user already exists with this email");
			return check;
		}
		log.info("adding user");
		return userRepo.save(user);
	}
	
	// READ
	public User getUser(String email) {
		User user = userRepo.findByEmail(email);
		if(user == null) 
			log.info("User not found with particular email");
		return user;
	}
	
	// DELETE
	public User deleteUser(String email) {
		User user = userRepo.findByEmail(email);
		if(user != null) {
			userRepo.delete(user);
		}
		else log.info("User not found with particular email");
		return user;
	}
	
	// READ
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	//UPDATE
	public User updateUser(String email, User user) {
		User oldUser = getUser(email);
		if(oldUser == null) {
			log.info("No such user exists, saving this new user");
			addUser(user);
		} else {
			deleteUser(email);
			addUser(user);
		}
		return user;
	}
}
