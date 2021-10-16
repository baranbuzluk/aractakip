package com.ldselektronik.config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring tarafından yönetilen component ve beanlari servis etmek için oluşturulmuştur.
 * 
 * @author Baran
 * 
 */
public abstract class AbstractAppConfigService {
	
	private final static ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

	public <T> T getBean(Class<T> requiredType) {
		return applicationContext.getBean(requiredType);
	}
	
	
	
	

}
