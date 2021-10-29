package com.ldselektronik.window.product.util;

import com.ldselektronik.window.product.data.dto.ProductCategoryDto;
import com.ldselektronik.window.product.data.entity.ProductCategoryEntity;

public final class ProductEntityAndDtoConverter {
	private ProductEntityAndDtoConverter() {
	}

	public static ProductCategoryDto toProductCategoryDto(ProductCategoryEntity obj) {
		return new ProductCategoryDto(obj.getId(), obj.getName());
	}

	public static ProductCategoryEntity toProductCategoryEntity(ProductCategoryDto obj) {
		ProductCategoryEntity model = new ProductCategoryEntity();
		model.setId(obj.getId());
		model.setName(obj.getName());
		return model;
	}

}
