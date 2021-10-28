package com.ldselektronik.util;

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
public final class ControllerHelper {

	private ControllerHelper() {

	}

	public static <T> void loadFxml(T controller,String fxmlName) {
		try {
			FXMLLoader loader = new FXMLLoader(controller.getClass().getResource(fxmlName));
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
	public static boolean confirmationAlert(String title, String msg) {
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
