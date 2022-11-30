package com.bytestrone.assets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytestrone.assets.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

	UserModel findByUsernameAndPassword(String username, String password);

}
