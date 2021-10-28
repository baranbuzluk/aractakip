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

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringApplicationContext.applicationContext=applicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
}
