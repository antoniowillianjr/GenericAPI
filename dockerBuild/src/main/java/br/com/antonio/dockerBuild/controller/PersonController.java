package br.com.antonio.dockerBuild.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.antonio.dockerBuild.model.Person;
import br.com.antonio.dockerBuild.services.PersonService;

@RestController
@RequestMapping(value="/api/v1/generic")
public class PersonController {
	
	@Autowired
	PersonService service;
	
	public List<Person> findAll(){
		return service.findAll();
	}
	
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}

}
