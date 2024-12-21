package com.security.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.Users;
import com.security.services.MyUserDetailsService;

import jakarta.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private MyUserDetailsService userService;
	

	@GetMapping("/")
	public List<Users> getAllUser() {
		return this.userService.getAllUser();

	}
	
	// get single user
	@GetMapping("/{username}")
	public Users getSingleUser(@PathVariable String username) {
		return this.userService.getUser(username);
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getcsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf"); // value 
		
	}
	
	// add user
	@PostMapping("/")
	public Users addUser(@RequestBody Users user) {
		return this.userService.addUser(user);
	}
	
	
	

}
