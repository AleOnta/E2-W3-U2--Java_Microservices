package com.m_services_producer.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.m_services_producer.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProducerRunner implements ApplicationRunner {

	@Autowired PersonService personService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		log.info("run...");
		while (personService.getAllPersons().size() < 50) {
			personService.persistFakePerson();
		}
	}
}
