package com.szy.test.login.dao;

import com.szy.test.login.entity.User;
import com.szy.test.login.entity.UserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @Select({"select * from tb_test_user where name=#{name}"})
    @ResultMap("BaseResultMap")
    List<User> selectAll1(@Param("name")String x);
    
    
    @Select({"select * from tb_test_user where LOGIN_NAME=#{name} and LOGIN_PWD =#{pass}"})
    @ResultMap("BaseResultMap")
    User login(@Param("name")String name,@Param("pass")String pass);
    
    
}