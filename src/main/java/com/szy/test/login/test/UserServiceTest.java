package com.szy.test.login.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.szy.test.login.service.UserService;

public class UserServiceTest {
	
	private UserService userService;
	
	@Before
	public void init(){
		ApplicationContext ac = new FileSystemXmlApplicationContext("G:\\java代码\\teacher project\\test-login\\src\\main\\resources\\spring_context.xml");
		userService=ac.getBean(UserService.class);
	}
	
	@Test
	public void test(){
		System.err.println("isNull?\t"+userService==null);
		userService.test();
		System.out.println("End!");
	}
}
