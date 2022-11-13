package com.greatlearning.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.student.entity.User;
import com.greatlearning.student.service.UserService;

@RestController
@RequestMapping("/student")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

}
