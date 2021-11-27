package com.ldselektronik.abstracts;

import javafx.scene.layout.StackPane;

/**
 * Implemente eden sınıfı Ana pencereye tab pane olarak eklenmesini sağlar.
 * 
 * @author Baran
 *
 */
public interface ITabWindow {

	StackPane getTabPane();

	String getTabTitleName();
}
