package com.example.demo.login.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao dao;	
	@Autowired
	private User user;
	
	public boolean insert(SignupForm form) {
		
		user.setUserId(form.getUserId());
		user.setPassword(form.getPassword());
		user.setUserName(form.getUserName());
		user.setBirthday(form.getBirthday());
		user.setAge(form.getAge());
		user.setRole("ROLE_GENERAL");
		
		int rowNumber = dao.insertOne(user);
		boolean result = false;
		if(rowNumber > 0) {
			result=true;
		}
		return result;
	}
}
