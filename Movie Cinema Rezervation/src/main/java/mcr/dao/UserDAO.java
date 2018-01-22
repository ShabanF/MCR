package mcr.dao;

import java.util.List;

import mcr.model.UserEntity;

public interface UserDAO {
	
	public List<UserEntity> listUsers();
	
	public UserEntity getUserById(int id);
	
	public List<UserEntity> getPotentialUser(String email, String password);
	
	public List<UserEntity> getUserByFields(String email);
	
	public void addUser(UserEntity user);
	
	public void updateUser(UserEntity user);
	
	public void deleteUser(UserEntity user);
}
