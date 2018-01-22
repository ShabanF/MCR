package mcr.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import mcr.dao.UserDAO;
import mcr.model.UserEntity;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<UserEntity> listUsers() {

		CriteriaQuery<UserEntity> criteriaQuery = this.entityManager
				.getCriteriaBuilder()
				.createQuery(UserEntity.class);
		
		@SuppressWarnings("unused")
		Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public UserEntity getUserById(int id) {
		return (UserEntity) this.entityManager.find(UserEntity.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getPotentialUser(String email, String password) {

		String selectQuery = "from UserEntity where email= :email and password= :password";

		List<UserEntity> userList = this.entityManager
				.createQuery(selectQuery)
				.setParameter("email", email)
				.setParameter("password", password).getResultList();

		if (userList.isEmpty()) {
			return new ArrayList<>();
		}

		return userList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUserByFields(String email) {
		
		String selectQuery = "select id from UserEntity where email= :email";

		List<UserEntity> userList = this.entityManager
				.createQuery(selectQuery)
				.setParameter("email", email)
				.getResultList();

		if (userList.isEmpty()) {
			return new ArrayList<>();
		}

		return userList;
	}

	@Override
	public void addUser(UserEntity user) {

		this.entityManager.persist(user);
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
