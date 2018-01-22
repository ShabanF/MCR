package mcr.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mcr.filters.SessionUtils;
import mcr.model.UserEntity;
import mcr.service.RoleService;
import mcr.service.UserService;
import mcr.service.dto.User;

@Named
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 3003314268499203224L;

	private String email;

	private String password;

	private String passwordConfirmation;

	private User user;

	private User newUser;

	@Inject
	private UserService userService;

	@Inject
	private RoleService roleService;

	@PostConstruct
	public void init() {
		this.newUser = new User();
	}

	public String LogIn() {
		this.user = this.userService.logIn(this.email, this.password);

		return this.userService.getUserRole(user);

	}

	public String Register() {

		/*
		 * 
		 * if (this.userService.doPasswordsMatch(password, passwordConfirmation)) {
		 * this.newUser.setRole(this.roleService.getRoleById(1));
		 * 
		 * if (this.userService.addUser(this.newUser)) { return "client"; } else { } }
		 * else { System.out.println("Passwordi nuk perputhet!"); }
		 * 
		 */

		return "fail";
	}

	public String LogOut() {
		int role_id = this.user.getRole_id();
		this.user = null;
		return this.userService.logOut(role_id);
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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

}
