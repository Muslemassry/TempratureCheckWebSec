package com.temp.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.temp.model.Person;

@Repository
public class PersonDAO {
	
	private SessionFactory sessionFactory;
	
	public Integer addPerson(Person person) {
		return (Integer) sessionFactory.getCurrentSession().save(person);
	}
	
	public Person getPersonByUsernamePassword(String username, String pWord) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Person where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", pWord);
		List <Person> personList = query.getResultList();
		if(personList != null && !personList.isEmpty()) {
			return personList.get(0);
		} else {
			return null;
		}
	}
	
	public Person getPersonByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Person where username = :username");
		query.setParameter("username", username);
		List <Person> personList = query.getResultList();
		if(personList != null && !personList.isEmpty()) {
			return personList.get(0);
		} else {
			return null;
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean doesPersonExist(String username, String email) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Person where username = :username or email = :email");
		query.setParameter("username", username);
		query.setParameter("email", email);
		List <Person> personList = query.getResultList();
		if(personList != null && !personList.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
