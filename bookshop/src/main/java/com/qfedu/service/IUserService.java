package com.qfedu.service;

import com.qfedu.entity.User;

public interface IUserService {

	
	public User findByName(String userName);
	
	public void register(User user);
}
