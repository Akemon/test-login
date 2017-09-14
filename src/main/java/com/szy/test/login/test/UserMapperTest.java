package com.szy.test.login.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.szy.test.login.dao.UserMapper;
import com.szy.test.login.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_context.xml"})
public class UserMapperTest {

	@Autowired
	UserMapper userMapper;
	
	@Test
	public void testCRUD(){
		System.out.println(userMapper);
		User user =userMapper.selectByPrimaryKey(1);
		System.out.println("name:"+user.getName());
		
	}
	
	
	
}
