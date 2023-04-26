package com.m_services_producer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.m_services_producer.model.Person;
import com.m_services_producer.repository.PersonRepository;

@Service
public class PersonService {

	Faker fake = Faker.instance(new Locale("it-IT"));
	
	@Autowired PersonRepository personRepo;
	
	@Autowired @Qualifier("fakePerson")
	private ObjectProvider<Person> fakePerson;
	
	public void persistFakePerson() {
		personRepo.save(fakePerson.getObject());
	}
	
	public List<Person> getAllPersons() {
		return (List<Person>) personRepo.findAll();
	}
	
	public List<Person> getFourRandomPersons() {
		List<Person> toRes = new ArrayList<Person>();
		List<Person> allPersons = getAllPersons();
		while (toRes.size() < 4) {
			toRes.add(allPersons.get(fake.number().numberBetween(0, allPersons.size() - 1)));
		}
		return toRes;
	}
	
	public Map<Integer, List<Person>> getListOfListOfPersons() {
		HashMap<Integer, List<Person>> toRes = new HashMap<Integer, List<Person>>();
		int i = 0;
		while (toRes.size() < 5) {
			List<Person> toAdd = getFourRandomPersons();
			toRes.put(i, toAdd);
			i++;
		}
		return toRes;
	}
	
}
