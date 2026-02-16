package com.spc.emp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spc.emp.model.Employee;
import com.spc.emp.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	public EmployeeService empService;
	@PostMapping("/add")
	public Employee saveEmployee(@RequestBody Employee e) {
		Employee obj = empService.saveEmployee(e);
		return obj;
	}
	
}
