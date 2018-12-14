package com.wxn.springboot.config;
/*
 * Created by wxn
 * 2018/12/14 19:28
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置Druid数据源
 */
@Configuration
public class DruidConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druid(){
		return new DruidDataSource();
	}

	//配置Druid的监控
	//1.配置一个管理后台的Servlet
	@Bean
	public ServletRegistrationBean statViewServlet(){
		ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
		Map<String,String>initParams = new HashMap<>();
		initParams.put("loginUsername","admin");
		initParams.put("loginPassword","123456");
		initParams.put("allow","");//默认允许所以访问
		initParams.put("deny","");
		bean.setInitParameters(initParams);
		return bean;
	}
	//2.配置一个监控的filter
	@Bean
	public FilterRegistrationBean webStatFilter(){
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new WebStatFilter());
		Map<String,String>initParams = new HashMap<>();
		initParams.put("exclusions","*.js,*.css,/druid/*");
		bean.setInitParameters(initParams);
		bean.setUrlPatterns(Arrays.asList("/*"));
		return bean;
	}
}
