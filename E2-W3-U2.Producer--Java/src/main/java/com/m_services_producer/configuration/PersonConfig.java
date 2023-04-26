package com.m_services_producer.configuration;

import java.time.LocalDate;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.github.javafaker.Faker;
import com.m_services_producer.model.Person;

@Configuration
public class PersonConfig {
	Faker fake = Faker.instance(new Locale("it-IT"));	
	
	@Bean
	@Scope("prototype")
	public Person fakePerson() {
		Integer year = fake.number().numberBetween(1970, 2020);
		Integer month = fake.number().numberBetween(1, 12);
		Integer day = fake.number().numberBetween(1, 28);
		return Person.builder()
				.firstname(fake.name().firstName())
				.lastname(fake.name().lastName())
				.birthdate(LocalDate.of(year, month, day))
				.city(fake.address().state())
				.nationality("Italy")
				.build();
	}
}
