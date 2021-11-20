package com.ldselektronik.window.carregistration.view;

import com.ldselektronik.util.JavaFxHelper;
import com.ldselektronik.window.carregistration.data.entity.CarRegistrationEntity;
import com.ldselektronik.window.carregistration.presentation.CarRegistrationWindow;

import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CarRegistrationController extends BaseCarRegistrationController {

	public CarRegistrationController(CarRegistrationWindow presentation) {
		super(presentation);
		init();
		clearAndRefreshAllFields();
	}

	void init() {
		btnRegister.setOnMouseClicked(btnRegisterOnMouseClicked);
		btnRefresh.setOnMouseClicked(btnRefreshOnMouseClicked);
		btnDelete.setOnMouseClicked(btnDeleteOnMouseClicked);
		btnSearch.setOnMouseClicked(btnSearchOnMouseClicked);
		tableCarRegistrations.getSelectionModel().selectedItemProperty().addListener(selectedTableRow);
	}

	EventHandler<MouseEvent> btnDeleteOnMouseClicked = e -> {

		String title = "Silme işlemi yapılıyor";
		String message = "Bu işlem geri alınamaz.\\nKayıt silinsin mi ?";

		if (JavaFxHelper.confirmationMessage(title, message)) {
			presentation.deleteById(tableCarRegistrations.getSelectionModel().getSelectedItem().getId());
			clearAndRefreshAllFields();
		}
	};

	EventHandler<MouseEvent> btnRefreshOnMouseClicked = e -> clearAndRefreshAllFields();

	EventHandler<MouseEvent> btnRegisterOnMouseClicked = e -> {
		CarRegistrationEntity entity = toEntityFromFields();

		if (!presentation.existsByDocumentNo(entity.getDocumentNo())) {
			presentation.saveCarRegistration(entity);
			clearAndRefreshAllFields();
			return;
		}

		String title = "Kayıt Güncelleniyor";
		String message = "Dökümasyon No: " + entity.getDocumentNo() + " olan araç kaydını güncellemek istiyormusunuz?";
		if (JavaFxHelper.confirmationMessage(title, message)) {
			presentation.saveCarRegistration(entity);
			clearAndRefreshAllFields();
		}

	};

	EventHandler<MouseEvent> btnSearchOnMouseClicked = event -> {
		tableCarRegistrations.setItems(presentation.searchCarRegistration(toEntityFromFields()));
	};

	ChangeListener<CarRegistrationEntity> selectedTableRow = (observable, oldValue, newValue) -> {

		if (newValue != null) { // when table row is select
			toFieldFromEntity(newValue);
			btnDelete.setDisable(false);
			fieldDocumentNo.setDisable(true);
		} else {
			btnDelete.setDisable(true);
			fieldDocumentNo.setDisable(false);
			clearAndRefreshAllFields();
		}

	};
}
