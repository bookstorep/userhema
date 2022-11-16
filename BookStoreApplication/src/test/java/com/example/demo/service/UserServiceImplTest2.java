package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@SpringBootTest
class UserServiceImplTest2 {

	
	
	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userService;


	@Test
	@DisplayName("Adding the users")
	void testAddUser() throws Exception {
		User sampleInput = new User("A", "A", "user");
		User expectedOutput = new User("A", "A", "user");
		// Object obj = new Object();
		BDDMockito.given(userService.addUser(sampleInput)).willReturn(expectedOutput);

		// when
		User actualOutput = userService.addUser(sampleInput);

		// verify
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	@DisplayName("Getting all users")
	void testGetAllUser() throws Exception {
		User user1 = new User("hema", "hema112", "user");

		User user2 = new User("B", "B", "user");

		List<User> sampleOutput = new ArrayList<>();
		sampleOutput.add(user1);
		sampleOutput.add(user2);

		BDDMockito.given(userService.getAllUser()).willReturn(sampleOutput);

		// ----------------------------------------------------------------------

		// when :- readyto test the funcationality (service)
		List<User> actualOutput = userService.getAllUser();

		// then : verify the sampleOutput with actual output
		assertThat(actualOutput).isNotNull(); // or
		assertNotNull(actualOutput);
		 assertThat(actualOutput.size()).isGreaterThan(0);

		assertIterableEquals(sampleOutput, actualOutput);

	}

	@Test
	@DisplayName("Getting all user by userName")
	void testGetUserByUserName() throws Exception {
		User sampleOutput = new User("A", "A", "User");
		sampleOutput.setUserName("A");
		String sampleInput = "A";
		BDDMockito.given(userService.getUserByUserName(sampleInput)).willReturn(sampleOutput);

		// when
		User actualOutput = userService.getUserByUserName(sampleInput);

		// verify
		assertEquals(sampleOutput, actualOutput);
		assertSame(sampleOutput.getUserName(), actualOutput.getUserName());
	}

	@Test
	@DisplayName("Get users by role")
	void testGetUserByRole() throws Exception {
		User sampleOutput = new User("A", "A", "user");
		sampleOutput.setRole("user");
		String sampleInput = "user";
		BDDMockito.given(userService.getUserByRole(sampleInput)).willReturn(sampleOutput);

		// when
		User actualOutput = userService.getUserByRole(sampleInput);

		// verify
		assertEquals(sampleOutput, actualOutput);
		assertSame(sampleOutput.getRole(), actualOutput.getRole());
	}

	@Test
	@DisplayName("get all users by user id")
	void testGetUserByUserId() throws Exception {
		User sampleOutput = new User("A", "A", "user");
		sampleOutput.setUserId(1);

		int sampleInput = 1;

		BDDMockito.given(userService.getUserByUserId(sampleInput)).willReturn(sampleOutput);

		// when
		User actualOutput = userService.getUserByUserId(sampleInput);

		// verify
		assertEquals(sampleOutput, actualOutput);
		assertSame(sampleOutput.getUserId(), actualOutput.getUserId());
		 assertThat(actualOutput.getUserId()).isGreaterThan(0);

	}

	@Test
	@DisplayName("Get users between id")
	void testGetUsersBetweenIds() throws Exception {
		User user1 = new User("A", "A", "user");

		User user2 = new User("B", "B", "user");

		List<User> sampleOutput = new ArrayList<>();
		sampleOutput.add(user1);
		sampleOutput.add(user2);

		int sampleInput1 = 1;
		int sampleInput2 = 20;

		BDDMockito.given(userService.getUsersBetweenIds(sampleInput1, sampleInput2)).willReturn(sampleOutput);

		// when

		List<User> actualOutput = userService.getUsersBetweenIds(sampleInput1, sampleInput2);

		// verify
		assertEquals(sampleOutput, actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
		assertNotNull(actualOutput);

		
	}

}
