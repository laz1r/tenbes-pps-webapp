package com.tenbes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value="/create",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST
			)
	public Integer createUser(@RequestBody User user) { // returns generated id back to client
		
		// create user on FE, pass to here, save in DB ...
		
		// return id to client !
		
		// FE: if id > 0 then /home
		
		this.userRepository.save(user);
		
		return user.getId();
		
	}
	
	@RequestMapping(value="/login",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST
			)
	public String loginUser(@RequestBody User user) { 
		
		// when login gain access to home page
		
		// ** return user.getId()
		
		Optional<User> userId = this.userRepository.loginByEmailAndPass(user.getEmail(),
																user.getPass());
		if(userId.isPresent()) {
			return userId.get().getFirstName(); // return id
		}
		
		return null;
		
	}
	
	
	//@RequestMapping(value="/home"
	
	@RequestMapping(value="/findById",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST
			)
	public ResponseEntity<Optional<User>> findUser(@RequestBody User user) {
		
		Optional<User> u = this.userRepository.findById((user.getId()));
		
		return new ResponseEntity<Optional<User>>(u, HttpStatus.OK);
	}
	
			
}
