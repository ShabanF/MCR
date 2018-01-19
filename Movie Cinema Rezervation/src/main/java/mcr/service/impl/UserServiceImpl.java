package mcr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mcr.dao.UserDAO;
import mcr.model.UserEntity;
import mcr.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public UserEntity logIn(String email, String password) {
		
		List<UserEntity> potentialUsers = this.userDAO.getPotentialUser(email, password);
		
		if (potentialUsers.isEmpty() || potentialUsers.size() > 1) {
			return null;
		}
		
		return potentialUsers.get(0);
		
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
	public boolean addUser(UserEntity user) {
		
		List<UserEntity> userList = this.userDAO.getUserByFields(user.getEmail());
		
		if (userList.isEmpty()) {
			this.userDAO.addUser(user);
			return true;
		}
		
		return false;
		
	}

	@Override
	public boolean updateUser(UserEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(UserEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
