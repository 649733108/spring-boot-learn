package com.wxn.springboot.config;
/*
 * Created by wxn
 * 2018/12/10 3:48
 */

import com.wxn.springboot.component.LoginHandlerInterceptor;
import com.wxn.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用WebMvcConfigurerAdapter可以来扩展SpringMvc的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("/login");
	}

	//拦截器注册
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//静态资源；  *.css , *.js
		//SpringBoot已经做好了静态资源映射
		registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("/index","/login","/","/login.html","/user/login");
	}

	@Bean
	public WebMvcConfigurer webMvcConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/login").setViewName("login");
				registry.addViewController("/login.html").setViewName("login");
				registry.addViewController("/main.html").setViewName("dashboard");
			}
		};
	}

	@Bean
	public LocaleResolver localeResolver(){
		return new MyLocaleResolver();
	}



}
