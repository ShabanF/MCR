package mcr.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mcr.dao.RoleDAO;
import mcr.model.RoleEntity;

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RoleEntity> listRoles() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		List<RoleEntity> roleList = session.createQuery("from RoleEntity").list();
		
		return roleList;
	}

	@Override
	public RoleEntity getRoleById(int id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		return (RoleEntity) session.get(RoleEntity.class, id);
	}

}
