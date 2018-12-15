package com.wxn.springboot.controller;
/*
 * Created by wxn
 * 2018/12/15 17:42
 */

import com.sun.org.apache.regexp.internal.RE;
import com.wxn.springboot.bean.Department;
import com.wxn.springboot.bean.Employee;
import com.wxn.springboot.mapper.DepartmentMapper;
import com.wxn.springboot.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class DeptController {

	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;

	@GetMapping("/dept/{id}")
	public Department getDept(@PathVariable Integer id){
		return departmentMapper.getDeptById(id);
	}

	@GetMapping("/dept")
	public Department insertDept(Department department){
		departmentMapper.insertDept(department);
		return department;
	}

	@GetMapping("/emp/{id}")
	public Employee getEmp(@PathVariable Integer id){
		return employeeMapper.getEmpById(id);
	}

	@GetMapping("/emp")
	public Employee insertEmp(Employee employee){
		employeeMapper.insertEmp(employee);
		return employee;
	}
}
