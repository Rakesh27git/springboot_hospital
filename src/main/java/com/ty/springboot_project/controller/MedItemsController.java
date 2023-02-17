package com.ty.springboot_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_project.dto.MedItems;
import com.ty.springboot_project.service.MedItemsService;
import com.ty.springboot_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedItemsController {

	@Autowired
	private MedItemsService medItemsService;

	@ApiOperation(value = "Save MedItems", notes = " Api is used to save the MedItems based on medOrder id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "MedOrder not found for the given medOrder id ") })
	@PostMapping("/medItems")
	public ResponseEntity<ResponseStructure<MedItems>> savemedItems(@RequestBody MedItems medItems,
			@RequestParam int order_id) {
		return medItemsService.saveMedItems(medItems, order_id);
	}

	@ApiOperation(value = "Update MedItems", notes = " Api is used to update the MedItems based on medItems id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "MedItems not found for the given medItems id ") })
	@PutMapping("/medItems")
	public ResponseEntity<ResponseStructure<MedItems>> updatemedItems(@RequestBody MedItems medItems,
			@RequestParam int items_id) {
		return medItemsService.updateMedItems(medItems, items_id);
	}

	@ApiOperation(value = "Delete MedItems", notes = " Api is used to delete the MedItems based on medItems id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "MedItems not found for the given medItems id ") })

	@DeleteMapping("/medItems")
	public ResponseEntity<ResponseStructure<MedItems>> deletemedItems(@RequestParam int items_id) {
		return medItemsService.deleteMedItems(items_id);
	}

	@ApiOperation(value = "Get MedItems By Id", notes = " Api is used to get the MedItems based on medItems id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "MedItems not found for the given medItems id ") })

	@GetMapping("/medItems")
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(@RequestParam int items_id) {
		return medItemsService.getMedItemsById(items_id);
	}

	@ApiOperation(value = "Get All MedItems", notes = " Api is used to get all the MedItems based on medItems id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched All MedItems"),
			@ApiResponse(code = 404, message = "MedItems not found for the given medItems id ") })

	@GetMapping("/medItemsAll")
	public ResponseEntity<ResponseStructure<List<MedItems>>> getAllmedItems(@RequestParam int order_id) {
		return medItemsService.getAllMedItems(order_id);
	}

}
