package com.qfedu.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.entity.User;
import com.qfedu.service.IUserService;
import com.qfedu.util.JsonUtil;
import com.qfedu.vo.JsonBean;

@Controller
public class UserController {

	@Autowired
	IUserService userService;
	
	@RequestMapping("/login")
	public String login(String userName, String password, HttpSession session){
		
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		// 设置 记住我=true
//		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();

		try {
			subject.login(token);
			session.setAttribute("userName", userName);
			return "redirect:index.html";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return "redirect:login.html";
		}
		
	}
	
	
	@RequestMapping("/register")
	@ResponseBody
	public JsonBean register(User user) {
		
		if(user == null) {
			return JsonUtil.JsonBeanS(0, "用户为空，注册失败");
		}
		
		try {
			userService.register(user);
			
			return JsonUtil.JsonBeanS(1, null);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.JsonBeanS(0, e.getMessage());
		}
		
		
	}
}
