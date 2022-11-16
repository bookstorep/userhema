package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;



@Service
public interface UserService {
	public User addUser(User user) throws Exception;
	public List<User> getAllUser() throws Exception;
	public  String  delete(int  id);


	public User getUserByUserName(String userName) throws Exception;
	public User getUserByRole(String role) throws Exception;
	public User getUserByUserId(int userId) throws Exception;
	public List<User> getUsersBetweenIds(int range1,int range2)throws Exception;
	public List<User> sortUserByUserName() throws Exception;

	}
