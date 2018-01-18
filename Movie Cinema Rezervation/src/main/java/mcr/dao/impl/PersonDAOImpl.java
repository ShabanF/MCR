package mcr.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mcr.dao.PersonDAO;
import mcr.model.PersonEntity;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PersonEntity> listPersons() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		List<PersonEntity> personList = session.createQuery("from PersonEntity").list();
		
		return personList;
	}

	@Override
	public PersonEntity getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		
		return (PersonEntity) session.get(PersonEntity.class, id);
	}

	@Override
	public List<PersonEntity> getPersonByFields(String name, String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPerson() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePerson() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePerson() {
		// TODO Auto-generated method stub

	}

}
