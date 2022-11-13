package com.greatlearning.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.greatlearning.student.entity.User;
import com.greatlearning.student.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User addUser(@RequestBody User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String enCodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(enCodedPassword);
		return userRepository.saveAndFlush(user);
	}

}
