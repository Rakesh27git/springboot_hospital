package com.ty.springboot_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_project.dto.Branch;
import com.ty.springboot_project.service.BranchService;
import com.ty.springboot_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService service;

	@ApiOperation(value = "Save Branch", notes = " Api is used to save the branch for the given hospital id and address id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "Hospital not found for the given hospital id"),
			@ApiResponse(code = 404, message = "Address not found for the given address id") })
	@PostMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch, @RequestParam int hid,
			@RequestParam int aid) {
		return service.saveBranch(branch, hid, aid);
	}

	@ApiOperation(value = "Update Branch", notes = " Api is used to update the branch for the given branch id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Branch not found for the given branch id") })
	@PutMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch, @RequestParam int id) {
		return service.updateBranch(branch, id);
	}

	@ApiOperation(value = "Delete Branch", notes = " Api is used to delete the branch for the given branch id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Branch not found for the given branch id") })
	@DeleteMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id) {
		return service.deleteBranch(id);
	}

	@ApiOperation(value = "Get Branch By Id", notes = " Api is used to get the branch for the given branch id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched branch"),
			@ApiResponse(code = 404, message = "Branch not found for the given branch id") })
	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@RequestParam int id) {
		return service.getBranchById(id);
	}

	@ApiOperation(value = "Update Branch", notes = " Api is used to get all the branches for the given hospital id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched all branches"),
			@ApiResponse(code = 404, message = "Hospital not found for the given hospital id") })
	@GetMapping("/branchall")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHospitalId(@RequestParam int hid) {
		return service.getAllBranchByHospitalId(hid);
	}
}
