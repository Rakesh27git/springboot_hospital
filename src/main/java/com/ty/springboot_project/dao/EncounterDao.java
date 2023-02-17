package com.ty.springboot_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_project.dto.Encounter;
import com.ty.springboot_project.repo.EncounterRepo;

@Repository
public class EncounterDao {
	@Autowired
	private EncounterRepo encounterRepo;

	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepo.save(encounter);
	}

	public Encounter getById(int encounter_id) {
		if (encounterRepo.findById(encounter_id).isPresent()) {
			return encounterRepo.findById(encounter_id).get();
		}
		return null;
	}

	public Encounter updateEncounter(Encounter encounter, int encounter_id) {
		if (encounterRepo.findById(encounter_id).isPresent()) {
			encounter.setId(encounter_id);
			Encounter encounter2 = encounterRepo.save(encounter);
			return encounter2;
		}

		return null;
	}

	public Encounter deleteEncounter(int encounter_id) {
		if (encounterRepo.findById(encounter_id).isPresent()) {
			Encounter encounter = encounterRepo.findById(encounter_id).get();
			encounterRepo.delete(encounter);
			return encounter;
		}
		return null;
	}

}
