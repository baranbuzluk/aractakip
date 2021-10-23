package com.ldselektronik.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ldselektronik.config.AppConfig;
import com.ldselektronik.model.CarRegistration;

class CarRegistrationServiceTest {

	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

	private CarRegistrationService service = applicationContext.getBean(CarRegistrationService.class);

	@Test
	void carRegistrationGetAllMethodTest() {
		List<CarRegistration> list = service.getAll();
		assertThat(list).isEmpty();
	}

}
