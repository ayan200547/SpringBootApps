package com.appdeveloperblog.api.users.serviceimpl;

import com.appdeveloperblog.api.users.shared.UserDto;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdeveloperblog.api.users.data.UserEntity;
import com.appdeveloperblog.api.users.data.UserRepository;
import com.appdeveloperblog.api.users.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	UserRepository UserRepository;
	@Autowired
	public UserServiceImpl(UserRepository UserRepository) {
		this.UserRepository=UserRepository;
	}
	

	@Override
	public UserDto createUser(UserDto userDetails) {
		// TODO Auto-generated method stub
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword("test");
		UserRepository.save(userEntity);
		return userDetails;
	}

}
