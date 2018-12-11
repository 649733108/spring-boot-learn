package com.wxn.springboot.controller;
/*
 * Created by wxn
 * 2018/12/12 1:46
 */

import com.wxn.springboot.dao.DepartmentDao;
import com.wxn.springboot.dao.EmployeeDao;
import com.wxn.springboot.entities.Department;
import com.wxn.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmpController {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;

	/**
	 * 获取员工列表 返回员工列表页面
	 */
	@GetMapping("/emps")
	public String list(Model model){
		Collection<Employee> emps = employeeDao.getAll();
		model.addAttribute("emps",emps);
		return "/emp/list";
	}

	/**
	 * 来到员工添加页面
	 */
	@GetMapping("emp")
	public String toAddPage(Model model){
		//查出所有的部门，在页面显示
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts",departments);
		return "/emp/add";
	}
}
