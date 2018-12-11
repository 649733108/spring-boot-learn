package com.wxn.springboot.controller;
/*
 * Created by wxn
 * 2018/12/10 1:30
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

//	@RequestMapping({"/","/index","/index.html"})
//	public String index(){
//		return "index";
//	}

	@ResponseBody
	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}

	@RequestMapping("success")
	public String success(Map<String ,Object> map){
		map.put("success","<h1>成功</h1>");
		map.put("users", Arrays.asList("张三","李四","王五"));

		return "success";

	}
}