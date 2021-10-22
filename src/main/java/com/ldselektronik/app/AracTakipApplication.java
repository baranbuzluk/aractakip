package com.ldselektronik.app;

import com.ldselektronik.config.IAppConfigService;

import javafx.application.Application;
	
public class AracTakipApplication implements IAppConfigService{
	public static void main(String[] args) {
		Application.launch(AracTakipMain.class, args);
	}
	
}
