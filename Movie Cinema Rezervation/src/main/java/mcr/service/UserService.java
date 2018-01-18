package mcr.service;

import java.util.List;

import mcr.model.UserEntity;

public interface UserService {
	
	public UserEntity logIn(String email, String password);
	
	public List<UserEntity> listUsers();
	
	public UserEntity getUserById(int id);
	
	public boolean addUser(UserEntity user);
	
	public boolean updateUser(UserEntity user);
	
	public boolean deleteUser(UserEntity user);

}
