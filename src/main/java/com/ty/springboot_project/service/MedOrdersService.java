package com.ty.springboot_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.EncounterDao;
import com.ty.springboot_project.dao.MedOrdersDao;
import com.ty.springboot_project.dto.Encounter;
import com.ty.springboot_project.dto.MedOrders;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.util.ResponseStructure;

@Service
public class MedOrdersService {

	@Autowired
	private MedOrdersDao medOrdersDao;
	@Autowired
	private EncounterDao encounterDao;

	public ResponseEntity<ResponseStructure<MedOrders>> saveMedOrders(MedOrders medOrders, int encounter_id) {
		Encounter encounter = encounterDao.getById(encounter_id);
		ResponseStructure<MedOrders> structure = new ResponseStructure<>();

		if (encounter != null) {
			medOrders.setEncounter(encounter);
			structure.setMessage("Successfully saved MedOrders");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(medOrdersDao.saveMedOrders(medOrders));
			return new ResponseEntity<ResponseStructure<MedOrders>>(structure, HttpStatus.CREATED);
		} else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<MedOrders>> updateMedOrders(MedOrders medOrders, int order_id) {
		ResponseStructure<MedOrders> structure = new ResponseStructure<>();
		MedOrders medOrders2 = medOrdersDao.getMedOrdersById(order_id);
		if (medOrders2 != null) {
			medOrders.setEncounter(medOrders2.getEncounter());
			structure.setMessage("Successfully updated MedOrders");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrdersDao.updateMedOrders(medOrders2, order_id));
			return new ResponseEntity<ResponseStructure<MedOrders>>(structure, HttpStatus.OK);
		} else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<MedOrders>> deleteMedOrders(int order_id) {
		ResponseStructure<MedOrders> structure = new ResponseStructure<>();
		MedOrders medOrders2 = medOrdersDao.getMedOrdersById(order_id);
		if (medOrders2 != null) {
			structure.setMessage("Successfully deleted MedOrders");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrdersDao.deleteMedOrders(order_id));
			return new ResponseEntity<ResponseStructure<MedOrders>>(structure, HttpStatus.OK);
		} else
			throw new IdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<MedOrders>> getMedOrdersById(int order_id) {
		ResponseStructure<MedOrders> structure = new ResponseStructure<>();
		MedOrders medOrders2 = medOrdersDao.getMedOrdersById(order_id);
		if (medOrders2 != null) {
			structure.setMessage("Successfully fetched MedOrder");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medOrders2);
			return new ResponseEntity<ResponseStructure<MedOrders>>(structure, HttpStatus.FOUND);
		} else
			throw new IdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<List<MedOrders>>> getAllMedOrders(int encounter_id) {
		ResponseStructure<List<MedOrders>> structure = new ResponseStructure<>();
		List<MedOrders> daoMedOrders = medOrdersDao.getAllMedOrders(encounter_id);
		if (daoMedOrders != null) {
			structure.setMessage("Successfully fetched all medOrders");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(daoMedOrders);
			return new ResponseEntity<ResponseStructure<List<MedOrders>>>(structure, HttpStatus.FOUND);
		} else
			throw new IdNotFoundException();

	}
}
