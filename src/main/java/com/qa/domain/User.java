package com.qa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity uses JPA
@Entity
public class User 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long userID;
	@Column(unique = true)
	private String username;
	@Column()
	private String password;
    
	public User(Long userID, String username, String password) 
	{
		this.userID = userID;
		this.username = username;
		this.password = password;
	}
	
	public User() {

	}
	
	public Long getId() {
		return userID;
	}

	public void setId(Long id) {
		this.userID = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
