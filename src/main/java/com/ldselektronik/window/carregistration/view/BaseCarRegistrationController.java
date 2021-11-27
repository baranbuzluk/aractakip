package com.ldselektronik.window.carregistration.view;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import com.ldselektronik.window.carregistration.entity.CarBrand;
import com.ldselektronik.window.carregistration.entity.CarRegistration;
import com.ldselektronik.window.carregistration.presentation.CarRegistrationWindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

/**
 * @author Baran
 *
 */
public class BaseCarRegistrationController {

	private static final String CAR_REGISTRATION_FXML = "car_registration.fxml";

	@FXML
	protected TableColumn<CarRegistration, String> columnLicense;

	@FXML
	protected TextField fieldName;

	@FXML
	protected Button btnSearch;

	@FXML
	protected TableColumn<CarRegistration, String> columnCompany;

	@FXML
	protected ComboBox<CarBrand> cboxBrand;

	@FXML
	protected StackPane rootPane;

	@FXML
	protected TableColumn<CarRegistration, Integer> columnId;

	@FXML
	protected TextField fieldSurname;

	@FXML
	protected TableView<CarRegistration> tableCarRegistrations;

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
	protected TableColumn<CarRegistration, CarBrand> columnBrand;

	@FXML
	protected Button btnDelete;

	@FXML
	protected TextField fieldCarLicense;

	@FXML
	protected TableColumn<CarRegistration, String> columnDocumentNo;

	@FXML
	protected TableColumn<CarRegistration, Date> columnDate;

	@FXML
	protected TextField fieldPhone;

	@FXML
	protected TableColumn<CarRegistration, String> columnName;

	@FXML
	protected TextField fieldId;

	protected CarRegistrationWindow presentation;

	public BaseCarRegistrationController(CarRegistrationWindow presentation) {
		this.presentation = presentation;
		loadFXML();
		initTable();
	}

	public StackPane getRootPane() {
		return rootPane;
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

	public CarRegistration toEntityFromFields() {
		CarRegistration entity = new CarRegistration();
		entity.setCarBrand(cboxBrand.getSelectionModel().getSelectedItem());
		entity.setCarLicense(fieldCarLicense.getText().isEmpty() ? null : fieldCarLicense.getText());
		entity.setCompanyName(fieldCompanyName.getText().isEmpty() ? null : fieldCompanyName.getText());
		entity.setDocumentNo(fieldDocumentNo.getText().isEmpty() ? null : fieldDocumentNo.getText());
		entity.setName(fieldName.getText().isEmpty() ? null : fieldName.getText());
		entity.setPhone(fieldPhone.getText().isEmpty() ? null : fieldPhone.getText());
		entity.setSurname(fieldSurname.getText().isEmpty() ? null : fieldSurname.getText());
		entity.setId(fieldId.getText().isEmpty() ? null : Integer.valueOf(fieldId.getText()));
		return entity;
	}

	public void toFieldFromEntity(CarRegistration entity) {
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
		refreshData();
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

	public void refreshData() {
		cboxBrand.setItems(presentation.getAllCarBrands());
		tableCarRegistrations.setItems(presentation.getAllCarRegistrations());
	}

	private void loadFXML() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(CAR_REGISTRATION_FXML));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Opens confirmation message that have yes and no buttons
	 * 
	 * @param title
	 * @param msg
	 * @return <code>true</code> - If yes button is clicked , otherwise false
	 */
	public boolean showConfirmationMessage(String title, String msg) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(msg);
		alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
		Optional<ButtonType> buttonType = alert.showAndWait();
		if (buttonType.isPresent())
			return buttonType.get() == ButtonType.YES;
		return false;
	}

}
