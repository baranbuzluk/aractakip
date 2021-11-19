package com.ldselektronik.window.product.presentation.view;

import com.ldselektronik.util.JavaFxHelper;
import com.ldselektronik.window.product.data.entity.ProductCategoryEntity;
import com.ldselektronik.window.product.data.entity.ProductEntity;
import com.ldselektronik.window.product.data.enums.Color;
import com.ldselektronik.window.product.data.enums.Size;
import com.ldselektronik.window.product.presentation.window.ProductPresentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * @author Baran
 *
 */
public class BaseProductController {

	@FXML
	protected AnchorPane paneRoot;

	@FXML
	protected ComboBox<Integer> cboxYear;

	@FXML
	protected TableColumn<ProductEntity, ProductCategoryEntity> columnCategory;

	@FXML
	protected TextField fieldName;

	@FXML
	protected Button btnSearch;

	@FXML
	protected TableColumn<ProductEntity, Integer> columnCreditPrice;

	@FXML
	protected TextField fieldCashPrice;

	@FXML
	protected TableColumn<ProductEntity, Integer> columnId;

	@FXML
	protected TableColumn<ProductEntity, Integer> columnCashPrice;

	@FXML
	protected ComboBox<Size> cboxSize;

	@FXML
	protected ComboBox<ProductCategoryEntity> cboxCategory;

	@FXML
	protected TableColumn<ProductEntity, Integer> columnYear;

	@FXML
	protected Button btnSave;

	@FXML
	protected Button btnRefresh;

	@FXML
	protected TableColumn<ProductEntity, Size> columnSize;

	@FXML
	protected ComboBox<Color> cboxColor;

	@FXML
	protected TextField fieldCreditPrice;

	@FXML
	protected TableView<ProductEntity> tableProduct;

	@FXML
	protected TextField fieldId;

	@FXML
	protected TableColumn<ProductEntity, String> columnName;

	@FXML
	protected TableColumn<ProductEntity, Color> columnColor;

	protected ProductPresentation presentation;

	public BaseProductController(ProductPresentation presentation) {
		this.presentation = presentation;
		JavaFxHelper.loadFxml(this, "product.fxml");
		initTableColumns();
	}

	public Pane getPane() {
		return paneRoot;
	}

	private void initTableColumns() {
		// Init TableColumn
		columnCashPrice.setCellValueFactory(new PropertyValueFactory<>("cashPrice"));
		columnCategory.setCellValueFactory(new PropertyValueFactory<>("productCategory"));
		columnColor.setCellValueFactory(new PropertyValueFactory<>("color"));
		columnCreditPrice.setCellValueFactory(new PropertyValueFactory<>("creditPrice"));
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnSize.setCellValueFactory(new PropertyValueFactory<>("size"));
		columnYear.setCellValueFactory(new PropertyValueFactory<>("year"));
	}

	protected ProductEntity toDtoFromFields() {
		ProductEntity entity = new ProductEntity();
		entity.setCashPrice(!fieldCashPrice.getText().isEmpty() ? Integer.valueOf(fieldCashPrice.getText()) : 0);
		entity.setCategory(cboxCategory.getSelectionModel().getSelectedItem());
		entity.setColor(cboxColor.getSelectionModel().getSelectedItem());
		entity.setCreditPrice(fieldCreditPrice.getText().isEmpty() ? Integer.valueOf(fieldCreditPrice.getText()) : 0);
		entity.setId(!fieldId.getText().isEmpty() ? Integer.valueOf(fieldId.getText()) : 0);
		entity.setName(fieldName.getText());
		entity.setSize(cboxSize.getSelectionModel().getSelectedItem());
		entity.setYear(cboxYear.getSelectionModel().getSelectedItem());
		return entity;
	}

	protected void toFieldFromEntity(ProductEntity entity) {
		fieldCashPrice.setText(String.valueOf(entity.getCashPrice()));
		fieldCreditPrice.setText(String.valueOf(entity.getCreditPrice()));
		fieldId.setText(String.valueOf(entity.getId()));
		fieldName.setText(entity.getName());
		cboxCategory.getSelectionModel().select(entity.getCategory());
		cboxColor.getSelectionModel().select(entity.getColor());
		cboxSize.getSelectionModel().select(entity.getSize());
		cboxSize.getSelectionModel().select(entity.getYear());
	}

	protected void clearAndRefreshFields() {
		String empty = "";
		// Clear Fields
		fieldCashPrice.setText(empty);
		fieldCreditPrice.setText(empty);
		fieldId.setText(empty);
		fieldName.setText(empty);
		// Refresh Product TableView
		tableProduct.setItems(presentation.getAllProductEntity());
		// Refresh ProductCategory Combobox
		cboxCategory.setItems(presentation.getAllProductCategories());
		cboxCategory.getSelectionModel().selectFirst();
		// Refresh Size Combobox
		cboxSize.setItems(presentation.getSizeList());
		cboxSize.getSelectionModel().selectFirst();
		// Refresh Color Combobox
		cboxColor.setItems(presentation.getColorList());
		cboxColor.getSelectionModel().selectFirst();
		// Refresh Year Combobox
		cboxYear.setItems(presentation.getYearList());
		cboxYear.getSelectionModel().selectLast();
	}

}
