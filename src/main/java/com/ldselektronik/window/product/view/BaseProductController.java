package com.ldselektronik.window.product.view;

import java.io.IOException;

import com.ldselektronik.window.product.data.entity.Product;
import com.ldselektronik.window.product.data.entity.ProductCategory;
import com.ldselektronik.window.product.data.enums.Color;
import com.ldselektronik.window.product.data.enums.Size;
import com.ldselektronik.window.product.presentation.ProductWindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

/**
 * @author Baran
 *
 */
public class BaseProductController {

	private static final String PRODUCT_FXML = "product.fxml";

	@FXML
	protected StackPane rootPane;

	@FXML
	protected ComboBox<Integer> cboxYear;

	@FXML
	protected TableColumn<Product, ProductCategory> columnCategory;

	@FXML
	protected TextField fieldName;

	@FXML
	protected Button btnSearch;

	@FXML
	protected TableColumn<Product, Integer> columnCreditPrice;

	@FXML
	protected TextField fieldCashPrice;

	@FXML
	protected TableColumn<Product, Integer> columnId;

	@FXML
	protected TableColumn<Product, Integer> columnCashPrice;

	@FXML
	protected ComboBox<Size> cboxSize;

	@FXML
	protected ComboBox<ProductCategory> cboxCategory;

	@FXML
	protected TableColumn<Product, Integer> columnYear;

	@FXML
	protected Button btnSave;

	@FXML
	protected Button btnRefresh;

	@FXML
	protected TableColumn<Product, Size> columnSize;

	@FXML
	protected ComboBox<Color> cboxColor;

	@FXML
	protected TextField fieldCreditPrice;

	@FXML
	protected TableView<Product> tableProductEntities;

	@FXML
	protected TextField fieldId;

	@FXML
	protected TableColumn<Product, String> columnName;

	@FXML
	protected TableColumn<Product, Color> columnColor;

	protected ProductWindow presentation;

	public BaseProductController(ProductWindow presentation) {
		this.presentation = presentation;
		loadFXML();
		setTableColumns();
	}

	public StackPane getPane() {
		return rootPane;
	}

	private void setTableColumns() {
		columnCashPrice.setCellValueFactory(new PropertyValueFactory<>("cashPrice"));
		columnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
		columnColor.setCellValueFactory(new PropertyValueFactory<>("color"));
		columnCreditPrice.setCellValueFactory(new PropertyValueFactory<>("creditPrice"));
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnSize.setCellValueFactory(new PropertyValueFactory<>("size"));
		columnYear.setCellValueFactory(new PropertyValueFactory<>("year"));
	}

	protected Product toEntityFromFields() {
		Product entity = new Product();
		entity.setCashPrice(!fieldCashPrice.getText().isEmpty() ? Integer.valueOf(fieldCashPrice.getText()) : 0);
		entity.setCategory(cboxCategory.getSelectionModel().getSelectedItem());
		entity.setColor(cboxColor.getSelectionModel().getSelectedItem());
		entity.setCreditPrice(!fieldCreditPrice.getText().isEmpty() ? Integer.valueOf(fieldCreditPrice.getText()) : 0);
		entity.setId(!fieldId.getText().isEmpty() ? Integer.valueOf(fieldId.getText()) : 0);
		entity.setName(fieldName.getText());
		entity.setSize(cboxSize.getSelectionModel().getSelectedItem());
		entity.setYear(cboxYear.getSelectionModel().getSelectedItem());
		return entity;
	}

	protected void toFieldFromEntity(Product entity) {
		fieldCashPrice.setText(String.valueOf(entity.getCashPrice()));
		fieldCreditPrice.setText(String.valueOf(entity.getCreditPrice()));
		fieldId.setText(String.valueOf(entity.getId()));
		fieldName.setText(entity.getName());
		cboxCategory.getSelectionModel().select(entity.getCategory());
		cboxColor.getSelectionModel().select(entity.getColor());
		cboxSize.getSelectionModel().select(entity.getSize());
		cboxSize.getSelectionModel().select(entity.getYear());
	}

	protected void clearFields() {
		String empty = "";
		fieldCashPrice.setText(empty);
		fieldCreditPrice.setText(empty);
		fieldId.setText(empty);
		fieldName.setText(empty);
		refreshData();
		cboxCategory.getSelectionModel().selectFirst();
		cboxSize.getSelectionModel().selectFirst();
		cboxColor.getSelectionModel().selectFirst();
		cboxYear.getSelectionModel().selectLast();

	}

	protected void refreshData() {
		tableProductEntities.setItems(presentation.getAllProductEntity());
		cboxCategory.setItems(presentation.getAllProductCategories());
		cboxSize.setItems(presentation.getSizeList());
		cboxColor.setItems(presentation.getColorList());
		cboxYear.setItems(presentation.getYearList());
	}

	private void loadFXML() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(PRODUCT_FXML));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
