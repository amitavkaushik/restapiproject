package com.restapiproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapiproject.entity.User;
import com.restapiproject.exception.ProductNotFoundException;
import com.restapiproject.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> findAllUsers() {
		log.info("Control inside UserController.findAllUsers()");

		return userService.findAllUsers();
	}

	@GetMapping("/users/{userId}")
	public User findOneUser(@PathVariable String userId) {
		log.info("Control inside UserController.findOneUser()");

		return userService.findById(userId);
	}

	@PutMapping("/users/{usersId}")
	public User updateOneUser(@PathVariable String usersId, @RequestBody User user)
			throws ProductNotFoundException {
		log.info("Control inside UserController.updateOneProduct()");

		return userService.updateUseryId(usersId, user);
	}

	@DeleteMapping("/users/{userId}")
	public boolean deleteOneUser(@PathVariable String userId) {
		log.info("Control inside UserController.deleteOneUser()");

		return userService.deleteUserById(userId);
	}

	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		log.info("Control inside UserController.saveUser()");

		User newUser = userService.save(user);

		return newUser;
	}
}
