package com.ldselektronik.product.presentation;

import java.util.Calendar;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ldselektronik.abstracts.ITabWindow;
import com.ldselektronik.product.data.entity.Product;
import com.ldselektronik.product.data.entity.ProductCategory;
import com.ldselektronik.product.data.enums.Color;
import com.ldselektronik.product.data.enums.Size;
import com.ldselektronik.product.service.ProductCategoryService;
import com.ldselektronik.product.service.ProductService;
import com.ldselektronik.product.view.ProductController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;

/**
 * @author Baran
 * 
 */
@Component
public class ProductWindow implements ITabWindow {

	private static final String TAB_NAME = "Ürünler";

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductCategoryService productCategoryService;

	private ProductController controller;

	@PostConstruct
	void init() {
		controller = new ProductController(this);
	}

	@Override
	public StackPane getTabPane() {
		return controller.getPane();
	}

	@Override
	public String getTabTitleName() {
		return TAB_NAME;
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

	public ObservableList<Product> getAllProductEntity() {
		return FXCollections.observableArrayList(productService.getAllProductEntities());
	}

	public void saveProductEntity(Product entity) {
		productService.saveEntity(entity);
	}

	public ObservableList<ProductCategory> getAllProductCategories() {
		return FXCollections.observableArrayList(productCategoryService.getAllProductCategoriesEntities());
	}

	public Product findEntityById(int id) {
		return productService.findEntityById(id);
	}

}
