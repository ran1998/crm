package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {

	void regist(User user);

	User find(User user);

}
