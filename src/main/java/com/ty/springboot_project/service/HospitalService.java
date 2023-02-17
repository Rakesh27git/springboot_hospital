package com.ty.springboot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.HospitalDao;
import com.ty.springboot_project.dto.Hospital;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.saveHospital(hospital));

		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {

		Hospital daoHospital = dao.updateHospital(id, hospital);
		if (daoHospital != null) {
			ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoHospital);

			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
		Hospital daoHospital = dao.deleteHospital(id);
		if (daoHospital != null) {
			ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoHospital);

			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");

		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		Hospital daoHospital = dao.getById(id);
		if (daoHospital != null) {
			ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(daoHospital);

			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Given Id Not Found");

		}
	}

}
