package com.szy.test.login.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.szy.test.login.util.ImageUtil;

public class IdentifyAction extends ActionSupport {
	private InputStream imageStream;
	//存储系统生成的验证码
	private Map session;

	public Map getSession() {
		return session;
	}


	public void setSession(Map session) {
		this.session = session;
	}


	public InputStream getImageStream() {
		return imageStream;
	}


	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}


	//生成验证码
	public String createValidCode(){
		//1调用组件生成图片和验证码
		Map<String,BufferedImage> imageMap = ImageUtil.createImage();
		//2将验证码记录到Session,验证时要用
		String imageCode = imageMap.keySet().iterator().next();
		ActionContext actionContext = ActionContext.getContext();
		session = actionContext.getSession();
		session.put("imageCode", imageCode);
		System.out.println("===========存入session中的code:"+imageCode);
		//3将生成的图片转换成输入流，赋值给输出属性
		BufferedImage image = imageMap.get(imageCode);
		try {
			imageStream = ImageUtil.getInputStream(image);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		//4返回success,找到对应的result做输出
		return "success";

	}

	
}
