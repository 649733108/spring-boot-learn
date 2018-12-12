package com.wxn.springboot.controller;
/*
 * Created by wxn
 * 2018/12/12 23:05
 */

import com.wxn.springboot.Exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理器
 */
@ControllerAdvice
public class MyExceptionHandler {

	//没有自适应效果
//	@ResponseBody
//	@ExceptionHandler(UserNotExistException.class)
//	public Map<String, Object> handlerException(Exception e){
//		Map<String, Object> map = new HashMap<>();
//		map.put("code","user.notExist");
//		map.put("message",e.getMessage());
//		return map;
//	}

	@ExceptionHandler(UserNotExistException.class)
	public String handlerException(Exception e, HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();

		//传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
		/*
		 * Integer statusCode = (Integer) request
		 .getAttribute("javax.servlet.error.status_code");
		 */
		request.setAttribute("javax.servlet.error.status_code",500);
		map.put("code","user.notExist");
		map.put("message",e.getMessage());
		map.put("exception",e);
		request.setAttribute("ext",map);
		//转发到/error
		return "forward:/error";
	}
}
