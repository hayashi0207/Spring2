package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.IUserDao;

@Service
public class UserService implements IUserService{
	@Autowired
	@Qualifier("UserDaoJdbcImpl2")
	IUserDao dao;
	
	@Override
	public boolean insert(SignupForm form) {
		
		int rowNumber = dao.insertOne(form);
		boolean result = false;
		if(rowNumber > 0) {
			result=true;
		}
		return result;
	}
	
	@Override
	public int count() {
		return dao.count();
	}
	@Override
	public List<User> selectMany() {
		return dao.selectMany();
	}
	@Override
	public User selectOne(String userId) {
		return dao.selectOne(userId);
	}

	@Override
	public boolean updateOne(SignupForm form) {
		
		int rowNumber = dao.updateOne(form);
		boolean result = false;
		if(rowNumber>0) {
			result=true;
		}
		return result;
	}

	@Override
	public boolean deleteOne(String userId) {
		int rowNumber = dao.deleteOne(userId);
		boolean result = false;
		if(rowNumber>0) {
			result = true;
		}
		return result;
	}

	@Override
	public void userCsvOut() {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}
