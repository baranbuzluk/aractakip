package com.ldselektronik.window.main.window;

import com.ldselektronik.application.abstracts.IWindow;
import com.ldselektronik.window.main.view.MainController;

import javafx.scene.layout.Pane;

/**
 * @author Baran
 *
 */
public class MainWindow implements IWindow {

	private MainController controller;

	public MainWindow() {

		controller = new MainController();
	}

	@Override
	public Pane getPane() {
		return controller.getRootPane();
	}

}
