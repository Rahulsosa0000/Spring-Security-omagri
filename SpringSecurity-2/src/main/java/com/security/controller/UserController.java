package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userr")
public class UserController {

	@GetMapping("/")
	public String hello() {
		return "Hello from Db";
		
	}
}
