package com.m_services_producer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.m_services_producer.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
