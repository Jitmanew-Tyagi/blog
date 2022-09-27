package com.sigmacult.blog.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.sigmacult.blog.entities.User;
import com.sigmacult.blog.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) {

		// loading user from database by username
		User user = this.userRepo.findByEmail(username));

		return (UserDetails) user;
	}

}
