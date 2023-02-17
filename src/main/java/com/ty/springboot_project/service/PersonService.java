package com.ty.springboot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.PersonDao;
import com.ty.springboot_project.dto.Person;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.util.ResponseStructure;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.savePerson(person));

		return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(int id, Person person) {

		Person daoPerson = dao.updatePerson(id, person);
		if (daoPerson != null) {
			ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoPerson);

			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id) {
		Person daoPerson = dao.deletePerson(id);
		if (daoPerson != null) {
			ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoPerson);

			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");

		}
	}

	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id) {
		Person daoPerson = dao.getById(id);
		if (daoPerson != null) {
			ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(daoPerson);

			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Given Id Not Found");

		}
	}

	
}
