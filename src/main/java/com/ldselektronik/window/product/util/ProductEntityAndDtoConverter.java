package com.ldselektronik.window.product.util;

import com.ldselektronik.window.product.data.dto.ProductCategoryDto;
import com.ldselektronik.window.product.data.dto.ProductDto;
import com.ldselektronik.window.product.data.entity.ProductCategoryEntity;
import com.ldselektronik.window.product.data.entity.ProductEntity;

public final class ProductEntityAndDtoConverter {
	private ProductEntityAndDtoConverter() {
	}

	public static ProductCategoryDto toProductCategoryDto(ProductCategoryEntity from) {
		return new ProductCategoryDto(from.getId(), from.getName());
	}

	public static ProductCategoryEntity toProductCategoryEntity(ProductCategoryDto from) {
		ProductCategoryEntity entity = new ProductCategoryEntity();
		entity.setId(from.getId());
		entity.setName(from.getName());
		return entity;
	}

	public static ProductDto toProductDto(ProductEntity from) {
		ProductDto dto = new ProductDto();
		dto.setCashPrice(from.getCashPrice());
		dto.setCategory(toProductCategoryDto(from.getCategory()));
		dto.setColor(from.getColor());
		dto.setCreditPrice(from.getCreditPrice());
		dto.setId(from.getId());
		dto.setName(from.getName());
		dto.setSize(from.getSize());
		dto.setYear(from.getYear());
		return dto;
	}

	public static ProductEntity toProductEntity(ProductDto from) {
		ProductEntity entity = new ProductEntity();
		entity.setCashPrice(from.getCashPrice());
		entity.setCategory(toProductCategoryEntity(from.getCategory()));
		entity.setColor(from.getColor());
		entity.setCreditPrice(from.getCreditPrice());
		entity.setId(from.getId());
		entity.setName(from.getName());
		entity.setSize(from.getSize());
		entity.setYear(from.getYear());
		return entity;
	}

}
