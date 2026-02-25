package com.spc.dept.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spc.dept.common.DeptEmpRequest;
import com.spc.dept.common.DeptEmpResponse;
import com.spc.dept.model.Department;
import com.spc.dept.service.DepartmentService;


@RestController
@RequestMapping("/dept")
public class DepartmentController {

	private final DepartmentService deptService;
	
    public DepartmentController(DepartmentService deptService) {
        this.deptService = deptService;
        
    }

    @PostMapping("/add/with_emp")
    public DeptEmpResponse addDeptWithEmployees(@RequestBody DeptEmpRequest obj)
    {
    		return deptService.addDeptWithEmployees(obj);
    }
    
    @GetMapping("/{id}")
    public DeptEmpResponse getEmployeesByDepartment(@PathVariable Long id)
    {
    		return deptService.getEmployeesByDepartment(id);
    }
    

	@PostMapping("/add")
	public Department saveDept(@RequestBody Department d)
	{
		return deptService.saveDept(d);
	}
	
	
	@GetMapping("/all")
	public List<Department> getAllDeptInfo()
	{
		return deptService.getAllDeptInfo();
	}
		

}
