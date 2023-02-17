package com.ty.springboot_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_project.dto.Person;
import com.ty.springboot_project.service.PersonService;
import com.ty.springboot_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {
	@Autowired
	private PersonService service;

	@ApiOperation(value = "Save Person", notes = " Api is used to save the Person ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created") })
	@PostMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return service.savePerson(person);
	}

	@ApiOperation(value = "Update Person", notes = " Api is used to update the Person based on person id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Person not found for the given person id ") })
	@PutMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int id, @RequestBody Person person) {
		return service.updatePerson(id, person);
	}

	@ApiOperation(value = "Delete Person", notes = " Api is used to delete the Person based on person id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Person not found for the given person id ") })
	@DeleteMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int id) {
		return service.deletePerson(id);
	}

	@ApiOperation(value = "Get Person", notes = " Api is used to get the Person ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "Person not found for the given person id ") })
	@GetMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id) {
		return service.getPersonById(id);
	}

}
