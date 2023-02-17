package com.ty.springboot_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "area should not be blank")
	@NotNull(message = "area is mandatory")
	private String area;
	@NotBlank(message = "street should not be blank")
	@NotNull(message = "street is mandatory")
	private String street;
	@NotBlank(message = "city should not be blank")
	@NotNull(message = "city is mandatory")
	private String city;
	@NotBlank(message = "state should not be blank")
	@NotNull(message = "state is mandatory")
	private String state;
	private int pincode;

}
