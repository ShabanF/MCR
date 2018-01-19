package mcr.dao;

import java.util.List;

import mcr.model.RoleEntity;

public interface RoleDAO {
	
	public List<RoleEntity> listRoles();
	
	public RoleEntity getRoleById(int id);

}
