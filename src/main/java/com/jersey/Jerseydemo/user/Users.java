package com.jersey.Jerseydemo.user;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;


import com.jersey.Jerseydemo.entity.Zoo;

public class Users {
	private int id;
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
		private Zoo zoo;
	
	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}


	
		
}
