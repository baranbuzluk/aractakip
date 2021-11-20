package com.ldselektronik.window.main.presentation;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ldselektronik.abstracts.IApplicationWindow;
import com.ldselektronik.abstracts.ITabWindow;
import com.ldselektronik.window.main.view.MainController;

import javafx.scene.layout.StackPane;

@Component
public class MainWindow implements IApplicationWindow {

	@Autowired
	private List<ITabWindow> mainTabItems;

	private MainController controller;

	@PostConstruct
	void postConstruct() {
		controller = new MainController();
		loadTabWindows();
	}

	@Override
	public StackPane getPane() {
		return controller.getRootPane();
	}

	private void loadTabWindows() {
		for (ITabWindow tabWindow : mainTabItems) {
			controller.addTabWindow(tabWindow.getPane(), tabWindow.getTabName());
		}
	}

}
