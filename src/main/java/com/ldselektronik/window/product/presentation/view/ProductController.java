package com.ldselektronik.window.product.presentation.view;

import com.ldselektronik.configuration.SpringApplicationContext;
import com.ldselektronik.util.ControllerHelper;
import com.ldselektronik.window.product.data.dto.ProductCategoryDto;
import com.ldselektronik.window.product.data.enums.Color;
import com.ldselektronik.window.product.data.enums.Size;
import com.ldselektronik.window.product.service.ProductCategoryService;
import com.ldselektronik.window.product.service.ProductService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * @author Baran
 *
 */
public class ProductController {

	@FXML
	private AnchorPane paneRoot;

	@FXML
	private ComboBox<Integer> cboxYear;

	@FXML
	private TableColumn<?, ?> columnCategory;

	@FXML
	private TextField fieldName;

	@FXML
	private Button btnSearch;

	@FXML
	private TableColumn<?, ?> columnCreditPrice;

	@FXML
	private TextField fieldCashPrice;

	@FXML
	private TableColumn<?, ?> columnId;

	@FXML
	private TableColumn<?, ?> columnCashPrice;

	@FXML
	private ComboBox<Size> cboxSize;

	@FXML
	private ComboBox<ProductCategoryDto> cboxCategory;

	@FXML
	private TableColumn<?, ?> columnYear;

	@FXML
	private Button btnSave;

	@FXML
	private Button btnRefresh;

	@FXML
	private TableColumn<?, ?> columnSize;

	@FXML
	private ComboBox<Color> cboxColor;

	@FXML
	private TextField fieldCreditPrice;

	@FXML
	private TableView<?> tableProduct;

	@FXML
	private TextField fieldId;

	@FXML
	private TableColumn<?, ?> columnName;

	@FXML
	private TableColumn<?, ?> columnColor;

	private ProductCategoryService productCategoryService;

	private ProductService productService;

	public ProductController() {
		ControllerHelper.loadFxml(this, "product.fxml");
		productCategoryService = SpringApplicationContext.getBean(ProductCategoryService.class);
		productService = SpringApplicationContext.getBean(ProductService.class);
		init();
	}

	public Pane getPane() {
		return paneRoot;
	}

	private void init() {
		// Init ProductCategory Combobox
		cboxCategory.setItems(productCategoryService.getAll());
		cboxCategory.getSelectionModel().selectFirst();

		// Init Size Combobox
		cboxSize.setItems(productService.getSizeList());
		cboxSize.getSelectionModel().selectFirst();

		// Init Color Combobox
		cboxColor.setItems(productService.getColorList());
		cboxColor.getSelectionModel().selectFirst();

		// Init Year Combobox
		cboxYear.setItems(productService.getYearList());
		cboxYear.getSelectionModel().selectLast();

	}

}
