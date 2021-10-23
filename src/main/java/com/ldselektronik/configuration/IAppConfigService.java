package com.ldselektronik.configuration;

import org.hibernate.resource.beans.container.internal.NoSuchBeanException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring tarafından yönetilen component ve beanlari servis etmek için
 * oluşturulmuştur.
 * 
 * @author Baran
 * 
 */
public interface  IAppConfigService {

	public static final ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			AppConfig.class);

	public  default <T> T getBean(Class<T> requiredType) {
		T bean = null;
		try {
			bean = applicationContext.getBean(requiredType);
		} catch (NoSuchBeanException e) {
			return null;
		}
		return bean;
	}

}
