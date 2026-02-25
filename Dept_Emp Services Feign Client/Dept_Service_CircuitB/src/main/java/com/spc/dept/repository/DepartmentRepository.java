package com.spc.dept.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spc.dept.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> 
{

}
