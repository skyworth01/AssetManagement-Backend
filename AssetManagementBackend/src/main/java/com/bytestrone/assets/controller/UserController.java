package com.bytestrone.assets.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytestrone.assets.model.UserModel;
import com.bytestrone.assets.service.UserService;
import com.bytestrone.assets.viewobjects.LoginRequestModel;
import com.bytestrone.assets.viewobjects.LoginVO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	// Verify User Credentials
	@PostMapping
	public ResponseEntity<LoginVO> verifyUserCredentials(@RequestBody LoginRequestModel login) {

		UserModel user = userService.verifyUsernameAndPassword(login.getUsername(), login.getPassword());
		if (user != null) {
			LoginVO data = new LoginVO();
			data.setName(user.getName());
			data.setTitle(user.getTitle());
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

}
