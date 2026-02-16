package com.spc.dept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spc.dept.model.Department;
import com.spc.dept.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository deptRepo;
	
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

	public Department updateDept(Department d) {
		// TODO Auto-generated method stub
		Optional <Department> obj = deptRepo.findById(d.getId());
		Department d1 = null;
		if(obj != null)
		{
			d1 = obj.get(); //Get department object
			d1.setDeptName(d.getDeptName());
			d1.setDeptAddr(d.getDeptAddr());
			d1.setDeptCode(d.getDeptCode());
			deptRepo.save(d1);
		}
		else
		{
			// no object present
		}
		return d1;
	}

	public Department deleteDept(Long id) {
		// TODO Auto-generated method stub
		Optional<Department> obj = deptRepo.findById(id);
		Department d1 = null;
		if(obj != null)
		{
			d1 = obj.get();
			deptRepo.delete(d1);
		}
		else
		{
			
		}
		return d1;
	}
	
	public void deleteDeptById(Long id) {
		// TODO Auto-generated method stub
		deptRepo.deleteById(id);
	}

}
