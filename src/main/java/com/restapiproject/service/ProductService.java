package com.restapiproject.service;

import java.util.List;

import com.restapiproject.entity.Product;
import com.restapiproject.exception.ProductNotFoundException;

public interface ProductService {
	List<Product> findAllProducts();

	Product save(Product product);

	Product findById(String productId);
	
	Product findByName(String name);

	Product updateProductById(String productId, Product product) throws ProductNotFoundException;
	
	boolean deleteProductById(String productId);
}
