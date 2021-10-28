package com.ldselektronik.window.carregistration.presentation.window;

import com.ldselektronik.application.abstracts.IWindow;
import com.ldselektronik.window.carregistration.presentation.view.CarRegistrationController;

import javafx.scene.layout.Pane;

/**
 * @author Baran
 *
 */
public class CarRegistrationWindow implements IWindow{

	private CarRegistrationController controller;
	
	public CarRegistrationWindow() {
		controller = new CarRegistrationController();
	}

	@Override
	public Pane getPane() {
		return controller.getPane();
	}

}
