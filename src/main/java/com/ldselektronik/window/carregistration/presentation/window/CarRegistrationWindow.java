package com.ldselektronik.window.carregistration.presentation.window;

import org.springframework.stereotype.Component;

import com.ldselektronik.application.abstracts.IWindow;
import com.ldselektronik.application.enums.WindowType;
import com.ldselektronik.window.carregistration.presentation.view.CarRegistrationController;

import javafx.scene.layout.Pane;

/**
 * @author Baran
 *
 */
@Component(value = WindowType.Constant.MAIN)
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
