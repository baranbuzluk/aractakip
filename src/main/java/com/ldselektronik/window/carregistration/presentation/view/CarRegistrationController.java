package com.ldselektronik.window.carregistration.presentation.view;

import com.ldselektronik.util.ControllerHelper;
import com.ldselektronik.window.carregistration.data.dto.CarRegistrationDto;
import com.ldselektronik.window.carregistration.presentation.window.CarRegistrationWindow;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CarRegistrationController extends BaseCarRegistrationController {

	private CarRegistrationWindow window;

	public CarRegistrationController(CarRegistrationWindow window) {
		this.window = window;
		initialize();
	}

	public void loadControllerObjectDatas() {
		tableRegistration.setItems(window.getAllCarRegistration());
		cboxBrand.setItems(window.getAllCarBrand());
		cboxBrand.getSelectionModel().selectFirst();
	}

	private void initialize() {
		btnRegister.setOnMouseClicked(btnRegisterOnMouseClicked);
		btnRefresh.setOnMouseClicked(btnRefreshOnMouseClicked);
		btnDelete.setOnMouseClicked(btnDeleteOnMouseClicked);
		btnSearch.setOnMouseClicked(btnSearchOnMouseClicked);
		tableRegistration.getSelectionModel().selectedIndexProperty().addListener(selectedTableRow);
	}

	private EventHandler<MouseEvent> btnDeleteOnMouseClicked = e -> {
		if (ControllerHelper.confirmationAlert("Silme işlemi yapılıyor",
				"Bu işlem geri alınamaz.\nKayıt silinsin mi ?")) {
			window.deleteById(tableRegistration.getSelectionModel().getSelectedItem().getId());
			tableRegistration.setItems(window.getAllCarRegistration());
			clearFields();
		}

	};

	private EventHandler<MouseEvent> btnRefreshOnMouseClicked = e -> {
		tableRegistration.setItems(window.getAllCarRegistration());
		clearFields();
	};

	private EventHandler<MouseEvent> btnRegisterOnMouseClicked = e -> {
		CarRegistrationDto dto = toDtoFromFields();

		if (window.existsByDocumentNo(dto.getDocumentNo())) {
			String title = "Kayıt Güncelleniyor";
			String msg = "Dökümasyon No: " + dto.getDocumentNo() + " olan araç kaydını güncellemek istiyormusunuz?";

			if (ControllerHelper.confirmationAlert(title, msg)) {
				window.saveCarRegistration(dto);
			}
		} else {
			window.saveCarRegistration(dto);
		}

		tableRegistration.setItems(window.getAllCarRegistration());
	};

	private EventHandler<MouseEvent> btnSearchOnMouseClicked = event -> {
		tableRegistration.setItems(window.searchCarRegistration(toDtoFromFields()));
	};

	private ChangeListener<Number> selectedTableRow = (ObservableValue<? extends Number> observable, Number oldValue,
			Number newValue) -> {

		CarRegistrationDto selected = tableRegistration.getSelectionModel().getSelectedItem();

		if (selected != null) { // when table row is select
			toFieldFromDto(window.findCarRegistrationById(selected.getId()));
			btnDelete.setDisable(false);
			fieldCarLicense.setDisable(true);

		} else {
			clearFields();
			btnDelete.setDisable(true);
			fieldDocumentNo.setDisable(false);
		}

	};

}
