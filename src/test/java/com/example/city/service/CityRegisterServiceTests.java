package com.example.city.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.city.form.CityForm;
import com.example.domain.City;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRegisterServiceTests {

	@Autowired
	CityRegisterService cityRegisterService;
	@Autowired
	
	CitySearchService citySearchService;
	
	@Autowired
	Validator validator;
	
	@Test
	public void test00_confirmRegisterService() {
		System.out.println("service=" + cityRegisterService);
	}
	
	@Test
	public void test00_confirmSearchService() {
		System.out.println("service=" + citySearchService);
	}
	
	@Test
	public void test00_confirmValidator() {
		System.out.println("validator=" + validator);
	}
	
	@Test
	public void test01_register() {
		CityForm city = new CityForm();
				
		city.setName("xxx");
		city.setCountryCode("KOx");
		
		BindingResult errors = new BeanPropertyBindingResult(city, "cityForm");
		validator.validate(city, errors);
		
		if (errors.hasErrors()) {
			System.out.println(errors);
			return;
		}
		
		cityRegisterService.register(city, errors);
		
		if (errors.hasErrors()) {
			System.out.println(errors);
			return;
		}
		
		System.out.println("id =" +  citySearchService.getCityById(city.getId()));
		
	}
	
	
}
