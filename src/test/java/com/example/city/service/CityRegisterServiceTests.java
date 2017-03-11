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

import com.example.domain.City;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRegisterServiceTests {

	@Autowired
	CityRegisterService service;
	
	@Autowired
	Validator validator;
	
	@Test
	public void test00_confirmService() {
		System.out.println("service=" + service);
	}
	
	@Test
	public void test00_confirmValidator() {
		System.out.println("validator=" + validator);
	}
	
	@Test
	public void test01_register() {
		City city = new City();
		city.setName("xxx");
		city.setCountryCode("KOR");
		
		BindingResult result = new BeanPropertyBindingResult(city, "city");
		validator.validate(city, result);
		
		if (result.hasErrors()) {
			System.out.println(result);
			return;
		}
		
		service.register(city);
		System.out.println("id =" + city.getId());
		
	}
	
	
}
