package mcr.service;

import java.util.List;

import mcr.model.UserEntity;
import mcr.service.dto.User;

public interface UserService {
	
	//public UserEntity logIn(String email, String password);
	
	public User logIn(String email, String password);
	
	public List<UserEntity> listUsers();
	
	public UserEntity getUserById(int id);
	
	public boolean addUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);

	public String getUserRole(User user);

	public String logOut(int role_id);

	boolean doPasswordsMatch(String password, String passwordConfirmation);

}
