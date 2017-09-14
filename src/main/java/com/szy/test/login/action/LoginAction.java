/**  
 * All rights Reserved, Designed By www.gxjxcp.cn
 * @Title:  LoginAction.java   
 * @Package com.szy.test.login.action   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: xiao_xgy     
 * @date:   2017年9月10日 下午3:19:14   
 * @version V1.0 
 * @Copyright: 2017 www.gxjxcp.cn Inc. All rights reserved. 
 * 注意：本内容仅限于科若为股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.szy.test.login.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.opensymphony.xwork2.ActionSupport;
import com.szy.test.login.entity.User;
import com.szy.test.login.service.UserService;

/**
 * @ClassName: LoginAction
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: xiao_xgy
 * @date: 2017年9月10日 下午3:19:14
 */
@ContextConfiguration(locations={"classpath:spring_context.xml"})
public class LoginAction extends ActionSupport {
	private String targetUrl;
	private String name;
	private String pass;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private User user;
	
	@Autowired
	UserService userService;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public String login() throws Exception {
		// http://localhost:8080/test-login/Login_login.action
		
		user = userService.login(name, pass);
		if(user!=null) return SUCCESS;
		else return ERROR;
		//System.out.println("姓名："+user.getName());
	//	System.out.println("name:"+name);
	//	System.out.println("login");
		//this.setTargetUrl("/index.jsp");
	//	return "redirect";
		
	}

}
