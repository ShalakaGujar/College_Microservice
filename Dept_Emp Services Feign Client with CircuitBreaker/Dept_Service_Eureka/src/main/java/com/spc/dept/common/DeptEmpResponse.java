package com.spc.dept.common;

import java.util.List;

import com.spc.dept.model.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptEmpResponse {
	private Department dept;
    private List<Employee> employees;
    private String msg;
}
