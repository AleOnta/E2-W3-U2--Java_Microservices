package com.m_services_producer.controller;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.github.javafaker.Faker;
import com.m_services_producer.model.Person;
import com.m_services_producer.service.PersonService;

@RestController
@RequestMapping("/app")
public class PersonController {

	@Autowired PersonService personService;
	
	Faker fake = Faker.instance(new Locale("it-IT"));
	
	@GetMapping(value = "/data1")
	public String returnString() {
		List<Person> allPersons = personService.getAllPersons();
		return allPersons.get(fake.number().numberBetween(0, allPersons.size()-1)).toString();
	}
	
	@GetMapping(value = "/data2")
	public String returnArrayOfArrayOfFourPersons() {
		return personService.getListOfListOfPersons().toString();
	}
	
	@GetMapping(value = "/data3", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> returnArrayOfFourPersons() {
		return personService.getFourRandomPersons();
	}
}

