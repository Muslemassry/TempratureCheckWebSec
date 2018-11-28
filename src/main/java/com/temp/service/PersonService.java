package com.temp.service;

import com.temp.exception.BusinessException;
import com.temp.model.Person;

public interface PersonService {
	Person login(String username, String pWord);
	void registerPerson(Person person) throws BusinessException;
}


