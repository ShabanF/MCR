package mcr.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import mcr.filters.SessionUtils;
import mcr.model.UserEntity;
import mcr.service.RoleService;
import mcr.service.UserService;

@Named
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 3003314268499203224L;

	private String email;

	private String password;

	private String passwordConfirmation;

	private UserEntity user;

	private UserEntity newUser;

	@Inject
	private UserService userService;

	@Inject
	private RoleService roleService;

	@PostConstruct
	public void init() {
		this.newUser = new UserEntity();
	}

	public String LogIn() {
		this.user = this.userService.logIn(this.email, this.password);

		if (this.user != null) {
			HttpSession session = SessionUtils.getSession();

			if (this.user.getRole().getId() == 2) {

				session.setAttribute("admin", this.user);

				return "admin";
			}

			else if (this.user.getRole().getId() == 1) {

				session.setAttribute("client", this.user);
				return "client";
			}
		}
		
		System.out.println("Fail");

		return "fail";
	}

	public String Register() {

		if (this.newUser.getPassword().equals(this.passwordConfirmation)) {
			this.newUser.setRole(this.roleService.getRoleById(1));

			if (this.userService.addUser(this.newUser)) {
				System.out.println("Klienti u regjistrua");
				return "client";
			} else {
				System.out.println("Useri ekziston!");
			}
		} else {
			System.out.println("Passwordi nuk perputhet!");
		}

		return "fail";
	}

	public String LogOut() {
		HttpSession session = SessionUtils.getSession();
		if (this.user.getRole().getId() == 2) {
			session.removeAttribute("admin");
			this.user = null;
			return "logout";
		}
		session.removeAttribute("client");
		this.user = null;
		return "index?faces-redirect=true";
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

	public UserEntity getNewUser() {
		return newUser;
	}

	public void setNewUser(UserEntity newUser) {
		this.newUser = newUser;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

}
