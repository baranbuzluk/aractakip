package com.ldselektronik.presentation;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ldselektronik.abstracts.IMainApplicationWindow;
import com.ldselektronik.abstracts.ITabWindow;
import com.ldselektronik.view.MainApplicationController;

import javafx.scene.layout.StackPane;

@Component
public class MainApplicationWindow implements IMainApplicationWindow {

	@Autowired
	private List<ITabWindow> tabPanes;

	private MainApplicationController controller;

	public MainApplicationWindow() {
		controller = new MainApplicationController();
	}

	@PostConstruct
	void init() {
		loadTabWindows();
	}

	@Override
	public StackPane getRootPane() {
		return controller.getRootPane();
	}

	private void loadTabWindows() {
		tabPanes.forEach(this::addTabPane);
	}

	private void addTabPane(ITabWindow tabWindow) {
		String tabTitleName = tabWindow.getTabTitleName();
		StackPane tabInnerPane = tabWindow.getTabPane();
		controller.addTabWindow(tabInnerPane, tabTitleName);
	}
}
