package com.mvc.dao;

import com.mvc.entity.User;


public interface IUserDao {

	User findById(Integer id);
}
