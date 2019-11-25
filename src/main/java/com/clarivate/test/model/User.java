package com.clarivate.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	private String username;
	private String password;
	
	public User() {
		
	}
	
	public User(String user, String pass) {
		this.username = user;
		this.password = pass;
	}
	
	@Column(name = "user", nullable = true)
    public String getUsername() {
        return username;
    }	
	
	@Column(name = "pass", nullable = true)
    public String getPassword() {
        return password;
    }	
}
