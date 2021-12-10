package com.ldselektronik.window.carregistration.presentation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ldselektronik.abstracts.ITabWindow;
import com.ldselektronik.util.JavaFXHelper;
import com.ldselektronik.window.carregistration.entity.CarRegistration;
import com.ldselektronik.window.carregistration.service.CarBrandService;
import com.ldselektronik.window.carregistration.service.CarRegistrationService;
import com.ldselektronik.window.carregistration.view.CarRegistrationController;

import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * @author Baran
 *
 */
@Component
public class CarRegistrationWindow implements ITabWindow {

	private static final String TAB_NAME = "Araç Takip";

	@Autowired
	private CarBrandService carBrandService;

	@Autowired
	private CarRegistrationService carRegistrationService;

	private CarRegistrationController controller;

	@PostConstruct
	void init() {
		controller = new CarRegistrationController();
		refreshCarBrandCombobox();
		refreshCarRegistrationTable();
		initControllerEventHandlers();
	}

	@Override
	public StackPane getTabPane() {
		return controller.getRootPane();
	}

	@Override
	public String getTabTitleName() {
		return TAB_NAME;
	}

	private void refreshCarRegistrationTable() {
		controller.setCarRegistrationTableItems(carRegistrationService.getAllCarRegistrations());
	}

	private void refreshCarBrandCombobox() {
		controller.setCarBrandComboboxItems(carBrandService.getAllCarBrands());
	}

	private void initControllerEventHandlers() {
		controller.handleDeleteButtonOnClicked(onClickDeleteButton);
		controller.handleRefreshButtonOnClicked(e -> controller.clearFields());
		controller.handleSaveButtonOnClicked(onClickSaveButton);
		controller.handleSearchButtonOnClicked(onClickSearchButton);
		controller.handleSelectedItemOnTableListener(tableItemSelectedListener);
	}

	private EventHandler<MouseEvent> onClickSearchButton = event -> controller.setCarRegistrationTableItems(
			carRegistrationService.searchCarRegistration(controller.fromFieldsToEntity()));

	private ChangeListener<CarRegistration> tableItemSelectedListener = (observable, oldValue, newValue) -> {
		if (newValue != null) { // when table row is selected
			controller.fromEntityToFields(newValue);
			controller.enableDeleteButton();
			controller.disableDocumentNoField();
		} else {
			controller.clearFields();
			controller.disableDeleteButton();
			controller.enableDocumentNoField();
		}
	};

	private EventHandler<MouseEvent> onClickSaveButton = e -> {
		final CarRegistration entity = controller.fromFieldsToEntity();
		if (carRegistrationService.existsByDocumentNo(entity.getDocumentNo())) {
			carRegistrationService.save(entity);
			controller.clearFields();
			refreshCarRegistrationTable();
			return;
		}
		final String title = "Kayıt Güncelleniyor";
		final String message = "Dökümasyon No: " + entity.getDocumentNo()
				+ " olan araç kaydını güncellemek istiyormusunuz?";
		if (JavaFXHelper.showConfirmationMessage(title, message)) {
			carRegistrationService.save(entity);
			controller.clearFields();
			refreshCarRegistrationTable();
		}
	};

	EventHandler<MouseEvent> onClickDeleteButton = e -> {
		final String title = "Silme işlemi yapılıyor";
		final String message = "Bu işlem geri alınamaz.\\nKayıt silinsin mi ?";
		if (JavaFXHelper.showConfirmationMessage(title, message)) {
			carRegistrationService.delete(controller.getSelectedCarRegistrationOnTable());
			controller.clearFields();
		}
	};

}
