package com.ldselektronik.window.carregistration.view;

import java.time.LocalDate;
import java.util.Date;

import com.ldselektronik.util.JavaFXHelper;
import com.ldselektronik.window.carregistration.entity.CarBrand;
import com.ldselektronik.window.carregistration.entity.CarRegistration;

import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class CarRegistrationController {

	private static final String CAR_REGISTRATION_FXML = "car_registration.fxml";

	@FXML
	private TableColumn<CarRegistration, String> columnLicense;

	@FXML
	private TextField fieldName;

	@FXML
	private Button btnSearch;

	@FXML
	private TableColumn<CarRegistration, String> columnCompany;

	@FXML
	private ComboBox<CarBrand> cboxBrand;

	@FXML
	private StackPane rootPane;

	@FXML
	private TableColumn<CarRegistration, Integer> columnId;

	@FXML
	private TextField fieldSurname;

	@FXML
	private TableView<CarRegistration> tableCarRegistrations;

	@FXML
	private TextField fieldDate;

	@FXML
	private TextField fieldDocumentNo;

	@FXML
	private TextField fieldCompanyName;

	@FXML
	private Button btnRegister;

	@FXML
	private Button btnRefresh;

	@FXML
	private TableColumn<CarRegistration, CarBrand> columnBrand;

	@FXML
	private Button btnDelete;

	@FXML
	private TextField fieldCarLicense;

	@FXML
	private TableColumn<CarRegistration, String> columnDocumentNo;

	@FXML
	private TableColumn<CarRegistration, Date> columnDate;

	@FXML
	private TextField fieldPhone;

	@FXML
	private TableColumn<CarRegistration, String> columnName;

	@FXML
	private TextField fieldId;

	public CarRegistrationController() {
		JavaFXHelper.loadFXML(CAR_REGISTRATION_FXML, this);
		initTable();
	}

	private void initTable() {
		columnBrand.setCellValueFactory(new PropertyValueFactory<>("carBrand"));
		columnCompany.setCellValueFactory(new PropertyValueFactory<>("companyName"));
		columnDate.setCellValueFactory(new PropertyValueFactory<>("createdTime"));
		columnDocumentNo.setCellValueFactory(new PropertyValueFactory<>("documentNo"));
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnLicense.setCellValueFactory(new PropertyValueFactory<>("carLicense"));
		columnName.setCellValueFactory(new PropertyValueFactory<>("nameAndSurname"));
		tableCarRegistrations.setPlaceholder(new Label("Tabloda gösterilecek veri yok"));
	}

	public CarRegistration fromFieldsToEntity() {
		CarRegistration entity = new CarRegistration();
		entity.setCarBrand(cboxBrand.getSelectionModel().getSelectedItem());
		entity.setCarLicense(fieldCarLicense.getText().isEmpty() ? null : fieldCarLicense.getText());
		entity.setCompanyName(fieldCompanyName.getText().isEmpty() ? null : fieldCompanyName.getText());
		entity.setDocumentNo(fieldDocumentNo.getText().isEmpty() ? null : fieldDocumentNo.getText());
		entity.setName(fieldName.getText().isEmpty() ? null : fieldName.getText());
		entity.setPhone(fieldPhone.getText().isEmpty() ? null : fieldPhone.getText());
		entity.setSurname(fieldSurname.getText().isEmpty() ? null : fieldSurname.getText());
		entity.setId(fieldId.getText().isEmpty() ? null : Integer.valueOf(fieldId.getText()));
		entity.setCreatedTime(fieldDate.getText().isEmpty() ? null : LocalDate.parse(fieldDate.getText()));
		return entity;
	}

	public void fromEntityToFields(CarRegistration entity) {
		fieldCarLicense.setText(entity.getCarLicense());
		fieldCompanyName.setText(entity.getCompanyName());
		fieldDate.setText(entity.getCreatedTime().toString());
		fieldDocumentNo.setText(entity.getDocumentNo());
		fieldId.setText(String.valueOf(entity.getId()));
		fieldName.setText(entity.getName());
		fieldPhone.setText(entity.getPhone());
		fieldSurname.setText(entity.getSurname());
		cboxBrand.getSelectionModel().select(entity.getCarBrand());
	}

	public void clearFields() {
		String empty = "";
		fieldCarLicense.setText(empty);
		fieldCompanyName.setText(empty);
		fieldDate.setText(LocalDate.now().toString());
		fieldDocumentNo.setText(empty);
		fieldId.setText(empty);
		fieldName.setText(empty);
		fieldPhone.setText(empty);
		fieldSurname.setText(empty);
		cboxBrand.getSelectionModel().selectFirst();
	}

	public void setCarBrandComboboxItems(ObservableList<CarBrand> list) {
		cboxBrand.setItems(list);
	}

	public void handleSelectedItemOnTableListener(ChangeListener<CarRegistration> value) {
		tableCarRegistrations.getSelectionModel().selectedItemProperty().addListener(value);
	}

	public void handleSaveButtonOnClicked(EventHandler<MouseEvent> value) {
		btnRegister.setOnMouseClicked(value);
	}

	public void handleDeleteButtonOnClicked(EventHandler<MouseEvent> value) {
		btnDelete.setOnMouseClicked(value);
	}

	public void handleRefreshButtonOnClicked(EventHandler<MouseEvent> value) {
		btnRefresh.setOnMouseClicked(value);
	}

	public void handleSearchButtonOnClicked(EventHandler<MouseEvent> value) {
		btnSearch.setOnMouseClicked(value);
	}

	public CarRegistration getSelectedCarRegistrationOnTable() {
		return tableCarRegistrations.getSelectionModel().getSelectedItem();
	}

	public void setCarRegistrationTableItems(ObservableList<CarRegistration> items) {
		tableCarRegistrations.setItems(items);
	}

	public void enableDocumentNoField() {
		fieldDocumentNo.setDisable(false);
	}

	public void disableDocumentNoField() {
		fieldDocumentNo.setDisable(true);
	}

	public void enableDeleteButton() {
		btnDelete.setDisable(false);
	}

	public void disableDeleteButton() {
		btnDelete.setDisable(true);
	}

	public StackPane getRootPane() {
		return rootPane;
	}

}
