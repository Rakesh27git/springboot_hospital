package com.ty.springboot_project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_project.dto.MedItems;
import com.ty.springboot_project.dto.MedOrders;

public interface MedItemsRepo extends JpaRepository<MedItems, Integer> {
	
	@Query("select m from MedItems m where m.medOrders=?1")
	public List<MedItems> getByMedOrder(MedOrders medOrders);

}
