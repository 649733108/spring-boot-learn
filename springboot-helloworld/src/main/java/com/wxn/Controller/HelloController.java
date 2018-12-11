package com.wxn.Controller;
/*
 * Created by wxn
 * 2018/12/5 22:48
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
}
