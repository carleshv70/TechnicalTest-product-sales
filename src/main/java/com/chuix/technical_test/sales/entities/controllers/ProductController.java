package com.chuix.technical_test.sales.entities.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chuix.technical_test.sales.entities.services.ProductServices;
import com.chuix.technical_test.sales.mappers.ProductMapper;
import com.chuix.technical_test.sales.model.ProductDto;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductServices service;
	
	@Autowired
	private ProductMapper mapper;
	
	@GetMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> getProducts(
			@RequestParam(name ="application-date")  @DateTimeFormat(pattern="yyyy-MM-dd") Date applyDate,
			@RequestParam(name = "product-id") Long productId,
			@RequestParam(name = "brand-id") Long brandId
			) {
		Map<String,Object> response = new HashMap<>();

		try {
			response.put("product", this.mapper.mapToDto(this.service.getProducts(applyDate, productId, brandId)));
		}
		catch (IllegalArgumentException ex) {
			response.put("Error", ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

}
