package com.example.country.service;

import org.springframework.beans.factory.annotation.Autowired;
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
public class CountryRegisterService {
	
	@Autowired
	CountryMapper countryMapper;
	
	@Transactional
	public void register(Country country, BindingResult errors) {
		
		countryMapper.insert(country);
	}

}
