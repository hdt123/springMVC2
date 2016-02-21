package com.mvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mvc.dao.IUserDao;
import com.mvc.entity.User;
import com.mvc.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private IUserDao userDao;
	
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

}
