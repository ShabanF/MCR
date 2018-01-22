package mcr.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mcr.dao.UserDAO;
import mcr.filters.SessionUtils;
import mcr.model.RoleEntity;
import mcr.model.UserEntity;
import mcr.service.UserService;
import mcr.service.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public User logIn(String email, String password) {

		List<User> potentialUsers = this.userDAO.getPotentialUser(email, password)
				.stream()
				.map(toPerson())
				.collect(Collectors.toList());

		if (potentialUsers.isEmpty() || potentialUsers.size() > 1) {
			return null;
		}

		return potentialUsers.get(0);
	}

	@Override
	public String getUserRole(User user) {

		if (user != null) {
			HttpSession session = SessionUtils.getSession();

			if (user.getRole_id() == 2) {

				session.setAttribute("admin", user);

				return "admin";
			}

			else if (user.getRole_id() == 1) {

				session.setAttribute("client", user);
				return "client";
			}
		}

		return "fail";
	}

	@Override
	public String logOut(int role_id) {
		HttpSession session = SessionUtils.getSession();
		if (role_id == 2) {
			session.removeAttribute("admin");
			return "logout";
		}
		session.removeAttribute("client");
		return "index?faces-redirect=true";
	}

	@Override
	public boolean doPasswordsMatch(String password, String passwordConfirmation) {

		if (password.equals(passwordConfirmation)) {
			return true;
		}

		return false;
	}

	@Override
	@Transactional
	public List<UserEntity> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	public UserEntity getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public boolean addUser(User user) {

		List<UserEntity> userList = this.userDAO.getUserByFields(user.getEmail());

		if (userList.isEmpty()) {
			UserEntity usr = toUser(user);
			this.userDAO.addUser(usr);
			return true;
		}

		return false;

	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Function<UserEntity, User> toPerson() {
		return entity -> {
			User user = new User();
			user.setName(entity.getName());
			user.setLastname(entity.getLastname());
			user.setEmail(entity.getEmail());
			user.setRole_id(entity.getRole().getId());
			return user;
		};
	}

	private UserEntity toUser(User user) {
			UserEntity userEntity = new UserEntity();
			userEntity.setName(user.getName());
			userEntity.setLastname(user.getLastname());
			userEntity.setEmail(user.getEmail());
			userEntity.setPassword(user.getPassword());
			RoleEntity role = new RoleEntity();
			role.setId(1);
			role.setRoleName("client");
			userEntity.setRole(role);
			return userEntity;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
