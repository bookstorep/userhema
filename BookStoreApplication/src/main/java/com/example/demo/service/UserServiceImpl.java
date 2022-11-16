package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.sorting.SortBasedOnName;
@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	UserRepository userRepository;	
	@Override
	public User addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		User savedUser=userRepository.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUser() throws Exception {
		List<User> allUsers=userRepository.findAll();
		return allUsers;
		
		
	}

		@Override
	public User getUserByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.getUserByUserName(userName);
	}

	@Override
	public User getUserByRole(String role) throws Exception {


		return userRepository.getUserByRole(role);
	}

	@Override
	public  String delete(int userId) {


		  userRepository.deleteById(userId);
		  return "user deleted";
	}

	
	@Override
	public User getUserByUserId(int userId) throws Exception {
		
		return userRepository.getUserByUserId(userId);
	}

	@Override
	public List<User> getUsersBetweenIds(int range1, int range2) throws Exception {
		
		return userRepository.getUsersBetweenIds(range1, range2);
	}

	@Override
	public List<User> sortUserByUserName() throws Exception {
		// TODO Auto-generated method stub
		List<User> list=userRepository.findAll();
		List<User> user=new ArrayList<>();
		Collections.sort(list,new SortBasedOnName());
		
		return list;
	}

		

	/*@Override
	public User update(User user) throws Exception {
		// TODO Auto-generated method stub
		User existingUser=userRepository.findById(user.getUserId()).orElse(null);
		existingUser.setUserName(user.getUserName());
		existingUser.setRole(user.getRole());
		existingUser.setPassword(user.getPassword());
		return userRepository.save(existingUser);
	}*/

			

		


}
