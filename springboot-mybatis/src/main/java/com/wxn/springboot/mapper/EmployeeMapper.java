package com.wxn.springboot.mapper;
/*
 * Created by wxn
 * 2018/12/15 18:03
 */


import com.wxn.springboot.bean.Employee;

//@Mapper 或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

	public Employee getEmpById(Integer id);

	public int insertEmp(Employee employee);
}
