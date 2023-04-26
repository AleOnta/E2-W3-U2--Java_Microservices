package com.m_services_consumer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/os")
public class MicroServicePersonController {

	@GetMapping("/get-string")
	public String getString() {
		RestTemplate  rt = new RestTemplate();
		String uri = "http://localhost:8082/app/data1";
		ResponseEntity<String> res = rt.getForEntity(uri, String.class);
		return "Producer [STRING] ==> " + res.getBody();
	}
	
	@GetMapping("/get-people")
	public String getListIntoList() {
		RestTemplate  rt = new RestTemplate();
		String uri = "http://localhost:8082/app/data2";
		ResponseEntity<String> res = rt.getForEntity(uri, String.class);
		return "Producer [STRING] ==> " + res.getBody();
	}
	
	@GetMapping("/get-people-json")
	public Object getFourJSONPersons() {
		RestTemplate  rt = new RestTemplate();
		String uri = "http://localhost:8082/app/data3";
		Object res = rt.getForObject(uri, Object.class);
		return res;
	}
	
}
