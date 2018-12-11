package com.wxn.springboot;

import com.wxn.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootHelloworldQuickApplicationTests {

	@Autowired
	Person person;

	@Autowired
	ApplicationContext ioc;

	//记录器
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void contextLoads() {

		//日志的级别：
		//由低到高：trace<debug<info<warn<error
		//可以调整输出的日志级别，日志就只会在这个级别以后的高级别生效
		logger.trace("这是trace日志");
		logger.debug("这是debug");
		//SpringBoot默认使用info级别，没有指定级别的就用默认：root级别
		logger.info("这是info");
		logger.warn("这是warn");
		logger.error("这是error");

		logger.info(person.toString());

	}

}
