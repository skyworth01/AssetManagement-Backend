package com.bytestrone.assets.service.impl;

import org.springframework.stereotype.Service;

import com.bytestrone.assets.model.UserModel;
import com.bytestrone.assets.repository.UserRepository;
import com.bytestrone.assets.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRespository) {
		super();
		this.userRepository = userRespository;
	}

	@Override
	public UserModel verifyUsernameAndPassword(String username, String password) {
		UserModel user = userRepository.findByUsernameAndPassword(username, password);	// Finding user with matching username and password
		if (user != null) {
			return user;
		}
		return null;

	}

}
