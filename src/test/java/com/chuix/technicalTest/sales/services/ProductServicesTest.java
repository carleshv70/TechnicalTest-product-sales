package com.chuix.technicalTest.sales.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.chuix.technical_test.sales.TechnicalTestProductSalesApplication;
import com.chuix.technical_test.sales.entities.Product;
import com.chuix.technical_test.sales.entities.repositories.ProductRepository;
import com.chuix.technical_test.sales.entities.services.ProductServices;


//@SpringBootTest()
@ContextConfiguration(classes = TechnicalTestProductSalesApplication.class)
@DataJpaTest(showSql = true)
//@AutoConfigureTestDatabase(replace =Replace.NONE)
class ProductServicesTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ProductRepository repository;
	
	  @Test
	  public void should_find_products_if_repository_is_empty() {
	    Iterable products = repository.findAll();

	    assertThat(products).isNotEmpty();
	  }
	
	
	/*
	
	-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	*/
	
	// Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)

	  void getPrice1() {
		
		Date dt = new Date(2020, 6, 16, 0, 0);
		Long producto = 35455l;
		Long brand = 1l;
		
		List<Product> products = this.repository.getProductsByCriteria(dt, producto, brand, Sort.by(Direction.DESC, "priority"));
		
		Assertions.assertThat(products.get(0).getPrice()).isEqualTo(30.50);
	}
}
