package mcr.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import mcr.model.PersonEntity;

public interface PersonDAO {
	
	public List<PersonEntity> listPersons();
	
	public PersonEntity getPersonById(int id);
	
	public List<PersonEntity> getPersonByFields(String name, String lastname);
	
	public void addPerson();
	
	public void updatePerson();
	
	public void deletePerson();
	
	public void setSessionFactory(SessionFactory sf);

}
