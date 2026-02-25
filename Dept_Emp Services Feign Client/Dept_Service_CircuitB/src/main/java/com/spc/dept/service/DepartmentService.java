package com.spc.dept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spc.dept.client.EmployeeClient;
import com.spc.dept.common.DeptEmpRequest;
import com.spc.dept.common.DeptEmpResponse;
import com.spc.dept.common.Employee;
import com.spc.dept.model.Department;
import com.spc.dept.repository.DepartmentRepository;


@Service
public class DepartmentService {

	private final DepartmentRepository deptRepo;
	private final EmployeeClient empClient;
	
    public DepartmentService(
    			DepartmentRepository deptRepo,
    			EmployeeClient empClient) 
    {
    		this.deptRepo = deptRepo;
    		this.empClient = empClient;
    }
    
	public List<Department> getAllDeptInfo() {
		// TODO Auto-generated method stub
		return deptRepo.findAll();
	}

	public Department getDeptInfo(Long id) {
		// TODO Auto-generated method stub
		Optional<Department> obj = deptRepo.findById(id);
		Department d = obj.get();
		return d;
	}

	public Department saveDept(Department d) {
		// TODO Auto-generated method stub
		Department obj =deptRepo.save(d);
		return obj;
	}

	public DeptEmpResponse getEmployeesByDepartment(Long id) {
		// TODO Auto-generated method stub
		Department obj = deptRepo.findById(id).orElse(null);
		if(obj == null)
			return null;
		
		List<Employee> lstEmp = empClient.getEmployeesByDepartment(id);
		return new DeptEmpResponse(
					obj, 
					lstEmp);
	}

	public DeptEmpResponse addDeptWithEmployees(DeptEmpRequest obj) {
		// TODO Auto-generated method stub
		// 1. Save department (blocking – acceptable in MVC apps)
		Department dept =deptRepo.save(obj.getDept());
				
		if(obj.getEmployees() != null)
		{
			obj.getEmployees()
				.forEach(emp->{
				emp.setDeptId(dept.getId());
				empClient.addEmployee(emp);
				});
		}
		// 3. RETURN the WebClient reactive chain
		return getEmployeesByDepartment(dept.getId());
	}
}
