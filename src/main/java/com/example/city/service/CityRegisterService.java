package com.example.city.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.City;
import com.example.exception.RegisterFailRuntimeException;
import com.example.mapper.CityMapper;

@Service
public class CityRegisterService {
	
	@Autowired
	CityMapper cityMapper;
	
	@Transactional
	public void register(City city) {
		cityMapper.insert(city);
	}

}
