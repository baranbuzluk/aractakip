package com.ldselektronik.window.main.view;

import com.ldselektronik.util.JavaFxHelper;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;

public class MainController {

	@FXML
	private StackPane rootPane;

	@FXML
	private TabPane tabPane;

	public MainController() {
		JavaFxHelper.loadFxml(this, "main.fxml");
	}

	public StackPane getRootPane() {
		return rootPane;
	}

	public void addTabWindow(StackPane pane, String tabName) {
		Tab tab = new Tab(tabName);
		tab.setContent(pane);
		tabPane.getTabs().add(tab);
	}

}