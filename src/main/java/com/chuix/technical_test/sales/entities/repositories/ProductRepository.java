package com.chuix.technical_test.sales.entities.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Sort;

import com.chuix.technical_test.sales.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "select p from products p where :applyDate BETWEEN p.startDate and p.endDate and p.productId=:productId and p.brandId = :brandId", nativeQuery = false)
	public List<Product> getProductsByCriteria(
			@Param("applyDate") Date applyDate, 
			@Param("productId") Long productId, 
			@Param("brandId") Long brandId,
			Sort sort); 
}
