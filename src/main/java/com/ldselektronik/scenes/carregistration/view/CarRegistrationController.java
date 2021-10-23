package com.ldselektronik.scenes.carregistration.view;

import java.util.Date;

import com.ldselektronik.config.IAppConfigService;
import com.ldselektronik.dto.CarBrandDTO;
import com.ldselektronik.dto.CarRegistrationDTO;
import com.ldselektronik.service.CarBrandService;
import com.ldselektronik.service.CarRegistrationService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class CarRegistrationController implements IAppConfigService {

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
	private Button btnRefresh;

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
	
	private CarBrandService carBrandService = getBean(CarBrandService.class); 
	private CarRegistrationService carRegistrationService = getBean(CarRegistrationService.class); 
	
	private void initControlObjects() {
		// Table Column Settings
		columnBrand.setCellValueFactory(new PropertyValueFactory<>("carBrand"));
		columnCompany.setCellValueFactory(new PropertyValueFactory<>("companyName"));
		columnDate.setCellValueFactory(new PropertyValueFactory<>("createdTime"));
		columnDocumentNo.setCellValueFactory(new PropertyValueFactory<>("documentNo"));
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnLicense.setCellValueFactory(new PropertyValueFactory<>("carLicense"));
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		// Init ComboBox
		cboxBrand.setItems(carBrandService.getAll());
		cboxBrand.getSelectionModel().selectFirst();
		
		//Init Table
		tableRegistration.setItems(carRegistrationService.getAll());
	}
	
	public CarRegistrationController() {
		CarRegistrationControllerHelper.loadFxml(this);
		initControlObjects();
	}

	public Pane getPane() {
		return rootPane;
	}

	@FXML
	void btnRefreshOnAction(ActionEvent event) {
		System.err.println("Test");
	}

	@FXML
	void btnRegisterOnAction(ActionEvent event) {
		carRegistrationService.save(toDtoFromFields());
		tableRegistration.setItems(carRegistrationService.getAll());
	}

	@FXML
	void btnSearchOnAction(ActionEvent event) {
		System.err.println("Test");
	}

	@FXML
	void btnDeleteOnAction(ActionEvent event) {
		System.err.println("Test");
	}
	
	private CarRegistrationDTO toDtoFromFields()
	{
		CarRegistrationDTO dto = new CarRegistrationDTO();
		dto.setCarBrand(cboxBrand.getSelectionModel().getSelectedItem());
		dto.setCarLicense(fieldCarLicense.getText());
		dto.setCompanyName(fieldCompanyName.getText());
		dto.setDocumentNo(fieldDocumentNo.getText());
		dto.setName(fieldName.getText());
		dto.setPhone(fieldPhone.getText());
		dto.setSurname(fieldSurname.getText());
		return dto;
	}

}
