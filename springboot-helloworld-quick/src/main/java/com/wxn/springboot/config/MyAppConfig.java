package com.wxn.springboot.config;
/*
 * Created by wxn
 * 2018/12/6 4:26
 */

import com.wxn.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration: 指明当前类是一个配置类，来替代之前的spring配置文件
 *
 * 在配置文件中用<bean><bean/>标签添加组件
 *
 */
@Configuration
public class MyAppConfig {

	//将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
	@Bean
	public HelloService helloService(){
		System.out.println("配置类@Bean给容器添加组件");
		return new HelloService();
	}
}
