package com.ty.springboot_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.BranchDao;
import com.ty.springboot_project.dto.Branch;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao dao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hid, int aid) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		Branch branch2 = dao.saveBranch(branch, hid, aid);
		structure.setMessage("Successfully saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(branch2);
		return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch, int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		Branch branch2 = dao.updateBranch(branch, id);
		if (branch2 != null) {
			structure.setMessage("Successfully updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch2);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		Branch branch = dao.deleteBranch(id);
		if (branch != null) {
			structure.setMessage("Successfully deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch);

			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		Branch branch = dao.getBranchById(id);
		if (branch != null) {
			structure.setMessage("Successfully fetched");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch);

			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHospitalId(int hid) {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<>();
		List<Branch> branch = dao.getAllBranchByHospitalId(hid);
		if (branch != null) {
			structure.setMessage("Successfully fetched all branches");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch);

			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}

	}
}
