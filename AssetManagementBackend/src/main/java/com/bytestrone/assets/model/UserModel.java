package com.bytestrone.assets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class UserModel {

	@Id
	@Column(name = "username", length = 20, unique = true)
	private String username;

	@Column(name = "name", length = 40)
	private String name;

	@Column(name = "password", length = 20)
	private String password;

	@Column(name = "title")
	private String title;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
