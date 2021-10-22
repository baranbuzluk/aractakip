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
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class CarRegistrationController {

	@FXML
	private TableColumn<CarRegistrationDTO, String> licenseColumn;

	@FXML
	private TextField idField;

	@FXML
	private TextField companyNameField;

	@FXML
	private ComboBox<CarBrandDTO> brandCBox;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private TextField nameField;

	@FXML
	private TextField dateField;

	@FXML
	private Button recordDeleteButton;

	@FXML
	private TableColumn<CarRegistrationDTO, String> companyColumn;

	@FXML
	private TextField carLicenseField;

	@FXML
	private TextField phoneField;

	@FXML
	private Button recordSaveButton;

	@FXML
	private Button recordRefreshButton;

	@FXML
	private TextField surnameField;

	@FXML
	private TableColumn<CarRegistrationDTO, String> documentNoColumn;

	@FXML
	private TableColumn<CarRegistrationDTO, String> nameColumn;

	@FXML
	private Button recordSearchButton;

	@FXML
	private TableColumn<CarRegistrationDTO, Date> dateColumn;

	@FXML
	private TableView<CarRegistrationDTO> registrationTableView;

	@FXML
	private TableColumn<CarRegistrationDTO, CarBrandDTO> brandColumn;

	@FXML
	private TableColumn<CarRegistrationDTO, Integer> idColumn;

	@FXML
	private TextField documentNoField;

	public CarRegistrationController() {
		loadFxml();
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
	
	

}
