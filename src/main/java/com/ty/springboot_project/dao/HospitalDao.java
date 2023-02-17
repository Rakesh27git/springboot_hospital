package com.ty.springboot_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_project.dto.Hospital;
import com.ty.springboot_project.repo.HospitalRepo;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepo repo;

	public Hospital saveHospital(Hospital hospital) {
		return repo.save(hospital);

	}

	public Hospital updateHospital(int id, Hospital hospital) {
		if (repo.findById(id).isPresent()) {
			Hospital hospital2 = repo.findById(id).get();
			hospital.setHid(id);

			return repo.save(hospital);
		}
		return null;
	}

	public Hospital deleteHospital(int id) {
		if (repo.findById(id).isPresent()) {
			Hospital hospital = repo.findById(id).get();
			repo.delete(hospital);
			return hospital;
		}
		return null;
	}

	public Hospital getById(int id) {
		if (repo.findById(id).isPresent()) {
			Hospital hospital = repo.findById(id).get();
			return hospital;
		}
		return null;
	}

	public Hospital getByEmail(String email) {
		return repo.getByEmail(email);
	}

	public List<Hospital> getAllHospital() {
		return repo.findAll();
	}
}
