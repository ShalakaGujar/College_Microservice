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

import com.spc.dept.model.Department;
import com.spc.dept.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;
	
	@PutMapping("/update")
	public Department updateDept(@RequestBody Department d)
	{
		Department obj = deptService.updateDept(d);
		return obj;
	}
	
//	@DeleteMapping("/{id}")
//	public Department deleteDept(@PathVariable Long id)
//	{
//		return deptService.deleteDept(id);
//	}
	@DeleteMapping("/{id}")
	public void deleteDept(@PathVariable Long id)
	{
		deptService.deleteDeptById(id);
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
		
	@GetMapping("/")
	public String greet()
	{
		return "Welcome to world of Java!!!";
	}
}
