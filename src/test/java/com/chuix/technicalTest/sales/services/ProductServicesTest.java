package com.chuix.technicalTest.sales.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.chuix.technical_test.sales.TechnicalTestProductSalesApplication;
import com.chuix.technical_test.sales.entities.Product;
import com.chuix.technical_test.sales.entities.repositories.ProductRepository;

@ContextConfiguration(classes = TechnicalTestProductSalesApplication.class)
@DataJpaTest(showSql = true)
class ProductServicesTest {

	@Autowired
	private ProductRepository repository;
	
	@Test
	public void should_find_products() {
		Iterable products = repository.findAll();

		assertThat(products).isNotEmpty();
	}

	@Test
	void should_get_price1() {
		
		LocalDateTime ldt = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
		Long producto = 35455l;
		Long brand = 1l;

		List<Product> products = this.repository.getProductsByCriteria(ldt, producto, brand);

		Assertions.assertThat(products.get(0).getPrice()).isEqualTo(35.50);
	}

	@Test
	void should_get_price2() {

		
		LocalDateTime ldt = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
		Long producto = 35455l;
		Long brand = 1l;

		List<Product> products = this.repository.getProductsByCriteria(ldt, producto, brand);

		Assertions.assertThat(products.get(0).getPrice()).isEqualTo(25.45);
	}

	@Test
	void should_get_price3() {
		
		LocalDateTime ldt = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
		Long producto = 35455l;
		Long brand = 1l;

		List<Product> products = this.repository.getProductsByCriteria(ldt, producto, brand);

		Assertions.assertThat(products.get(0).getPrice()).isEqualTo(35.50);
	}

	@Test
	void should_get_price4() {
		
		LocalDateTime ldt = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
		Long producto = 35455l;
		Long brand = 1l;

		List<Product> products = this.repository.getProductsByCriteria(ldt, producto, brand);

		Assertions.assertThat(products.get(0).getPrice()).isEqualTo(30.50);
	}

	
	@Test
	void should_get_price5() {
		
		LocalDateTime ldt = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
		Long producto = 35455l;
		Long brand = 1l;

		List<Product> products = this.repository.getProductsByCriteria(ldt, producto, brand);

		Assertions.assertThat(products.get(0).getPrice()).isEqualTo(38.95);
	}

	
	
}
