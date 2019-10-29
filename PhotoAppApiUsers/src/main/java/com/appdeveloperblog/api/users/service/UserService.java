package com.appdeveloperblog.api.users.service;

import com.appdeveloperblog.api.users.shared.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDetails);
}
