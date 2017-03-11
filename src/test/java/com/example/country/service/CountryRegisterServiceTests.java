package com.example.country.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.domain.City;
import com.example.domain.Country;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryRegisterServiceTests {

	@Autowired
	CountryRegisterService  registerService;
	
	@Autowired
	CountrySearchService searchService;
	
	@Autowired
	Validator validator;
	
	@Test
	public void test00_confirmRegisterService() {
		System.out.println("registerService=" + registerService);
	}
	@Test
	public void test00_confirmSearchService() {
		System.out.println("searchService=" + searchService);
	}
	
	@Test
	public void test00_confirmValidator() {
		System.out.println("validator=" + validator);
	}
	
	@Test
	public void test01_register() {
		Country country = new Country();
		country.setCode("KK1");
		country.setName("xxxx");
		
		BindingResult errors = new BeanPropertyBindingResult(country, "country");
		validator.validate(country, errors);
		
		if (errors.hasErrors()) {
			System.out.println(errors);
			return;
		}
		
		try {
			registerService.register(country);
			System.out.println(searchService.getCountryByCode(country.getCode()));
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
