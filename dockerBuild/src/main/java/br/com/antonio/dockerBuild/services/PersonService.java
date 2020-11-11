package br.com.antonio.dockerBuild.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.antonio.dockerBuild.exception.FieldNotFoundResponse;
import br.com.antonio.dockerBuild.model.Person;
import br.com.antonio.dockerBuild.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public Person findById(Long id) {
		
		return repository.findById(id).orElseThrow(()-> new FieldNotFoundResponse("No records found for this ID"));
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}

}
