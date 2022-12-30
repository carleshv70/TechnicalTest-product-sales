package com.chuix.technical_test.sales.entities.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chuix.technical_test.sales.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "select p from Product p where :applyDate >= p.startDate and  :applyDate < p.endDate and p.productId=:productId and p.brandId = :brandId ORDER BY p.priority DESC", nativeQuery = false)
	public List<Product> getProductsByCriteria(
			@Param("applyDate") LocalDateTime applyDate, 
			@Param("productId") Long productId, 
			@Param("brandId") Long brandId); 
}
