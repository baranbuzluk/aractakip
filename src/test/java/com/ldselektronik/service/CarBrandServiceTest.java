package com.ldselektronik.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ldselektronik.config.AppConfig;
import com.ldselektronik.model.CarBrand;

public class CarBrandServiceTest {

	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	private CarBrandService service = applicationContext.getBean(CarBrandService.class);

	
	@Test
	public void saveTest()  {
		CarBrand brand = new CarBrand();
		brand.setName("BMW");
		
		CarBrand brand1 = new CarBrand();
		brand1.setName("Honda");
		service.save(brand);
		service.save(brand1);
	}

}
