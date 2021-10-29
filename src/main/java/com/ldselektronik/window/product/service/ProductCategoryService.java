package com.ldselektronik.window.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldselektronik.window.product.data.dto.ProductCategoryDto;
import com.ldselektronik.window.product.data.entity.ProductCategoryEntity;
import com.ldselektronik.window.product.data.repository.ProductCategoryRepository;
import com.ldselektronik.window.product.util.ProductEntityAndDtoConverter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Baran
 *
 */
@Service
@Transactional
public class ProductCategoryService {
	@Autowired
	ProductCategoryRepository repository;

	public ObservableList<ProductCategoryDto> getAll() {
		List<ProductCategoryEntity> categoryList = repository.findAll();
		// Converts ProductCategoryEntity object to ProductCategoryDto object
		List<ProductCategoryDto> categoryDtoList = categoryList.stream()
				.map(category ->ProductEntityAndDtoConverter.toProductCategoryDto(category)).collect(Collectors.toList());
		return FXCollections.observableArrayList(categoryDtoList);
	}
}
