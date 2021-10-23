package com.ldselektronik.application;

import com.ldselektronik.configuration.IAppConfigService;

import javafx.application.Application;
	
/**
 * @author Baran
 *
 */
public class AracTakipApplication implements IAppConfigService{
	public static void main(String[] args) {
		Application.launch(AracTakipMain.class, args);
	}
	
}
