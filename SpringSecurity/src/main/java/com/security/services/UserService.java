package com.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.model.User;

@Service
public class UserService {

	List<User> list= new ArrayList<User>();
	
	public UserService() {
		list.add(new User("abc123","1234","abc@gmail.com"));
		list.add(new User("jigo","jigo1234","jigo@gmail.com"));
	}
	
	
	// get all user
	
	public List<User> getAllUser(){
		System.out.println("getall");
		return this.list;
	}
	
	// get single user
	public User getUser(String username) {
		return this.list.stream()
				.filter((user)->user.getUsername()
				.equals(username))
				.findAny().orElse(null);
	}
	
	// add user
	public User addUser(User user) {
		this.list.add(user);
		return user;
		
	}
	
	//
	
}
