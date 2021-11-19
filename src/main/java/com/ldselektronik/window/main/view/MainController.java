package com.ldselektronik.window.main.view;

import com.ldselektronik.configuration.SpringApplicationContext;
import com.ldselektronik.util.JavaFxHelper;
import com.ldselektronik.window.product.presentation.window.ProductPresentation;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainController {

	@FXML
	private MenuBar menuBar;

	@FXML
	private Pane pane;

	@FXML
	private AnchorPane rootPane;

	public MainController() {
		JavaFxHelper.loadFxml(this, "main.fxml");
		pane.getChildren().add(SpringApplicationContext.getBean(ProductPresentation.class).getPane());

	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public Pane getPane() {
		return pane;
	}

	public void setPane(Pane pane) {
		this.pane = pane;
	}

	public Pane getRootPane() {
		return rootPane;
	}

	public void setRootPane(AnchorPane rootPane) {
		this.rootPane = rootPane;
	}

}
