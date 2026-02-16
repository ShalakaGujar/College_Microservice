package com.spc.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spc.emp.model.Employee;
import com.spc.emp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	public EmployeeRepository empRepo;

	public Employee saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		return empRepo.save(e);
	}
}
