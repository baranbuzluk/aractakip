package com.ldselektronik.presentation.carregistration.view;

import java.util.Date;

import com.ldselektronik.configuration.IAppConfigService;
import com.ldselektronik.service.dto.CarBrandDTO;
import com.ldselektronik.service.dto.CarRegistrationDTO;
import com.ldselektronik.service.impl.CarBrandService;
import com.ldselektronik.service.impl.CarRegistrationService;

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

	public CarRegistrationController() {
		CarRegistrationControllerHelper.loadFxml(this);
		initControlObjects();
	}

	private void initControlObjects() {
		// Init TableColumn
		columnBrand.setCellValueFactory(new PropertyValueFactory<>("carBrand"));
		columnCompany.setCellValueFactory(new PropertyValueFactory<>("companyName"));
		columnDate.setCellValueFactory(new PropertyValueFactory<>("createdTime"));
		columnDocumentNo.setCellValueFactory(new PropertyValueFactory<>("documentNo"));
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnLicense.setCellValueFactory(new PropertyValueFactory<>("carLicense"));
		columnName.setCellValueFactory(new PropertyValueFactory<>("nameAndSurname"));

		// Init ComboBox
		cboxBrand.setItems(carBrandService.getAll());
		cboxBrand.getSelectionModel().selectFirst();

		// Init Table
		tableRegistration.setItems(carRegistrationService.getAll());
		tableRegistration.getSelectionModel().selectedIndexProperty().addListener(selectedTableRow);

		// Init Button
		btnRegister.setOnMouseClicked(btnRegisterOnMouseClicked);
		btnRefresh.setOnMouseClicked(btnRefreshOnMouseClicked);
		btnDelete.setOnMouseClicked(btnDeleteOnMouseClicked);
		btnSearch.setOnMouseClicked(btnSearchOnMouseClicked);
	}

	public Pane getPane() {
		return rootPane;
	}

	/**
	 * @see {@link CarRegistrationController} <br>
	 *      This object is used at
	 *      {@code btnDelete.setOnMouseClicked(btnDeleteOnMouseClicked)}
	 * 
	 */
	EventHandler<MouseEvent> btnDeleteOnMouseClicked = event -> {
		if (CarRegistrationControllerHelper.confirmDeleteOperation()) {
			carRegistrationService.deleteById(tableRegistration.getSelectionModel().getSelectedItem().getId());
			tableRegistration.setItems(carRegistrationService.getAll());
			clearFields();
		}

	};

	/**
	 * @see {@link CarRegistrationController} <br>
	 *      This object is used at
	 *      {@code btnRefresh.setOnMouseClicked(btnRefreshOnMouseClicked)}
	 * 
	 */
	EventHandler<MouseEvent> btnRefreshOnMouseClicked = event -> {
		tableRegistration.setItems(carRegistrationService.getAll());
		clearFields();
	};

	/**
	 * @see {@link CarRegistrationController} <br>
	 *      This object is used at
	 *      {@code btnRegister.setOnMouseClicked(btnRegisterOnMouseClicked)}
	 * 
	 */
	EventHandler<MouseEvent> btnRegisterOnMouseClicked = event -> {
		carRegistrationService.save(toDtoFromFields());
		tableRegistration.setItems(carRegistrationService.getAll());
	};
	
	/**
	 * @see {@link CarRegistrationController} <br>
	 *      This object is used at
	 *      {@code btnSearch.setOnMouseClicked(btnSearchOnMouseClicked)}
	 * 
	 */
	EventHandler<MouseEvent> btnSearchOnMouseClicked = event -> {
		tableRegistration.setItems(carRegistrationService.searchCarRegistration(toDtoFromFields()));
	};

	/**
	 * @see {@link CarRegistrationController} <br>
	 *      This object is used at
	 *      {@code tableRegistration.getSelectionModel().selectedIndexProperty().addListener(selectedTableRow);}
	 * 
	 */
	ChangeListener<Number> selectedTableRow = (ObservableValue<? extends Number> observable, Number oldValue,
			Number newValue) -> {

		CarRegistrationDTO selected = tableRegistration.getSelectionModel().getSelectedItem();
		if (selected != null) {
			toFieldFromDto(carRegistrationService.findById(selected.getId()));
			btnDelete.setDisable(false);

		} else {
			clearFields();
			btnDelete.setDisable(true);
		}

	};

	private CarRegistrationDTO toDtoFromFields() {
		CarRegistrationDTO dto = new CarRegistrationDTO();
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

	private void toFieldFromDto(CarRegistrationDTO dto) {
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

	private void clearFields() {
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
