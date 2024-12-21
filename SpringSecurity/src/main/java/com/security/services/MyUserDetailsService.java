package com.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.security.model.Users;

@Service
public class MyUserDetailsService {

	List<Users> list= new ArrayList<Users>();
	
	public MyUserDetailsService() {
		list.add(new Users(1,"abc123","1234"));
		list.add(new Users(2,"jigo","jigo1234"));
	}
	
	
	// get all user
	
	public List<Users> getAllUser(){
		System.out.println("getall");
		return this.list;
	}
	
	// get single user
	public Users getUser(String username) {
		return this.list.stream()
				.filter((user)->user.getUsername()
				.equals(username))
				.findAny().orElse(null);
	}
	
	// add user
	public Users addUser(Users user) {
		this.list.add(user);
		return user;
		
	}
	
	//
	
}
