package com.developerblog.app.ws.userservice;

import org.springframework.http.ResponseEntity;

import com.developerblog.app.ws.model.UserModel;
import com.developerblog.app.ws.model.UserResponseModel;

public interface UserService {
	UserModel createUser(UserResponseModel model);
}
