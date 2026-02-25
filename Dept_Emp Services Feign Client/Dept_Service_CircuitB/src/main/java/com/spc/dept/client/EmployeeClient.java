package com.spc.dept.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spc.dept.common.Employee;

@FeignClient(name= "emp-service")
public interface EmployeeClient {
	@GetMapping("/emp/dept/{id}")
    List<Employee> getEmployeesByDepartment(@PathVariable("id") Long deptId);
	
	
	@PostMapping("/emp/add")
    Employee addEmployee(@RequestBody Employee emp);
}
