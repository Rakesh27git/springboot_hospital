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

import com.ty.springboot_project.dto.Encounter;
import com.ty.springboot_project.service.EncounterService;
import com.ty.springboot_project.util.ResponseStructure;

@RestController
public class EncounterController {
	@Autowired
	private EncounterService encounterService;

	@PostMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter,
			@RequestParam int branch_id, @RequestParam int person_id) {
		return encounterService.saveEncounter(encounter, branch_id, person_id);
	}

	@PutMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody Encounter encounter,
			@RequestParam int branch_id, @RequestParam int encounter_id) {
		return encounterService.updateEncounter(encounter, branch_id, encounter_id);
	}

	@DeleteMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int encounter_id) {
		return encounterService.deleteEncounter(encounter_id);
	}

	@GetMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@RequestParam int encounter_id) {
		return encounterService.getEncounterById(encounter_id);
	}

}
