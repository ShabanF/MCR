package mcr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mcr.dao.RoleDAO;
import mcr.model.RoleEntity;
import mcr.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roleDAO;

	@Override
	@Transactional
	public List<RoleEntity> listRoles() {
		return this.roleDAO.listRoles();
	}

	@Override
	@Transactional
	public RoleEntity getRoleById(int id) {
		return this.roleDAO.getRoleById(id);
	}

}
