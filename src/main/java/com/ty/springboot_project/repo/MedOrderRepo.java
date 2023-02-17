package com.ty.springboot_project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_project.dto.Encounter;
import com.ty.springboot_project.dto.MedOrders;

public interface MedOrderRepo extends JpaRepository<MedOrders, Integer> {
	@Query("SELECT m FROM MedOrders m WHERE m.encounter=?1")
	public List<MedOrders> getByEncounter(Encounter encounter);

}
