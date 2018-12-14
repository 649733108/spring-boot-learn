package com.wxn.springboot.config;
/*
 * Created by wxn
 * 2018/12/13 18:13
 */

import com.wxn.springboot.filter.MyFilter;
import com.wxn.springboot.listener.MyListener;
import com.wxn.springboot.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;

@Configuration
public class MyServerConfig {

	/**
	 * 注册三大组件Servlet Filter Listener
	 */
	@Bean
	public ServletRegistrationBean<MyServlet> myServlet(){
		return new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
	}

	@Bean
	public FilterRegistrationBean<MyFilter> myFilter(){
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new MyFilter());
		registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
		return registrationBean;
	}
	@Bean
	public ServletListenerRegistrationBean<MyListener> myListener(){
		return new ServletListenerRegistrationBean<>(new MyListener());
	}



	/**
	 * 配置嵌入式Servlet容器
	 */
	@Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryWebServerFactoryCustomizer(){
		return factory -> factory.setPort(8083);
	}
}
