package com.itheima.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.MD5Utils;

@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void regist(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state("1");
		userDao.regist(user);
	}

	@Override
	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		return userDao.find(user);
	}

}
