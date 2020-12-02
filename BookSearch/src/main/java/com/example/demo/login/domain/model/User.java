package com.example.demo.login.domain.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class User {
	private String userId;
	private String password;
	private String userName;
	private Date birthday;
	private int age;
	private String role;
}
