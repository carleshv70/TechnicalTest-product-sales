package com.chuix.technical_test.sales.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductDto {

	private Long id;
	private Long brandId;
	private Long productId;
	private Integer priceList;
	private Double price;	
	private LocalDateTime  startDate;
	private LocalDateTime endDate;
}
