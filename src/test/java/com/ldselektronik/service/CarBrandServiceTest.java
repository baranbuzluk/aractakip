package com.ldselektronik.service;

import static org.assertj.core.api.Assertions.assertThat;

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
	public void carBrandListTest() {
		List<CarBrand> list = service.getAll();
		assertThat(list).isEmpty();
	}

}
