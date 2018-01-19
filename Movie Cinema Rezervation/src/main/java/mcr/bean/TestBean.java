package mcr.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import mcr.model.UserEntity;
import mcr.service.UserService;


@Named
public class TestBean implements Serializable{

	private static final long serialVersionUID = -3757117980792690807L;
	
	private String email;
	
	private String password;
	
	private UserEntity user;
	
	private int someNumber;
	
	@Inject
	private UserService userService;
	
	@PostConstruct
	public void init() {
		
	}
	
	public String logIn() {
		this.user = this.userService.logIn(this.email, this.password);
		
		if (this.user != null) {
			if (this.user.getRole().getId() == 2) {
				
				return "admin";
			}
			
			else if (this.user.getRole().getId() == 1) {
				return "client";
			}
		}
		
		return "fail";
	}
	
	public String register() {
		return null;
	}
	
	public String logOut() {
		return "logout";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public int getSomeNumber() {
		return someNumber;
	}

	public void setSomeNumber(int someNumber) {
		this.someNumber = someNumber;
	}

}
