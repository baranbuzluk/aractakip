package com.ldselektronik.configuration;

import java.util.logging.Logger;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.ldselektronik.application.abstracts.IWindow;
import com.ldselektronik.window.product.presentation.window.ProductWindow;

/**
 * @author Baran
 *
 */
@Configuration
@ComponentScan(basePackages = "com.ldselektronik")
@EnableAutoConfiguration
@Import({ DatabaseConfig.class })
public class SpringApplicationContext implements ApplicationContextAware{
	
	private  static ApplicationContext applicationContext;
	
	@Bean
	@Scope("prototype")
	public Logger produceLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
	
	@Bean(value = "MainWindow")
	public IWindow getMainWindow() {
		return new ProductWindow();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringApplicationContext.applicationContext=applicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
    public static <T> T getBean(Class<T> type) {
        return applicationContext.getBean(type);
    }
}
