package com.ldselektronik.application.view;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ldselektronik.abstracts.ITabWindow;
import com.ldselektronik.configuration.SpringApplicationContext;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
		startApplicationContext();
		loadFXML();
		loadTabWindows();
	}

	public StackPane getRootPane() {
		return rootPane;
	}

	private void loadTabWindows() {
		SpringApplicationContext.getApplicationContext().getBeanProvider(ITabWindow.class)
				.forEach(tabWindow -> addTabWindow(tabWindow.getTabPane(), tabWindow.getTabTitleName()));
	}

	private void addTabWindow(StackPane pane, String tabName) {
		Tab tab = new Tab(tabName);
		tab.setContent(pane);
		tabPane.getTabs().add(tab);
	}

	@SuppressWarnings("resource")
	private static void startApplicationContext() {
		new AnnotationConfigApplicationContext(SpringApplicationContext.class);
	}

	private void loadFXML() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(MAIN_FXML));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}