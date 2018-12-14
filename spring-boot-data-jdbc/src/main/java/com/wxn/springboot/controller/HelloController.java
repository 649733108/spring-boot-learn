package com.wxn.springboot.controller;
/*
 * Created by wxn
 * 2018/12/14 18:59
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@ResponseBody
	@RequestMapping("/hello")
	public List hello(){
		return jdbcTemplate.queryForList("select * from department");
	}
}
