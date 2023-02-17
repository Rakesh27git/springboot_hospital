package com.ty.springboot_project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.AddressDao;
import com.ty.springboot_project.dto.Address;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		Address address2 = dao.saveAddress(address);
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(address2);
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address) {
		Address daoAddress = dao.updateAddress(id, address);
		if (daoAddress != null) {
			ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoAddress);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");
		}
	}
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
		Address daoAddress = dao.deleteAddress(id);
		if (daoAddress != null) {
			ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoAddress);

			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");
		}
	}
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id) {
		Address daoAddress = dao.getById(id);
		if (daoAddress != null) {
			ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(daoAddress);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Given Id Not Found");
		}
	}
}
