package com.ty.springboot_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_project.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {
	@Query("SELECT h FROM Hospital h WHERE h.email=?1")
	public Hospital getByEmail(String email);
}
