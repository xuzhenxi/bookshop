package com.qfedu.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfedu.dao.IUserDao;
import com.qfedu.entity.User;
import com.qfedu.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User findByName(String userName) {
		User user = new User();
		
		try {
			user = userDao.findByName(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	
	@Override
	public void register(User user) {
		
		try {
			userDao.add(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
