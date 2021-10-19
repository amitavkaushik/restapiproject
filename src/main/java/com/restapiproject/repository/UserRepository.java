package com.restapiproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.restapiproject.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

}
