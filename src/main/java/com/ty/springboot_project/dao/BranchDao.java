package com.ty.springboot_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_project.dto.Address;
import com.ty.springboot_project.dto.Branch;
import com.ty.springboot_project.dto.Hospital;
import com.ty.springboot_project.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepo branchRepo;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private AddressDao addressDao;

	public Branch saveBranch(Branch branch, int hid, int aid) {
		Hospital hospital = hospitalDao.getById(hid);
		Address address = addressDao.getById(aid);
		branch.setHospital(hospital);
		branch.setAddress(address);
		return branchRepo.save(branch);
	}

	public Branch updateBranch(Branch branch, int id) {
		if (branchRepo.findById(id).isPresent()) {
			Branch branch2 = branchRepo.findById(id).get();
			branch.setId(id);
			branch.setHospital(branch2.getHospital());
			branch.setAddress(branch2.getAddress());
			return branchRepo.save(branch);
		}
		return null;
	}

	public Branch deleteBranch(int id) {
		if (branchRepo.findById(id).isPresent()) {
			Branch branch = branchRepo.findById(id).get();
			branchRepo.delete(branch);
			return branch;
		}
		return null;
	}

	public Branch getBranchById(int id) {
		if (branchRepo.findById(id).isPresent()) {
			Branch branch = branchRepo.findById(id).get();
			return branch;
		}
		return null;
	}

	public List<Branch> getAllBranchByHospitalId(int hid) {
		Hospital hospital = hospitalDao.getById(hid);
		if (hospital != null) {
			List<Branch> branch = branchRepo.getAllBranchByHospitalId(hospital);
			return branch;
		}
		return null;
	}
}
