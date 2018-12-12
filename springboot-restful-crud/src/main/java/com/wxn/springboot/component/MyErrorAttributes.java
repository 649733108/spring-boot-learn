package com.wxn.springboot.component;
/*
 * Created by wxn
 * 2018/12/12 23:33
 */


import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 给容器中加入自定义的ErrorAttributes
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> map = super.getErrorAttributes(webRequest, true);
		map.put("name","wxn");
		map.put("ext",webRequest.getAttribute("ext",0));
		return map;
	}
}
