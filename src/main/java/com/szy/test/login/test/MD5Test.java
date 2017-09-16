package com.szy.test.login.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.szy.test.login.util.MD5;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_context.xml"})
public class MD5Test {
	
	@Autowired
	MD5 md5;

	@Test
	public void getPass(){
		String newPass =md5.getMD5ofStr("hk123");
		System.out.println(newPass);
		
	}
	
	
}
