package com.qa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

//Entity uses JPA to set up a table
@Entity
@Table(name = "USER")
public class User 
{
	//Generates a unique value
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Sets up a primary key
	@Id
	private Long userID;
	//column must be unique
	@Column(unique = true, nullable = false)
	@Size(min = 4, max = 12)
	private String username;
	@Column(nullable = false)
	private String password;
    
	public User(Long userID, String username, String password) 
	{//constructor for setting user
		this.userID = userID;
		this.username = username;
		this.password = password;
	}
	
	public User() 
	{//default constructor
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
