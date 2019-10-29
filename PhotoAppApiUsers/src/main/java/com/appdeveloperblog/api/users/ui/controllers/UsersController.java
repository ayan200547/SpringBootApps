package com.appdeveloperblog.api.users.ui.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdeveloperblog.api.users.service.UserService;
import com.appdeveloperblog.api.users.shared.UserDto;
import com.appdeveloperblog.api.users.ui.model.CreateUserRequestModel;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private Environment env;
	@Autowired
	UserService userService;
	@GetMapping("/status/check")
	public String status() {
		
		return "Working on port no"+env.getProperty("local.server.port");
	}

	@PostMapping("/create")
	public String createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map( userDetails,UserDto.class);

		userService.createUser(userDto);
		return "User Created";
	}
}
