package com.ldselektronik.window.carregistration.presentation.view;

import java.util.Date;

import com.ldselektronik.util.ControllerHelper;
import com.ldselektronik.window.carregistration.data.dto.CarBrandDto;
import com.ldselektronik.window.carregistration.data.dto.CarRegistrationDto;

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
	protected TableColumn<CarRegistrationDto, String> columnLicense;

	@FXML
	protected TextField fieldName;

	@FXML
	protected Button btnSearch;

	@FXML
	protected TableColumn<CarRegistrationDto, String> columnCompany;

	@FXML
	protected ComboBox<CarBrandDto> cboxBrand;

	@FXML
	protected AnchorPane rootPane;

	@FXML
	protected TableColumn<CarRegistrationDto, Integer> columnId;

	@FXML
	protected TextField fieldSurname;

	@FXML
	protected TableView<CarRegistrationDto> tableRegistration;

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
	protected TableColumn<CarRegistrationDto, CarBrandDto> columnBrand;

	@FXML
	protected Button btnDelete;

	@FXML
	protected TextField fieldCarLicense;

	@FXML
	protected TableColumn<CarRegistrationDto, String> columnDocumentNo;

	@FXML
	protected TableColumn<CarRegistrationDto, Date> columnDate;

	@FXML
	protected TextField fieldPhone;

	@FXML
	protected TableColumn<CarRegistrationDto, String> columnName;

	@FXML
	protected TextField fieldId;

	public BaseCarRegistrationController() {
		ControllerHelper.loadFxml(this, "car_registration.fxml");
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

	public CarRegistrationDto toDtoFromFields() {
		CarRegistrationDto dto = new CarRegistrationDto();
		dto.setCarBrand(cboxBrand.getSelectionModel().getSelectedItem());
		dto.setCarLicense(fieldCarLicense.getText());
		dto.setCompanyName(fieldCompanyName.getText());
		dto.setDocumentNo(fieldDocumentNo.getText());
		dto.setName(fieldName.getText());
		dto.setPhone(fieldPhone.getText());
		dto.setSurname(fieldSurname.getText());
		dto.setId(!fieldId.getText().isEmpty() ? Integer.valueOf(fieldId.getText()) : 0);
		return dto;
	}

	public void toFieldFromDto(CarRegistrationDto dto) {
		fieldCarLicense.setText(dto.getCarLicense());
		fieldCompanyName.setText(dto.getCompanyName());
		fieldDate.setText(dto.getCreatedTime().toString());
		fieldDocumentNo.setText(dto.getDocumentNo());
		fieldId.setText(String.valueOf(dto.getId()));
		fieldName.setText(dto.getName());
		fieldPhone.setText(dto.getPhone());
		fieldSurname.setText(dto.getSurname());
		cboxBrand.getSelectionModel().select(dto.getCarBrand());
	}

	public void clearFields() {
		String empty = "";
		fieldCarLicense.setText(empty);
		fieldCompanyName.setText(empty);
		fieldDate.setText(empty);
		fieldDocumentNo.setText(empty);
		fieldId.setText(empty);
		fieldName.setText(empty);
		fieldPhone.setText(empty);
		fieldSurname.setText(empty);
		cboxBrand.getSelectionModel().selectFirst();
	}

}
