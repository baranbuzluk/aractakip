package com.ldselektronik.application.carregistration.presentation.view;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * @author Baran
 *
 */
public final class CarRegistrationControllerHelper {

	private CarRegistrationControllerHelper() {

	}

	static void loadFxml(CarRegistrationController controller) {
		try {
			FXMLLoader loader = new FXMLLoader(CarRegistrationController.class.getResource("car_registration.fxml"));
			loader.setController(controller);
			loader.load();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Opens confirmation window for approving any a operation
	 * 
	 * @return <code>true</code> -If yes button is clicked <br>
	 *         <code>false</code> - Other cases
	 *
	 */
	static boolean confirmationAlert(String title,String msg) {
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
