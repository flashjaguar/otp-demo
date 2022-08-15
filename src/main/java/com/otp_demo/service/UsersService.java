package com.otp_demo.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.otp_demo.model.Users;
import com.otp_demo.repo.UserRepository;



@Service
public class UsersService implements UserDetailsService {
	
  @Autowired
  private UserRepository userRepository;
  
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Users users = userRepository.findByUsername(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(users.getRole());
		UserDetails userDetails = (UserDetails) new User(users.getUsername(),
		users.getPassword(), Arrays.asList(authority));
		
return userDetails;
}
}
