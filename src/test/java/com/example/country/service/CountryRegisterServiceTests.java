package com.example.country.service;

import java.math.BigDecimal;

import org.apache.ibatis.javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;

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
		country.setCode("K10");
		country.setName("xxxx");
		country.setContinent("Europe ");
		
		BindingResult errors = new BeanPropertyBindingResult(country, "country");
		
		validator.validate(country, errors);
		if (errors.hasErrors()) {
			System.out.println("error =" + errors);
			return;
		}
		
		
		try {
			searchService.getCountryByCode(country.getCode());
			
			registerService.register(country);
			System.out.println(searchService.getCountryByCode(country.getCode()));
			System.out.println("[" + country.getName() + "]");
		} catch (NotFoundRuntimeException e) {
		
		} catch (DuplicateKeyException e) {
			System.out.println("code 중복 에러");
		} catch (DataIntegrityViolationException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
