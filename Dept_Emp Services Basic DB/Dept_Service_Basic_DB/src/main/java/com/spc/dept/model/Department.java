package com.spc.dept.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String deptName;
	private String deptAddr;
	private String deptCode;
	
//	@OneToMany(fetch = FetchType.LAZY,
//				mappedBy="department",
//				cascade = CascadeType.ALL)
//	private List<Employee> employee;
}
