package com.example.demo.sorting;

import java.util.Comparator;

import com.example.demo.entity.User;

public class SortBasedOnName  implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return o1.getUserName().compareTo(o2.getUserName());
	}

}
