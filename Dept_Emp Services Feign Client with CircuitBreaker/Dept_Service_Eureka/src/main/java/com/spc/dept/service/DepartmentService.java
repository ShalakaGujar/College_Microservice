package com.spc.dept.service;


import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import com.spc.dept.client.EmployeeClient;
import com.spc.dept.common.DeptEmpResponse;
import com.spc.dept.common.Employee;
import com.spc.dept.model.Department;
import com.spc.dept.repository.DepartmentRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class DepartmentService {

	private final DepartmentRepository deptRepo;
	private final EmployeeClient empClient;
	
    public DepartmentService(
    			DepartmentRepository deptRepo,
    			EmployeeClient empClient) {
        this.deptRepo = deptRepo;
        this.empClient = empClient;
    }
    @CircuitBreaker(name="emp-service", fallbackMethod = "getEmpFallback")
    	public DeptEmpResponse getDeptWithAllEmployess(Long id) {
		// TODO Auto-generated method stub
		Department dept = deptRepo.findById(id).orElse(null);
		if(dept == null)
			return null;
		
		List<Employee> lstEmp = empClient.getEmpByDeptId(id);
		
		return new DeptEmpResponse(dept, 
					lstEmp,
					"Employee list is successfully fetched.");
	}
    
    public DeptEmpResponse getEmpFallback(Long id, Exception ex)
    {
    		Department dept = deptRepo.findById(id).orElse(null);
		if(dept == null)
			return null;
		
		return new DeptEmpResponse(dept, 
				Collections.emptyList(),
				"Temporarily employee service is unavailable. Please try later.");
    }
}
