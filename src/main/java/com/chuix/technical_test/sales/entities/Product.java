package com.chuix.technical_test.sales.entities;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;
import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name ="products")
@Data
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "ID")
	private Long id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "BRAND_ID")
	private Long brandId;
	
	@Column(name = "START_DATE")
	private Date  startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "PRICE_LIST")
	private Integer priceList; 
	
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "PRIORITY")
	private Integer priority;

	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "CURR")
	private String currency; 
	
	private static final long serialVersionUID = -261236061895253340L;
}
