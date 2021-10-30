package com.ldselektronik.window.product.service;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldselektronik.window.product.data.dto.ProductDto;
import com.ldselektronik.window.product.data.entity.ProductEntity;
import com.ldselektronik.window.product.data.enums.Color;
import com.ldselektronik.window.product.data.enums.Size;
import com.ldselektronik.window.product.data.repository.ProductRepository;
import com.ldselektronik.window.product.util.ProductEntityAndDtoConverter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Baran
 *
 */
@Service
@Transactional
public class ProductService {
	@Autowired
	ProductRepository repository;
	
	@Autowired
	Logger logger;

	public ObservableList<ProductDto> getAllProductDto() {
		List<ProductEntity> productEntityList = repository.findAll();
		List<ProductDto> productDtoList = productEntityList.stream()
				// Converts ProductEntity object to ProductDto object
				.map(productEntity -> ProductEntityAndDtoConverter.toProductDto(productEntity))
				.collect(Collectors.toList());
		return FXCollections.observableArrayList(productDtoList);
	}

	public ObservableList<Color> getColorList() {
		return FXCollections.observableArrayList(Color.values());
	}

	public ObservableList<Size> getSizeList() {
		return FXCollections.observableArrayList(Size.values());
	}

	public ObservableList<Integer> getYearList() {
		int nowYear = Calendar.getInstance().get(Calendar.YEAR);
		int startYear = nowYear - 20;
		return FXCollections
				.observableArrayList(IntStream
						.range(startYear, nowYear + 1)
						.boxed()
						.collect(Collectors.toList()));
	}
	
	/**
	 * If there is the object has same <code>documentNo</code> value in the table,
	 * The object is not saved to the table but is updated.
	 * 
	 */
	public void save(ProductDto productDto) {
		if (productDto == null) {
			logger.log(Level.WARNING, "Error ProductDto object is null! - The object was not saved.");
			return;
		}
		repository.save(ProductEntityAndDtoConverter.toProductEntity(productDto));
	}
}
