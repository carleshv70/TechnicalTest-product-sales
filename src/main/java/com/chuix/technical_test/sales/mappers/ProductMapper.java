package com.chuix.technical_test.sales.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.chuix.technical_test.sales.entities.Product;
import com.chuix.technical_test.sales.model.ProductDto;

@Mapper(
		componentModel = "spring",
		unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	
	ProductDto mapToDto(Product entity);
	Product  mapToEntity(ProductDto dto);
}
