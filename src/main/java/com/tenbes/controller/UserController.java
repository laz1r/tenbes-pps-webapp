package com.tenbes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tenbes.entity.User;
import com.tenbes.repository.UserRepository;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST
			)
	public void createUser(@RequestBody User user) {
		this.userRepository.save(user);
	}
	
	@RequestMapping(value="/",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST
			)
	public void loginUser(@RequestBody User user) { // when login gain access to next page
		
	}
}
