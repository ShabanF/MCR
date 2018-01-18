package mcr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mcr.dao.PersonDAO;
import mcr.model.PersonEntity;
import mcr.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;

	@Override
	@Transactional
	public List<PersonEntity> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	public PersonEntity getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	public boolean addPerson(PersonEntity person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePerson(PersonEntity person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePerson(PersonEntity person) {
		// TODO Auto-generated method stub
		return false;
	}

}
