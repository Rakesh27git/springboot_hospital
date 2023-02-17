package com.ty.springboot_project.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "reason should not be blank")
	@NotNull(message = "reason is mandatory")
	private String reason;
	@NotBlank(message = "cost should not be blank")
	@NotNull(message = "cost is mandatory")
	private long cost;
	@ManyToOne
	private Person person;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Branch> branches;
}
