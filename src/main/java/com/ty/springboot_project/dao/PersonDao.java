package com.ty.springboot_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.springboot_project.dto.Person;
import com.ty.springboot_project.dto.Person;
import com.ty.springboot_project.repo.PersonRepo;

@Repository
public class PersonDao {
	@Autowired
	private PersonRepo personRepo;

	public Person savePerson(Person person) {
		return personRepo.save(person);

	}

	public Person updatePerson(int id, Person person) {
		if (personRepo.findById(id).isPresent()) {
			Person person2 = personRepo.findById(id).get();
			person.setId(id);

			return personRepo.save(person);
		}
		return null;
	}

	public Person deletePerson(int id) {
		if (personRepo.findById(id).isPresent()) {
			Person person = personRepo.findById(id).get();
			personRepo.delete(person);
			return person;
		}
		return null;
	}

	public Person getById(int id) {
		if (personRepo.findById(id).isPresent()) {
			Person person = personRepo.findById(id).get();
			return person;
		}
		return null;
	}

	public List<Person> getAllPerson() {
		return personRepo.findAll();
	}

}
