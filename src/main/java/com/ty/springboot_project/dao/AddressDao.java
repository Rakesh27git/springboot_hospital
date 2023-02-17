package com.ty.springboot_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.springboot_project.dto.Address;
import com.ty.springboot_project.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepo addressRepo;
	public Address saveAddress(Address address) {
		return addressRepo.save(address);

	}
	public Address updateAddress(int id, Address address) {
		if (addressRepo.findById(id).isPresent()) {
			Address address2 = addressRepo.findById(id).get();
			address.setId(id);

			return addressRepo.save(address);
		}
		return null;
	}
	public Address deleteAddress(int id) {
		if (addressRepo.findById(id).isPresent()) {
			Address address = addressRepo.findById(id).get();
			addressRepo.delete(address);
			return address;
		}
		return null;
	}
	public Address getById(int id) {
		if (addressRepo.findById(id).isPresent()) {
			Address Address = addressRepo.findById(id).get();
			return Address;
		}
		return null;
	}
	public List<Address> getAllAddress() {
		return addressRepo.findAll();
	}
}
