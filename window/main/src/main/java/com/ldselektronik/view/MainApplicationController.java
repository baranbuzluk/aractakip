package com.ldselektronik.view;

import com.ldselektronik.util.JavaFXHelper;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;

public class MainApplicationController {

	private static final String MAIN_FXML = "main_application.fxml";

	@FXML
	private StackPane rootPane;

	@FXML
	private TabPane tabPane;

	public MainApplicationController() {
		JavaFXHelper.loadFXML(MAIN_FXML, this);
	}

	public StackPane getRootPane() {
		return rootPane;
	}

	public void addTabWindow(StackPane innerPane, String tabName) {
		Tab tab = new Tab(tabName);
		tab.setContent(innerPane);
		tabPane.getTabs().add(tab);
	}

}