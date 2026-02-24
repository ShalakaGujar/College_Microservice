package com.spc.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.spc.emp.model.Employee;
import com.spc.emp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository empRepo;

    public EmployeeService(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

	public Employee saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		return empRepo.save(e);
	}

	public List<Employee> getAllEmpDetails() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}
	
	public List<Employee> getEmpByDeptId(Long deptId) {
		// TODO Auto-generated method stub
		return empRepo.findByDeptId(deptId);
	}

	public List<Employee> saveEmployees(List<Employee> lstEmp) {
		// TODO Auto-generated method stub
		return empRepo.saveAll(lstEmp);
	}
}
