package com.ldselektronik.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ldselektronik.config.AppConfig;
import com.ldselektronik.dto.CarBrandDTO;

class CarBrandServiceTest {

	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	private CarBrandService service = applicationContext.getBean(CarBrandService.class);

	@Test
	void saveTest() {
		CarBrandDTO brand = new CarBrandDTO();
		brand.setName("BMW");

		CarBrandDTO brand1 = new CarBrandDTO();
		brand1.setName("Honda");
		service.save(brand);
		service.save(brand1);
	}

}
