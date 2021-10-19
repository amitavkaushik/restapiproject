package com.restapiproject.service;

import java.util.List;

import com.restapiproject.entity.User;

public interface UserService {
	
	List<User> findAllUsers();

	User save(User user);

	User findById(String userId);

	User findByName(String name);

	User updateUseryId(String userId, User user);

	boolean deleteUserById(String userId);
}
