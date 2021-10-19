package com.restapiproject.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapiproject.entity.Product;
import com.restapiproject.exception.ProductNotFoundException;
import com.restapiproject.repository.ProductRepository;
import com.restapiproject.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> findAllProducts() {
		log.info("Control inside ProductServiceImpl.findAllProducts()");
		List<Product> productList = productRepository.findAllByOrderByName();

		return Stream.of(new Product("376", "Danile", 31, "USA"), new Product("958", "Huy", 35, "UK"),
				new Product("370", "Danile", 31, "USA")).collect(Collectors.toList());
	}

	@Override
	public Product save(Product product) {
		log.info("Control inside ProductServiceImpl.save()");
		return productRepository.save(product);
	}

	@Override
	public Product findById(String productId) {
		log.info("Control inside ProductServiceImpl.findById()");
		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public Product updateProductById(String productId, Product product) throws ProductNotFoundException {
		log.info("Control inside ProductServiceImpl.updateProductById()");

		Product existingProduct = productRepository.findById(productId).orElse(null);
		if (existingProduct == null) {
			throw new ProductNotFoundException(productId);
		}
		product.setId(existingProduct.getId());
		BeanUtils.copyProperties(product, existingProduct);
		return productRepository.save(existingProduct);

	}

	@Override
	public boolean deleteProductById(String productId) {
		log.info("Control inside ProductServiceImpl.deleteProductById()");
		boolean status = false;
		try {
			productRepository.deleteById(productId);
			status = true;
		} catch (Exception e) {
			System.err.print("Error in deleting the product");
		}

		return status;
	}

	@Override
	public Product findByName(String name) {
		log.info("Control inside ProductServiceImpl.findByName()");
		return productRepository.findByName(name);
	}

}
