package com.ldselektronik.window;

import com.ldselektronik.view.CarRegistrationController;

import javafx.scene.Scene;

public class CarRegistrationWindow {

	private CarRegistrationController controller = new CarRegistrationController();

	public Scene getScene() {
		Scene scene = new Scene(controller.getPane());
		return scene;
	}

}
