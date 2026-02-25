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

    @GetMapping("/emp/{id}")
    public DeptEmpResponse getDeptWithAllEmployess(@PathVariable Long id)
    {
    		return deptService.getDeptWithAllEmployess(id);
    }
    
}
