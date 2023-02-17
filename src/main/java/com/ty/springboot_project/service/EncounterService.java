package com.ty.springboot_project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.BranchDao;
import com.ty.springboot_project.dao.EncounterDao;
import com.ty.springboot_project.dao.PersonDao;
import com.ty.springboot_project.dto.Branch;
import com.ty.springboot_project.dto.Encounter;
import com.ty.springboot_project.dto.Person;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	private EncounterDao encounterDao;
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private PersonDao personDao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int branch_id,
			int person_id) {

		Branch branch = branchDao.getBranchById(branch_id);
		Person person = personDao.getById(person_id);

		encounter.setPerson(person);

		List<Branch> branches = new ArrayList<>();
		branches.add(branch);

		encounter.setBranches(branches);

		ResponseStructure<Encounter> structure = new ResponseStructure<>();
		structure.setMessage("Successfully saved Encounter");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(encounterDao.saveEncounter(encounter));

		return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int branch_id,
			int encounter_id) {

		ResponseStructure<Encounter> structure = new ResponseStructure<>();

		Encounter daoEncounter = encounterDao.getById(encounter_id);
		Branch branch = branchDao.getBranchById(branch_id);
		List<Branch> list = daoEncounter.getBranches();
		list.add(branch);

		encounter.setBranches(list);
		encounter.setPerson(daoEncounter.getPerson());
		Encounter newencounter = encounterDao.updateEncounter(encounter, encounter_id);
		if (newencounter != null) {
			structure.setMessage("Successfully updated encounter");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(newencounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		} else
			throw new IdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int encounter_id) {
		ResponseStructure<Encounter> structure = new ResponseStructure<Encounter>();
		Encounter encounter2 = encounterDao.deleteEncounter(encounter_id);
		if (encounter2 != null) {
			structure.setMessage("Successfully deleted encounter");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(encounter2);
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		} else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int encounter_id) {
		ResponseStructure<Encounter> structure = new ResponseStructure<>();
		Encounter encounter = encounterDao.getById(encounter_id);
		if (encounter != null) {
			structure.setMessage("Successfully fetched");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		} else
			throw new IdNotFoundException();
	}

}
