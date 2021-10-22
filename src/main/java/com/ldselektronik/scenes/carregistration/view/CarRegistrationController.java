package com.ldselektronik.scenes.carregistration.view;

import java.io.IOException;
import java.util.Date;

import com.ldselektronik.dto.CarBrandDTO;
import com.ldselektronik.dto.CarRegistrationDTO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class CarRegistrationController {

	@FXML
	private TableColumn<CarRegistrationDTO, String> columnLicense;

	@FXML
	private TextField fieldName;

	@FXML
	private Button btnSearch;

	@FXML
	private TableColumn<CarRegistrationDTO, String> columnCompany;

	@FXML
	private ComboBox<CarBrandDTO> cboxBrand;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private TableColumn<CarRegistrationDTO, Integer> columnId;

	@FXML
	private TextField fieldSurname;

	@FXML
	private TableView<CarRegistrationDTO> tableRegistration;

	@FXML
	private TextField fieldDate;

	@FXML
	private TextField fieldDocumentNo;

	@FXML
	private TextField fieldCompanyName;

	@FXML
	private Button btnRegister;

	@FXML
	private Button btnRecordRefresh;

	@FXML
	private TableColumn<CarRegistrationDTO, CarBrandDTO> columnBrand;

	@FXML
	private Button btnDelete;

	@FXML
	private TextField fieldCarLicense;

	@FXML
	private TableColumn<CarRegistrationDTO, String> columnDocumentNo;

	@FXML
	private TableColumn<CarRegistrationDTO, Date> columnDate;

	@FXML
	private TextField fieldPhone;

	@FXML
	private TableColumn<CarRegistrationDTO, String> columnName;

	@FXML
	private TextField fieldId;

	public CarRegistrationController() {
		loadFxml();
		initTableColumns();
	}

	public Pane getPane() {

		return rootPane;
	}

	private void loadFxml() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("car_registration.fxml"));
			loader.setController(this);
			loader.load();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initTableColumns() {
		columnBrand.setCellValueFactory(new PropertyValueFactory<>("carBrand"));
		columnCompany.setCellValueFactory(new PropertyValueFactory<>("companyName"));
		columnDate.setCellValueFactory(new PropertyValueFactory<>("createdTime"));
		columnDocumentNo.setCellValueFactory(new PropertyValueFactory<>("documentNo"));
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnLicense.setCellValueFactory(new PropertyValueFactory<>("carLicense"));
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
	}

}
