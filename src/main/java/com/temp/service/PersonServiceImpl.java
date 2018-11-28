package com.temp.service;

import com.temp.dao.PersonDAO;
import com.temp.exception.BusinessException;
import com.temp.model.Person;

public class PersonServiceImpl implements PersonService {

	private PersonDAO personDao;

	public Person login(String username, String pWord) {
		return personDao.getPersonByUsernamePassword(username, pWord);
	}

	public void registerPerson(Person person) throws BusinessException {
		if (doesPersonExist(person.getUsername(), person.getEmail())) {
			throw new BusinessException("person_already_saved");
		}
		
		personDao.addPerson(person);
	}

	public PersonDAO getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDAO personDao) {
		this.personDao = personDao;
	}

	private boolean doesPersonExist(String username, String email) {
		return personDao.doesPersonExist(username, email);
	}
}
