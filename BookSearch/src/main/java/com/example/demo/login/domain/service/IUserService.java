package com.example.demo.login.domain.service;

import java.util.List;


import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;

public interface IUserService {
	public int count();
	public boolean insert(SignupForm form);
	public User selectOne(String userId);
	public List<User> selectMany();
	public boolean updateOne(SignupForm form);
	public boolean deleteOne(String userId);
	public void userCsvOut();
}
