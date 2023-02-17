package com.ty.springboot_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_project.dto.Branch;
import com.ty.springboot_project.dto.Encounter;
import com.ty.springboot_project.dto.Hospital;
import com.ty.springboot_project.dto.MedOrders;
import com.ty.springboot_project.repo.MedOrderRepo;

@Repository
public class MedOrdersDao {

	@Autowired
	private MedOrderRepo medOrderRepo;
	@Autowired
	private EncounterDao encounterDao;

	public MedOrders saveMedOrders(MedOrders medOrders) {
		return medOrderRepo.save(medOrders);
	}

	public MedOrders updateMedOrders(MedOrders medOrders, int order_id) {
		if (medOrderRepo.findById(order_id).isPresent()) {
			medOrders.setId(order_id);
			return medOrderRepo.save(medOrders);
		}
		return null;
	}

	public MedOrders deleteMedOrders(int order_id) {
		if (medOrderRepo.findById(order_id).isPresent()) {
			MedOrders medOrders = medOrderRepo.findById(order_id).get();
			medOrderRepo.delete(medOrders);
			return medOrders;
		}
		return null;
	}

	public MedOrders getMedOrdersById(int order_id) {
		if (medOrderRepo.findById(order_id).isPresent()) {
			MedOrders medOrders = medOrderRepo.findById(order_id).get();
			return medOrders;
		}
		return null;
	}

	public List<MedOrders> getAllMedOrders(int encounter_id) {
		Encounter encounter = encounterDao.getById(encounter_id);
		if (encounter != null) {
			return medOrderRepo.getByEncounter(encounter);

		}
		return null;
	}
}
