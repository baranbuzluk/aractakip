package com.ldselektronik.util;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public final class JavaFXHelper {
	private JavaFXHelper() {
	}

	public static void loadFXML(String fxmlName, Object controller) {
		try {
			FXMLLoader loader = new FXMLLoader(controller.getClass().getResource(fxmlName));
			loader.setController(controller);
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
	public static boolean showConfirmationMessage(String title, String msg) {
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
