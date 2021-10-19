package com.restapiproject.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.restapiproject.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	@Query("{'name' : ?0, deletedFlag: false }")
	Product findByName(String name);

	List<Product> findAllByOrderByName();
}
