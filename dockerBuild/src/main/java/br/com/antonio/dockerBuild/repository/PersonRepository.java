package br.com.antonio.dockerBuild.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.antonio.dockerBuild.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
