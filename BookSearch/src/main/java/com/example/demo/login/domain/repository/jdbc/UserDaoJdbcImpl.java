package com.example.demo.login.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.IUserDao;

@Repository("UserDaoJdbcImpl")
public class UserDaoJdbcImpl implements IUserDao{
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	private User user;

	@Override
	public int count() throws DataAccessException {
		int count = jdbc.queryForObject("SELECT COUNT(*) FROM m_user",Integer.class);
		return count;
	}

	@Override
	public int insertOne(SignupForm form) throws DataAccessException {
		user.setUserId(form.getUserId());
		user.setPassword(form.getPassword());
		user.setUserName(form.getUserName());
		user.setBirthday(form.getBirthday());
		user.setAge(form.getAge());
		user.setRole("ROLE_GENERAL");
		
		int rowNumber = jdbc.update(""
				+ " INSERT INTO m_user("
				+ " user_id,"
				+ " password,"
				+ " user_name,"
				+ " birthday,"
				+ " age,"
				+ " role)"
				+ " VALUES(?,?,?,?,?,?)"
				, user.getUserId()
				, user.getPassword()
				, user.getUserName()
				, user.getBirthday()
				, user.getAge()
				, user.getRole());
				
			return rowNumber;
				
	}

	@Override
	public User selectOne(String userId) throws DataAccessException {
		Map<String,Object> map = jdbc.queryForMap("SELECT * FROM m_user WHERE user_id = ?",userId);
		user.setUserId((String)map.get("user_id"));
		user.setPassword((String)map.get("password"));
		user.setUserName((String)map.get("user_name"));
		user.setBirthday((Date)map.get("birthday"));
		user.setAge((Integer)map.get("age"));
		user.setRole((String)map.get("role"));
		return user;
	}

	@Override
	public List<User> selectMany() throws DataAccessException {
		List<Map<String,Object>> getList = jdbc.queryForList("SELECT * FROM m_user");
		List<User> userList = new ArrayList<>();
		for(Map<String,Object> map:getList) {
			user.setUserId((String)map.get("user_id"));
			user.setPassword((String)map.get("password"));
			user.setUserName((String)map.get("user_name"));
			user.setBirthday((Date)map.get("birthday"));
			user.setAge((int)map.get("age"));
			user.setRole((String)map.get("role"));
			
			userList.add(user);
		}
		return userList;
	}

	@Override
	public int updateOne(SignupForm form) throws DataAccessException {
		user.setUserId(form.getUserId());
		user.setPassword(form.getPassword());
		user.setUserName(form.getUserName());
		user.setBirthday(form.getBirthday());
		user.setAge(form.getAge());
		int rowNumber = jdbc.update("UPDATE M_USER"
				+ " SET"
				+ " password = ?,"
				+ " user_name = ?,"
				+ " birthday = ?,"
				+ " age = ?"
				+ " WHERE user_id = ?"
				, user.getPassword()
				, user.getUserName()
				, user.getBirthday()
				, user.getAge()
				, user.getUserId());
		return rowNumber;
	}

	@Override
	public int deleteOne(String userId) throws DataAccessException {
		int rowNumber = jdbc.update("DELETE FROM m_user WHERE user_id = ?",userId);
		return rowNumber;
	}

	@Override
	public void userCsvOut() throws DataAccessException {
		String sql = "SELECT * FROM m_user";
		UserRowCallbackHandler handler = new UserRowCallbackHandler();
		jdbc.query(sql, handler);
	}
}
