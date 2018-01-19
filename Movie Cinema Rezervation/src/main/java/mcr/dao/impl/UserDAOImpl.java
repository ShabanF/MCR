package mcr.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mcr.dao.UserDAO;
import mcr.model.UserEntity;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();

		List<UserEntity> userList = session.createQuery("from UserEntity").list();

		return userList;
	}

	@Override
	public UserEntity getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (UserEntity) session.get(UserEntity.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getPotentialUser(String email, String password) {
		Session session = this.sessionFactory.getCurrentSession();

		String selectQuery = "from UserEntity where email= :email and password= :password";

		Query<UserEntity> query = session.createQuery(selectQuery);

		query.setParameter("email", email);
		query.setParameter("password", password);

		List<UserEntity> userList = query.list();

		if (userList.isEmpty()) {
			return new ArrayList<>();
		}

		return userList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUserByFields(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		
		String selectQuery = "select id from UserEntity where email= :email";
		
		Query<UserEntity> query = session.createQuery(selectQuery);
		
		query.setParameter("email", email);
		
		List<UserEntity> userList = query.list();
		
		if (userList.isEmpty()) {
			return new ArrayList<>();
		}

		return userList;
	}

	@Override
	public void addUser(UserEntity user) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		session.save(user);
	}

	@Override
	public void updateUser(UserEntity user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteUser(UserEntity user) {
		// TODO Auto-generated method stub
	}

}
