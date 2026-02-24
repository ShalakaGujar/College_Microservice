package com.spc.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.spc.dept.common.DeptEmpRequest;
import com.spc.dept.common.DeptEmpResponse;
import com.spc.dept.model.Department;
import com.spc.dept.service.DepartmentService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

	private final DepartmentService deptService;
	
    public DepartmentController(DepartmentService deptService) {
        this.deptService = deptService;
        
    }

    @PostMapping("/add/dept_emp")
    public Mono<DeptEmpResponse> addDeptWithEmployees(@RequestBody DeptEmpRequest obj)
    {
    	return deptService.addDeptWithEmployees(obj);
    }
    
    @GetMapping("/emp/{id}")
    public Mono<DeptEmpResponse> getDeptWithAllEmployess(@PathVariable Long id)
    {
    	return deptService.getDeptWithAllEmployess(id);
    }
    
	@PostMapping("/add")
	public Department saveDept(@RequestBody Department d)
	{
		System.out.printf("Dept obj : ", d);
		return deptService.saveDept(d);
	}
	
	@GetMapping("/{id}")
	public Department getDeptInfo(@PathVariable Long id)
	{
		System.out.println(id);
		Department d = deptService.getDeptInfo(id);
		return d;
	}
	
	@GetMapping("/all")
	public List<Department> getAllDeptInfo()
	{
		return deptService.getAllDeptInfo();
	}
}
