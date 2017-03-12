package com.example.city.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.exception.RegisterFailRuntimeException;
import com.example.mapper.CityMapper;
import com.example.mapper.CountryMapper;

@Service
public class CityRegisterService {
	
	@Autowired
	CityMapper cityMapper;
	
	@Autowired 
	CountryMapper countryMapper;
	
	@Transactional
	public void register(City city, BindingResult errors) {
		
		if (city.getCountryCode() != null) {
			Country country = countryMapper.selectByCode(city.getCountryCode());
			if (country == null)
				errors.reject("InvalidContryCode", "유효한 CountryCode가 아닙니다.");
		}
		
		if (!errors.hasErrors())
			cityMapper.insert(city);
	}

}
