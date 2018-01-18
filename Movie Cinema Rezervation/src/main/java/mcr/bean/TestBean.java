package mcr.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mcr.model.UserEntity;
import mcr.service.UserService;

import java.util.List;

@Component
@Named
public class TestBean implements Serializable{

	private static final long serialVersionUID = -3757117980792690807L;
	
	private String email;
	
	private String password;
	
	private UserEntity user;
	
	@Autowired
	private UserService userService;
	
	private List<UserEntity> userList;
	
	@PostConstruct
	public void init() {
		
	}
	
	public String logIn() {
		this.user = this.userService.logIn(this.email, this.password);
		
		if (this.user != null) {
			if (this.user.getRole().getId() == 2) {
				
				System.out.println("Kico");
				
				return "admin";
			}
			
			else if (this.user.getRole().getId() == 1) {
				return "client";
			}
		}
		
		return "fail";
	}

	public List<UserEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
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

}
