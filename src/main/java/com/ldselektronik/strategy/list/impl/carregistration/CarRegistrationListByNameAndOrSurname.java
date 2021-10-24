package com.ldselektronik.strategy.list.impl.carregistration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Component;

import com.ldselektronik.data.model.CarRegistration;
import com.ldselektronik.data.repository.CarRegistrationRepository;
import com.ldselektronik.service.impl.CarRegistrationService;
import com.ldselektronik.strategy.list.AbstractListStrategy;

/**
 * 
 * This class was coded in order to search and is used by <code>CarRegistrationService</code><br>
 * Name and surname, or only name, or only surname is searched by whether name and surname is empty or not
 * @see CarRegistrationService
 * @author Baran
 *
 */
@Component
public class CarRegistrationListByNameAndOrSurname
		extends AbstractListStrategy<CarRegistrationRepository, CarRegistration> {

	@Override
	public List<CarRegistration> getListByStrategy(CarRegistration arg) {
		List<CarRegistration> foundList = new ArrayList<>();

		if (arg == null) {
			logger.severe("Param arg is null!");
			return foundList;
		}

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnorePaths("id", "phone",
				"companyName", "documentNo", "carLicense", "createdTime", "carBrand");

		boolean isHasName = arg.getName() != null && !arg.getName().isEmpty();
		boolean isHasSurname = arg.getSurname() != null && !arg.getSurname().isEmpty();
		
		if (isHasName && isHasSurname) {
			matcher = matcher.withMatcher("name", GenericPropertyMatchers.contains()).withMatcher("surname",
					GenericPropertyMatchers.contains());
		} else if (isHasName) {
			matcher = matcher.withIgnorePaths("surname").withMatcher("name", GenericPropertyMatchers.contains());
		} else if (isHasSurname) {
			matcher = matcher.withIgnorePaths("name").withMatcher("surname", GenericPropertyMatchers.contains());
		}

		foundList = repository.findAll(Example.of(arg, matcher));

		return foundList;
	}

}
