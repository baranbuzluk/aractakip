package com.ldselektronik.service.dto.converter;

import com.ldselektronik.data.model.CarBrand;
import com.ldselektronik.data.model.CarRegistration;
import com.ldselektronik.service.dto.CarBrandDTO;
import com.ldselektronik.service.dto.CarRegistrationDTO;

/**
 * @author Baran
 *
 */
public final class Converter {
	private Converter() {

	}

	public static CarBrandDTO toCarBrandDTO(CarBrand obj) {
		return new CarBrandDTO(obj.getId(), obj.getName());
	}
	
	public static CarBrand toCarBrand(CarBrandDTO obj) {
		CarBrand model=new CarBrand();
		model.setId(obj.getId());
		model.setName(obj.getName());
		return model;
	}
	
	
	public static CarRegistrationDTO toCarRegistrationDTO(CarRegistration obj)
	{
		CarRegistrationDTO dto = new CarRegistrationDTO();
		dto.setCarBrand(toCarBrandDTO(obj.getCarBrand()));
		dto.setCarLicense(obj.getCarLicense());
		dto.setCompanyName(obj.getCompanyName());
		dto.setCreatedTime(obj.getCreatedTime());
		dto.setDocumentNo(obj.getDocumentNo());
		dto.setId(obj.getId());
		dto.setName(obj.getName());
		dto.setPhone(obj.getPhone());
		dto.setSurname(obj.getSurname());
		return dto;
	}
	
	public static CarRegistration toCarRegistration(CarRegistrationDTO obj)
	{
		CarRegistration model = new CarRegistration();
		model.setCarBrand(toCarBrand(obj.getCarBrand()));
		model.setCarLicense(obj.getCarLicense());
		model.setCompanyName(obj.getCompanyName());
		model.setDocumentNo(obj.getDocumentNo());
		model.setId(obj.getId());
		model.setName(obj.getName());
		model.setPhone(obj.getPhone());
		model.setSurname(obj.getSurname());
		return model;
	}
}
