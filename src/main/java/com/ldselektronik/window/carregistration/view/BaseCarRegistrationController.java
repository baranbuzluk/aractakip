package com.ldselektronik.window.carregistration.view;

import java.util.Date;

import com.ldselektronik.util.JavaFxHelper;
import com.ldselektronik.window.carregistration.data.entity.CarBrandEntity;
import com.ldselektronik.window.carregistration.data.entity.CarRegistrationEntity;
import com.ldselektronik.window.carregistration.presentation.CarRegistrationPresentation;

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
public class BaseCarRegistrationController {

	@FXML
	protected TableColumn<CarRegistrationEntity, String> columnLicense;

	@FXML
	protected TextField fieldName;

	@FXML
	protected Button btnSearch;

	@FXML
	protected TableColumn<CarRegistrationEntity, String> columnCompany;

	@FXML
	protected ComboBox<CarBrandEntity> cboxBrand;

	@FXML
	protected AnchorPane rootPane;

	@FXML
	protected TableColumn<CarRegistrationEntity, Integer> columnId;

	@FXML
	protected TextField fieldSurname;

	@FXML
	protected TableView<CarRegistrationEntity> tableRegistration;

	@FXML
	protected TextField fieldDate;

	@FXML
	protected TextField fieldDocumentNo;

	@FXML
	protected TextField fieldCompanyName;

	@FXML
	protected Button btnRegister;

	@FXML
	protected Button btnRefresh;

	@FXML
	protected TableColumn<CarRegistrationEntity, CarBrandEntity> columnBrand;

	@FXML
	protected Button btnDelete;

	@FXML
	protected TextField fieldCarLicense;

	@FXML
	protected TableColumn<CarRegistrationEntity, String> columnDocumentNo;

	@FXML
	protected TableColumn<CarRegistrationEntity, Date> columnDate;

	@FXML
	protected TextField fieldPhone;

	@FXML
	protected TableColumn<CarRegistrationEntity, String> columnName;

	@FXML
	protected TextField fieldId;

	protected CarRegistrationPresentation presentation;

	public BaseCarRegistrationController(CarRegistrationPresentation presentation) {
		this.presentation = presentation;
		JavaFxHelper.loadFxml(this, "car_registration.fxml");
		initTableColumn();
	}

	public Pane getRootPane() {
		return rootPane;
	}

	private void initTableColumn() {
		columnBrand.setCellValueFactory(new PropertyValueFactory<>("carBrand"));
		columnCompany.setCellValueFactory(new PropertyValueFactory<>("companyName"));
		columnDate.setCellValueFactory(new PropertyValueFactory<>("createdTime"));
		columnDocumentNo.setCellValueFactory(new PropertyValueFactory<>("documentNo"));
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnLicense.setCellValueFactory(new PropertyValueFactory<>("carLicense"));
		columnName.setCellValueFactory(new PropertyValueFactory<>("nameAndSurname"));
	}

	public CarRegistrationEntity toEntityFromFields() {
		CarRegistrationEntity entity = new CarRegistrationEntity();
		entity.setCarBrand(cboxBrand.getSelectionModel().getSelectedItem());
		entity.setCarLicense(fieldCarLicense.getText());
		entity.setCompanyName(fieldCompanyName.getText());
		entity.setDocumentNo(fieldDocumentNo.getText());
		entity.setName(fieldName.getText());
		entity.setPhone(fieldPhone.getText());
		entity.setSurname(fieldSurname.getText());
		entity.setId(!fieldId.getText().isEmpty() ? Integer.valueOf(fieldId.getText()) : 0);
		return entity;
	}

	public void toFieldFromEntity(CarRegistrationEntity entity) {

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

	public void clearAndRefreshAllFields() {
		String empty = "";
		fieldCarLicense.setText(empty);
		fieldCompanyName.setText(empty);
		fieldDate.setText(empty);
		fieldDocumentNo.setText(empty);
		fieldId.setText(empty);
		fieldName.setText(empty);
		fieldPhone.setText(empty);
		fieldSurname.setText(empty);
		cboxBrand.setItems(presentation.getAllCarBrands());
		cboxBrand.getSelectionModel().selectFirst();
		tableRegistration.setItems(presentation.getAllCarRegistrations());

	}

}
