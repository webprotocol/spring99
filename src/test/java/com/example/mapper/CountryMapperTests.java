package com.example.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryMapperTests {
	
	@Autowired
	CountryMapper mapper;
	
	@Autowired
	Validator validator;
	
	
	@Test
	public void test00_confirmMapper() {
		System.out.println("mapper=" + mapper);
	}

	@Test
	public void test00_confirmValidator() {
		System.out.println("validator=" + validator);
	}
	
	@Test
	public void test00_selectTotalCount() {
		System.out.println("totalCount=" + mapper.selectTotalCount());
	}
	
	@Test
	public void test01_selectAll() {
		List<Country> list = mapper.selectAll();
		
		for (Country c : list)
			System.out.println(c); 
			
	}
	
	@Test
	public void test01_selectAllWithCity() {
		List<Country> list = mapper.selectAllWithCity();
		
		for (Country c : list)
			System.out.println(c);
		
	}
	
	@Test
	public void test02_selectPage() {
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(20);
		
		List<Country> list = mapper.selectPage(paging);
		for (Country c : list)
			System.out.println(c);
		
	}
	
	@Test
	public void test02_selectPageWithCity() {
		
	}
	
	@Test
	public void test03_selectByCode() {
		Country country = mapper.selectByCode("xxx");
		if (country == null) 
			throw new NotFoundRuntimeException("country가 없습니다.");
		
		System.out.println(country);
	}
	
	@Test
	public void test03_selectByCodeWithCity() {
		Country country = mapper.selectByCodeWithCity("KOR");
		if (country == null) 
			throw new NotFoundRuntimeException("country가 없습니다.");
		
		System.out.println(country);
	}
	
	@Test
	public void test04_insert() {
		Country country = new Country();
		country.setCode("KKK");
		country.setName("xxxxxx");
		country.setLifeExpectancy(new BigDecimal("12.5"));
		
		BindingResult errors = new BeanPropertyBindingResult(country, "country");
		validator.validate(country, errors);
		
		if (errors.hasErrors()) {
			System.out.println(errors);
			return;
		}
		
		int cnt = mapper.insert(country);
		System.out.println("cnt=" + cnt);
		System.out.println("code =" + country.getCode());
		
	}
	

	
	@Test
	public void test05_updateById() {
		Country country = new Country();
		country.setCode("KKK");
		country.setName("yyyy");
		country.setLifeExpectancy(new BigDecimal("12.5"));
		
		BindingResult errors = new BeanPropertyBindingResult(country, "country");
		validator.validate(country, errors);
		
		if (errors.hasErrors()) {
			System.out.println(errors);
			return;
		}
		
		int cnt = mapper.updateByCode(country);
		System.out.println("cnt=" + cnt);
		System.out.println("code =" + country.getCode());
		System.out.println(mapper.selectByCode("KKK"));
	}

	@Test
	public void test05_deleteById() {
		int cnt = mapper.deleteByCode("KKK");
		System.out.println("cnt=" + cnt);
	}	


}
