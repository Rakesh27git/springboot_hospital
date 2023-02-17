package com.ty.springboot_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "name should not be blank")
	@NotNull(message = "name is mandatory")
	private String name;
	private long phone;
	@NotBlank(message = "manager should not be blank")
	@NotNull(message = "manager is mandatory")
	private String manager;
	@ManyToOne
	private Hospital hospital;

	@OneToOne
	private Address address;

}
