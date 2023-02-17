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

import com.ty.springboot_project.dto.MedOrders;
import com.ty.springboot_project.service.MedOrdersService;
import com.ty.springboot_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrdersController {

	@Autowired
	private MedOrdersService medOrdersService;

	@ApiOperation(value = "Save MedOrders", notes = " Api is used to save the MedOrders based on encounter id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "Encounter not found for the given encounter id ") })
	@PostMapping("/medOrders")
	public ResponseEntity<ResponseStructure<MedOrders>> saveMedOrders(@RequestBody MedOrders medOrders,
			@RequestParam int encounter_id) {
		return medOrdersService.saveMedOrders(medOrders, encounter_id);
	}

	@ApiOperation(value = "Upadte MedOrders", notes = " Api is used to update the MedOrders based on medOrder id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "MedOrder not found for the given medOrder id ") })
	@PutMapping("/medOrders")
	public ResponseEntity<ResponseStructure<MedOrders>> updateMedOrders(@RequestBody MedOrders medOrders,
			@RequestParam int order_id) {
		return medOrdersService.updateMedOrders(medOrders, order_id);
	}

	@ApiOperation(value = "Delete MedOrders", notes = " Api is used to delete the MedOrders based on medOrder id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "MedOrder not found for the given medOrder id ") })
	@DeleteMapping("/medOrders")
	public ResponseEntity<ResponseStructure<MedOrders>> deleteMedOrders(@RequestParam int order_id) {
		return medOrdersService.deleteMedOrders(order_id);
	}

	@ApiOperation(value = "Get MedOrders By Id", notes = " Api is used to get the MedOrders based on medOrder id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "MedOrder not found for the given medOrder id ") })
	@GetMapping("/medOrders")
	public ResponseEntity<ResponseStructure<MedOrders>> getMedOrderById(@RequestParam int order_id) {
		return medOrdersService.getMedOrdersById(order_id);
	}

	@ApiOperation(value = "Get MedOrders By Id", notes = " Api is used to get the MedOrders based on encounter id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched All the medOrders"),
			@ApiResponse(code = 404, message = "Encounter not found for the given encounter id ") })
	@GetMapping("/medOrdersAll")
	public ResponseEntity<ResponseStructure<List<MedOrders>>> getAllMedOrders(@RequestParam int encounter_id) {
		return medOrdersService.getAllMedOrders(encounter_id);
	}

}
