package com.developerblog.app.ws.userservice.impl;

	import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.developerblog.app.ws.model.UserModel;
import com.developerblog.app.ws.model.UserResponseModel;
import com.developerblog.app.ws.shared.Utils;
import com.developerblog.app.ws.userservice.UserService;
@Service
public class UserServiceImpl implements UserService{
	private Map<String,UserModel> userModelMap;
	Utils utils;
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils=utils;
	}
	@Override
	public UserModel createUser(UserResponseModel userDetails) {
		// TODO Auto-generated method stub
		UserModel model = new UserModel();
		model.setFirstName(userDetails.getFirstName());
		model.setLastName(userDetails.getLastName());
		model.setEmail(userDetails.getEmail());
		String userId=utils.generateUserId();
		System.out.println("userId>>>>"+userId);
		model.setUserId(userId);
		if(userModelMap==null)
			userModelMap = new HashMap<>();
		//model.setEmail(userId);
			userModelMap.put(userId, model);
			return model;
		
	}

}
