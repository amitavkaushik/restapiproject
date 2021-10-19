package com.restapiproject;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.restapiproject.entity.Product;
import com.restapiproject.repository.ProductRepository;
import com.restapiproject.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApiProjectApplicationTests {

	@Autowired
	ProductService productService;

	@MockBean
	ProductRepository productRepository;

	@Test
	public void getAllProducts_Success() {
		when(productRepository.findAllByOrderByName())
				.thenReturn(Stream.of(new Product("376", "Danile", 31, "USA"), new Product("958", "Huy", 35, "UK"))
						.collect(Collectors.toList()));
		assertEquals(2, productService.findAllProducts().size());
	}

	@Test
	public void getAllProducts_Failure() {
		when(productRepository.findAllByOrderByName())
		.thenReturn(Stream.of(new Product("376", "Danile", 31, "USA"), new Product("958", "Huy", 35, "UK"))
				.collect(Collectors.toList()));
		assertNotEquals(3, productService.findAllProducts().size());
	}

}
