package com.spc.dept.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private Long id;
	private String name;
	private String designation;
	private String email;
	
	// add new
	private Long deptId;
}
