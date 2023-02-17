package com.ty.springboot_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_project.dto.Encounter;
import com.ty.springboot_project.dto.MedItems;
import com.ty.springboot_project.dto.MedOrders;
import com.ty.springboot_project.repo.MedItemsRepo;
import com.ty.springboot_project.repo.MedOrderRepo;

@Repository
public class MedItemsDao {
	@Autowired
	private MedItemsRepo medItemsRepo;
	@Autowired
	private MedOrdersDao medOrdersDao;

	public MedItems saveMedItems(MedItems medItems) {
		return medItemsRepo.save(medItems);
	}

	public MedItems updateMedItems(MedItems medItems, int items_id) {
		if (medItemsRepo.findById(items_id).isPresent()) {
			medItems.setId(items_id);
			return medItemsRepo.save(medItems);
		}
		return null;
	}

	public MedItems deleteMedItems(int items_id) {
		if (medItemsRepo.findById(items_id).isPresent()) {
			MedItems medItems = medItemsRepo.findById(items_id).get();
			medItemsRepo.delete(medItems);
			return medItems;
		}
		return null;
	}

	public MedItems getMedItemsById(int items_id) {
		if (medItemsRepo.findById(items_id).isPresent()) {
			MedItems medItems = medItemsRepo.findById(items_id).get();
			return medItems;
		}
		return null;
	}

	public List<MedItems> getAllMedItems(int order_id) {
		MedOrders medOrders = medOrdersDao.getMedOrdersById(order_id);
		if (medOrders != null) {
			return medItemsRepo.getByMedOrder(medOrders);

		}
		return null;
	}
}
