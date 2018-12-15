package com.wxn.springboot.controller;
/*
 * Created by wxn
 * 2018/12/15 19:35
 */

import com.wxn.springboot.dao.UserDao;
import com.wxn.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		User user = userDao.findById(id).orElse(null);
		return user;
	}

	@GetMapping("/user")
	public User insertUser(User user) {
		return userDao.save(user);
	}
}
