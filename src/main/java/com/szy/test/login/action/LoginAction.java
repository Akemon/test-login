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

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.szy.test.login.entity.User;
import com.szy.test.login.service.UserService;
import com.szy.test.login.util.MD5;

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
	private String code;
	private String isIdentify;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private User user;
	
	//用户service类
	@Autowired
	UserService userService;
	
	
	//md5工具类
	@Autowired
	MD5 md5;
	
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
		
		//判断是否输入完全
		if(name.equals("")||pass.equals("")||code.equals("")){
			message ="请输入完整！！！";
			return ERROR;
		}
		//判断验证码是否通过
		else{
			checkValidCode();
			if(isIdentify.equals("no")) {
				name="";
				pass="";
				message="验证码输入错误！！！";
				return ERROR; 
			}
		}
		//通过之后判断用户名与密码的匹配
		pass =md5.getMD5ofStr(name+pass);
		user = userService.login(name, pass);
		if(user!=null) return SUCCESS;
		else {
			message ="用户名或密码错误！！！";
			name="";
			pass="";
			return ERROR;
		}
		//System.out.println("姓名："+user.getName());
	//	System.out.println("name:"+name);
	//	System.out.println("login");
		//this.setTargetUrl("/index.jsp");
	//	return "redirect";
		
	}
	
	
	//检测验证码
		public void checkValidCode(){
			HttpServletResponse response = null;
			try{
				System.out.println("页面输入框传过来的code:"+code);
				ActionContext actionContext = ActionContext.getContext();
				Map session =actionContext.getSession();
				String validateCode=(String)session.get("imageCode");
				response = (HttpServletResponse)  
						ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);  
				System.out.println("系统生成的code:"+validateCode);
				//如果输入的跟生成的验证码相同，则通过
				if(code.equalsIgnoreCase(validateCode)){
					isIdentify="ok";
					System.out.println("是否通过 ："+isIdentify);
		 		}else{
		 			isIdentify="no";
					System.out.println("是否通过 ："+isIdentify);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}

}
