package com.example.demo.login.domain.service;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.IUserDao;

@Service
public class UserService implements IUserService{
	@Autowired
	@Qualifier("UserDaoJdbcImpl4")
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
	public void userCsvOut() throws DataAccessException{
		dao.userCsvOut();
	}
	public byte[] getFile(String fileName) throws IOException{
		FileSystem fs = FileSystems.getDefault();
		Path p = fs.getPath(fileName);
		
		byte[] bytes = Files.readAllBytes(p);
		
		return bytes;
	}
	
}
