package com.spc.dept.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spc.dept.common.Employee;

@FeignClient(name="emp-service")
public interface EmployeeClient {

	@GetMapping("/emp/dept/{deptId}")
    public List<Employee> getEmpByDeptId(@PathVariable Long deptId);
    
}
