package mcr.service;

import java.util.List;

import mcr.model.PersonEntity;

public interface PersonService {
	
	public List<PersonEntity> listPersons();
	
	public PersonEntity getPersonById(int id);
	
	public boolean addPerson(PersonEntity person);
	
	public boolean updatePerson(PersonEntity person);
	
	public boolean deletePerson(PersonEntity person);

}
