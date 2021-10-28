package com.ldselektronik.util;

import com.ldselektronik.window.carregistration.data.dto.CarBrandDto;
import com.ldselektronik.window.carregistration.data.dto.CarRegistrationDto;
import com.ldselektronik.window.carregistration.data.entity.CarBrandEntity;
import com.ldselektronik.window.carregistration.data.entity.CarRegistrationEntity;

/**
 * @author Baran
 *
 */
public final class EntityDtoConverter {
	private EntityDtoConverter() {

	}

	public static CarBrandDto toCarBrandDTO(CarBrandEntity obj) {
		return new CarBrandDto(obj.getId(), obj.getName());
	}
	
	public static CarBrandEntity toCarBrand(CarBrandDto obj) {
		CarBrandEntity model=new CarBrandEntity();
		model.setId(obj.getId());
		model.setName(obj.getName());
		return model;
	}
	
	
	public static CarRegistrationDto toCarRegistrationDTO(CarRegistrationEntity obj)
	{
		CarRegistrationDto dto = new CarRegistrationDto();
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
	
	public static CarRegistrationEntity toCarRegistration(CarRegistrationDto obj)
	{
		CarRegistrationEntity model = new CarRegistrationEntity();
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
