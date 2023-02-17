package com.ty.springboot_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.MedOrdersDao;
import com.ty.springboot_project.dao.MedItemsDao;
import com.ty.springboot_project.dto.MedItems;
import com.ty.springboot_project.dto.MedOrders;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.util.ResponseStructure;

@Service
public class MedItemsService {
	@Autowired
	private MedItemsDao medItemsDao;

	@Autowired
	private MedOrdersDao medOrdersDao;

	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(MedItems medItems, int medOrder_id) {
		MedOrders medOrder = medOrdersDao.getMedOrdersById(medOrder_id);
		ResponseStructure<MedItems> structure = new ResponseStructure<>();

		if (medOrder != null) {
			medItems.setMedOrders(medOrder);
			structure.setMessage("Successfully saved MedItems");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(medItemsDao.saveMedItems(medItems));
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.CREATED);
		} else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(MedItems MedItems, int order_id) {
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		MedItems medItems2 = medItemsDao.getMedItemsById(order_id);
		if (medItems2 != null) {
			MedItems.setMedOrders(medItems2.getMedOrders());
			structure.setMessage("Successfully updated MedItems");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medItemsDao.updateMedItems(medItems2, order_id));
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
		} else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(int order_id) {
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		MedItems MedItems2 = medItemsDao.getMedItemsById(order_id);
		if (MedItems2 != null) {
			structure.setMessage("Successfully deleted MedItems");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medItemsDao.deleteMedItems(order_id));
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
		} else
			throw new IdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(int order_id) {
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		MedItems MedItems2 = medItemsDao.getMedItemsById(order_id);
		if (MedItems2 != null) {
			structure.setMessage("Successfully fetched MedOrder");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(MedItems2);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.FOUND);
		} else
			throw new IdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<List<MedItems>>> getAllMedItems(int medOrder_id) {
		ResponseStructure<List<MedItems>> structure = new ResponseStructure<>();
		List<MedItems> daoMedItems = medItemsDao.getAllMedItems(medOrder_id);
		if (daoMedItems != null) {
			structure.setMessage("Successfully fetched all MedItems");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(daoMedItems);
			return new ResponseEntity<ResponseStructure<List<MedItems>>>(structure, HttpStatus.FOUND);
		} else
			throw new IdNotFoundException();

	}

}
