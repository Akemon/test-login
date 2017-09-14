package com.szy.test.login.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.szy.test.login.dao.UserMapper;
import com.szy.test.login.entity.User;
@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	public void test(){
		System.out.println(userMapper);
		System.out.println(userMapper.selectByPrimaryKey(1).toString());
	}
	public User login(String name,String pass){
		return userMapper.login(name, pass);
	}
}
