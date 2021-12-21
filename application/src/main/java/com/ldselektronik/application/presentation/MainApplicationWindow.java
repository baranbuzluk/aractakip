package com.ldselektronik.application.presentation;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.ldselektronik.abstracts.ITabWindow;
import com.ldselektronik.application.view.MainApplicationController;
import com.ldselektronik.core.SpringApplicationContext;

import javafx.scene.layout.StackPane;

@Component
public class MainApplicationWindow {

	private MainApplicationController controller;

	public MainApplicationWindow() {
		controller = new MainApplicationController();
	}

	@PostConstruct
	void init() {
		loadTabWindows();
	}

	public StackPane getRootPane() {
		return controller.getRootPane();
	}

	private void loadTabWindows() {
		SpringApplicationContext.getApplicationContext().getBeanProvider(ITabWindow.class).forEach(tabWindow -> {
			String tabTitleName = tabWindow.getTabTitleName();
			StackPane tabInnerPane = tabWindow.getTabPane();
			controller.addTabWindow(tabInnerPane, tabTitleName);
		});
	}
}
