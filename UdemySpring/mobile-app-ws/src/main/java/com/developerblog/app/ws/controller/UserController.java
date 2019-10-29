package com.developerblog.app.ws.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developerblog.app.ws.exceptions.UserServiceException;
import com.developerblog.app.ws.model.UpdateUserModel;
import com.developerblog.app.ws.model.UserModel;
import com.developerblog.app.ws.model.UserResponseModel;
import com.developerblog.app.ws.userservice.UserService;

@RestController
@RequestMapping("/users") // http://localhost:2222/users/

public class UserController {
	
	@Autowired
	UserService userService;
	private Map<String,UserModel> userModelMap;
	
	@GetMapping
	public String getUsers(@RequestParam(value="page",defaultValue="1") int page,@RequestParam(value="limit",defaultValue="50") int limit) {
		return "get Users was called "+page+"  and limit "+limit;
	}
	@SuppressWarnings("unused")
	@GetMapping(path="/{userId}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserModel> getUser(@PathVariable String userId) {
		
		//String firstName=null;
		//int nameLength = firstName.length();
		
		if(true) throw new UserServiceException("A Uservice Service exception is thrown");
		if(userModelMap.containsKey(userId)) {
			return new ResponseEntity<>(userModelMap.get(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}

	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserResponseModel userDetails ) {
		/*
		 * UserModel model = new UserModel();
		 * model.setFirstName(userDetails.getFirstName());
		 * model.setLastName(userDetails.getLastName());
		 * model.setEmail(userDetails.getEmail()); String
		 * userId=UUID.randomUUID().toString(); System.out.println("userId>>>>"+userId);
		 * model.setUserId(userId); if(userModelMap==null) userModelMap = new
		 * HashMap<>(); //model.setEmail(userId); userModelMap.put(userId, model);
		 */
		UserModel returnValue = userService.createUser(userDetails);
		return new ResponseEntity<UserModel>(returnValue, HttpStatus.OK);
		

	}

	@PutMapping(path="/{userId}",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public UserModel updateUser(@PathVariable String userId,@RequestBody UpdateUserModel userDetails) {
		UserModel model = userModelMap.get(userId);
		model.setFirstName(userDetails.getFirstName());
		model.setLastName(userDetails.getLastName());
		userModelMap.put(userId, model);
		return model;

	}
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		userModelMap.remove(id);
		return ResponseEntity.noContent().build();

	}
}
