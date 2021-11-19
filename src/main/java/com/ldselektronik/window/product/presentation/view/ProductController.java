package com.ldselektronik.window.product.presentation.view;

import com.ldselektronik.configuration.SpringApplicationContext;
import com.ldselektronik.util.JavaFxHelper;
import com.ldselektronik.window.product.data.dto.ProductCategoryDto;
import com.ldselektronik.window.product.data.dto.ProductDto;
import com.ldselektronik.window.product.data.enums.Color;
import com.ldselektronik.window.product.data.enums.Size;
import com.ldselektronik.window.product.service.ProductCategoryService;
import com.ldselektronik.window.product.service.ProductService;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
	private TableColumn<ProductDto, ProductCategoryDto> columnCategory;

	@FXML
	private TextField fieldName;

	@FXML
	private Button btnSearch;

	@FXML
	private TableColumn<ProductDto, Integer> columnCreditPrice;

	@FXML
	private TextField fieldCashPrice;

	@FXML
	private TableColumn<ProductDto, Integer> columnId;

	@FXML
	private TableColumn<ProductDto, Integer> columnCashPrice;

	@FXML
	private ComboBox<Size> cboxSize;

	@FXML
	private ComboBox<ProductCategoryDto> cboxCategory;

	@FXML
	private TableColumn<ProductDto, Integer> columnYear;

	@FXML
	private Button btnSave;

	@FXML
	private Button btnRefresh;

	@FXML
	private TableColumn<ProductDto, Size> columnSize;

	@FXML
	private ComboBox<Color> cboxColor;

	@FXML
	private TextField fieldCreditPrice;

	@FXML
	private TableView<ProductDto> tableProduct;

	@FXML
	private TextField fieldId;

	@FXML
	private TableColumn<ProductDto, String> columnName;

	@FXML
	private TableColumn<ProductDto, Color> columnColor;

	private ProductCategoryService productCategoryService;

	private ProductService productService;

	public ProductController() {
		JavaFxHelper.loadFxml(this, "product.fxml");
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

		// Init TableColumn
		columnCashPrice.setCellValueFactory(new PropertyValueFactory<>("cashPrice"));
		columnCategory.setCellValueFactory(new PropertyValueFactory<>("productCategory"));
		columnColor.setCellValueFactory(new PropertyValueFactory<>("color"));
		columnCreditPrice.setCellValueFactory(new PropertyValueFactory<>("creditPrice"));
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnSize.setCellValueFactory(new PropertyValueFactory<>("size"));
		columnYear.setCellValueFactory(new PropertyValueFactory<>("year"));

		// Init Product Table
		tableProduct.setItems(productService.getAllProductDto());
		tableProduct.getSelectionModel().selectedIndexProperty().addListener(listenerSelectedTableRow);

		// Init Button OnMouseClickedEvents
		btnSave.setOnMouseClicked(handlerBtnSave);
		btnRefresh.setOnMouseClicked(handlerBtnRefresh);

	}

	private ProductDto toDtoFromFields() {
		ProductDto dto = new ProductDto();
		int cash = !fieldCashPrice.getText().isEmpty() ? Integer.valueOf(fieldCashPrice.getText()) : 0;
		dto.setCashPrice(cash);
		dto.setCategory(cboxCategory.getSelectionModel().getSelectedItem());
		dto.setColor(cboxColor.getSelectionModel().getSelectedItem());
		int credit = !fieldCreditPrice.getText().isEmpty() ? Integer.valueOf(fieldCreditPrice.getText()) : 0;
		dto.setCreditPrice(credit);
		int id = !fieldId.getText().isEmpty() ? Integer.valueOf(fieldId.getText()) : 0;
		dto.setId(id);
		dto.setName(fieldName.getText());
		dto.setSize(cboxSize.getSelectionModel().getSelectedItem());
		dto.setYear(cboxYear.getSelectionModel().getSelectedItem());
		return dto;
	}

	private void toFieldFromDto(ProductDto dto) {
		fieldCashPrice.setText(String.valueOf(dto.getCashPrice()));
		fieldCreditPrice.setText(String.valueOf(dto.getCreditPrice()));
		fieldId.setText(String.valueOf(dto.getId()));
		fieldName.setText(dto.getName());
		cboxCategory.getSelectionModel().select(dto.getCategory());
		cboxColor.getSelectionModel().select(dto.getColor());
		cboxSize.getSelectionModel().select(dto.getSize());
		cboxSize.getSelectionModel().select(dto.getYear());
	}

	private void clearFields() {
		String empty = "";
		fieldCashPrice.setText(empty);
		fieldCreditPrice.setText(empty);
		fieldId.setText(empty);
		fieldName.setText(empty);
		cboxCategory.getSelectionModel().selectFirst();
		cboxColor.getSelectionModel().selectFirst();
		cboxSize.getSelectionModel().selectFirst();
		cboxYear.getSelectionModel().selectLast();
	}

	private EventHandler<MouseEvent> handlerBtnSave = event -> {
		productService.save(toDtoFromFields());
		tableProduct.setItems(productService.getAllProductDto());
		clearFields();
	};

	private EventHandler<MouseEvent> handlerBtnRefresh = event -> {
		tableProduct.setItems(productService.getAllProductDto());
		clearFields();
	};

	ChangeListener<Number> listenerSelectedTableRow = (ObservableValue<? extends Number> observable, Number oldValue,
			Number newValue) -> {

		ProductDto selected = tableProduct.getSelectionModel().getSelectedItem();
		if (selected != null) { // when table row is select
			toFieldFromDto(productService.findById(selected.getId()));

		} else {
			clearFields();
		}

	};

}
