package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody User user) {

		try {
			User savedUser = userService.addUser(user);
			String responseMsg = savedUser.getUserName() + " save with Id " + savedUser.getUserId();
			mylogs.info("A value is added ");
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/userid/{searchUserId}")
	public void deleteUser(@PathVariable int searchUserId) {
		try {
			userService.delete(searchUserId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PutMapping("/userid/{userId}")
	public   User updateUser(@PathVariable int userId, @RequestBody User userDetails) throws Exception {
		userService.getUserByUserId(userId);
		userDetails.setUserId(userId);
		User updateUser = userService.addUser(userDetails);
		return updateUser;
	}
	 
	 }

/*
 * @GetMapping("/sortname") public List<User> getAllUsers() { try { //List<User>
 * allExtractedUsers=userService.getAllUSer(); List<User> sortedList =
 * getAllUsers().stream() .sorted(Comparator.comparing(User::getName))
 * .collect(Collectors.toList()); List<User>
 * allExtractedUsers=getAllUsers().stream().sorted(Comparator.reverseOrder()).
 * forEach(System.out::println); return allExtractedUsers; }catch(Exception e) {
 * System.out.println(e); } return null;
 * 
 * }
 */

/*
 * @PutMapping("/user/{id}") public ResponseEntity<User>
 * updateUser(@PathVariable int id, @RequestBody User user) {
 * 
 * //check if employee exist in database User userObj =
 * userService.getUserByUserId(id);
 * 
 * if (userObj != null) { userObj.setUserName(user.getUserName());
 * userObj.setRole(user.getRole()); return new
 * ResponseEntity<>(userService.save(userObj), HttpStatus.OK); }
 * 
 * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 * 
 * 
 * }
 */

/*
 * @GetMapping("username/{searchUserName}") public User
 * getUserByUserName(@PathVariable String searchUserName) throws Exception {
 * return userService.getUserByUserName(searchUserName); }
 * 
 * @GetMapping("userrole/{searchUserRole}") public User
 * getUserByUserRole(@PathVariable String searchUserRole) throws Exception {
 * return userService.getUserByRole(searchUserRole); }
 */
