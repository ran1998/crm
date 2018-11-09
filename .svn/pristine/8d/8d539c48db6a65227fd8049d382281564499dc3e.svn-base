package com.itheima.web.action;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 用户注册
	public String regist() {
		userService.regist(user);
		return LOGIN;
	}
	// 用户登录
	public String login() {
		User existsUser = userService.login(user);
		if (null == existsUser) {
			// 登录失败
			this.addActionError("用户名或密码错误");
			return LOGIN;
		} else {
			// 登录成功
			ServletActionContext.getRequest().getSession().setAttribute("user", existsUser);
			return SUCCESS;
		}
	}

}
