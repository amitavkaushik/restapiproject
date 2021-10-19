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

import com.restapiproject.entity.Product;
import com.restapiproject.exception.ProductNotFoundException;
import com.restapiproject.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public List<Product> findAllProducts() {
		log.info("Control inside ProductController.findAllProducts()");

		return productService.findAllProducts();
	}

	@GetMapping("/products/{productId}")
	public Product findOneProduct(@PathVariable String productId) {
		log.info("Control inside ProductController.findOneProduct()");

		return productService.findById(productId);
	}

	@GetMapping("/products-by-name/{name}")
	public Product findByName(@PathVariable String name) {
		log.info("Control inside ProductController.findByName()");
		return productService.findByName(name);
	}

	@PutMapping("/products/{productId}")
	public Product updateOneProduct(@PathVariable String productId, @RequestBody Product product)
			throws ProductNotFoundException {
		log.info("Control inside ProductController.updateOneProduct()");

		return productService.updateProductById(productId, product);
	}

	@DeleteMapping("/products/{productId}")
	public boolean deleteOneProduct(@PathVariable String productId) {
		log.info("Control inside ProductController.deleteOneProduct()");

		return productService.deleteProductById(productId);
	}

	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {
		log.info("Control inside ProductController.saveProduct()");

		Product newProduct = productService.save(product);

		return newProduct;
	}

}
