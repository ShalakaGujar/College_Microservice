package com.spc.emp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
}
