package com.restapiproject.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapiproject.entity.Product;
import com.restapiproject.entity.User;
import com.restapiproject.exception.ProductNotFoundException;
import com.restapiproject.repository.UserRepository;
import com.restapiproject.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		log.debug("Control inside UserServiceImpl.findAllUsers()");
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		log.debug("Control inside UserServiceImpl.save()");
		return userRepository.save(user);
	}

	@Override
	public User findById(String userId) {
		log.debug("Control inside UserServiceImpl.findById()");
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public User findByName(String name) {
		log.debug("Control inside UserServiceImpl.findByName()");
		return null;
	}

	@Override
	public User updateUseryId(String userId, User user) {
		log.debug("Control inside UserServiceImpl.updateUseryId()");
		User existingUser = userRepository.findById(userId).orElse(null);
		if (existingUser == null) {
			throw new ProductNotFoundException(userId);
		}
		user.setId(existingUser.getId());
		BeanUtils.copyProperties(user, existingUser);
		return userRepository.save(existingUser);
	}

	@Override
	public boolean deleteUserById(String userId) {
		log.debug("Control inside UserServiceImpl.findAllUsers()");

		boolean status = false;
		try {
			userRepository.deleteById(userId);
			status = true;
		} catch (Exception e) {
			System.err.print("Error in deleting the user");
		}

		return status;

	}

}
