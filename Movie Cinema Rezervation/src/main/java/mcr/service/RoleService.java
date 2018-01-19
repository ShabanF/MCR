package mcr.service;

import java.util.List;

import mcr.model.RoleEntity;

public interface RoleService {
	
	public List<RoleEntity> listRoles();
	
	public RoleEntity getRoleById(int id);

}
