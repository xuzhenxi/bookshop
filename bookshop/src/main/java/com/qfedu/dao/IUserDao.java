package com.qfedu.dao;

import com.qfedu.entity.User;

public interface IUserDao {

	public User findByName(String userName);
	
	public void add(User user);
}
