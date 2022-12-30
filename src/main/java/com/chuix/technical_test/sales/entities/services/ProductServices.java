package com.chuix.technical_test.sales.entities.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuix.technical_test.sales.entities.Product;
import com.chuix.technical_test.sales.entities.repositories.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository repository;
	
	public Product getProducts(LocalDateTime applyDate, Long productId, Long brandId) {
		
		List<Product> products = this.repository.getProductsByCriteria(applyDate, productId, brandId);
		if( products.isEmpty()) {
			throw new IllegalArgumentException("There are any product");
		}
		return products.get(0);
	}


}
