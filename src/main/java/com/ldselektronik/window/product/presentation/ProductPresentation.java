package com.ldselektronik.window.product.presentation;

import java.util.Calendar;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ldselektronik.application.abstracts.IWindow;
import com.ldselektronik.window.product.data.entity.ProductCategoryEntity;
import com.ldselektronik.window.product.data.entity.ProductEntity;
import com.ldselektronik.window.product.data.enums.Color;
import com.ldselektronik.window.product.data.enums.Size;
import com.ldselektronik.window.product.service.ProductCategoryService;
import com.ldselektronik.window.product.service.ProductService;
import com.ldselektronik.window.product.view.ProductController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

/**
 * @author Baran
 *
 */
@Component
public class ProductPresentation implements IWindow {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductCategoryService productCategoryService;

	private ProductController controller;

	@PostConstruct
	void init() {
		controller = new ProductController(this);
	}

	public Pane getPane() {
		return controller.getPane();
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
				.observableArrayList(IntStream.range(startYear, nowYear + 1).boxed().collect(Collectors.toList()));
	}

	public ObservableList<ProductEntity> getAllProductEntity() {
		return FXCollections.observableArrayList(productService.getAllProductEntities());
	}

	public void saveProductEntity(ProductEntity entity) {
		productService.saveEntity(entity);
	}

	public ObservableList<ProductCategoryEntity> getAllProductCategories() {
		return FXCollections.observableArrayList(productCategoryService.getAllProductCategoriesEntities());
	}

	public ProductEntity findEntityById(int id) {
		return productService.findEntityById(id);
	}

}
