package com.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String user;
	private String password;
	
	

	public Usuarios(String user, String password) {
		
		this.user = user;
		this.password = password;
	}
	public Usuarios() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Usuarios [user=" + user + ", password=" + password + "]";
	}
	
	
	

}
