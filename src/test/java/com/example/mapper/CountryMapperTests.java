package com.example.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
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
		country.setContinent("Asia");
		
		try {
			int cnt = mapper.insert(country);
			System.out.println("cnt=" + cnt);
			System.out.println(mapper.selectByCode(country.getCode()));
		} catch (DuplicateKeyException e) {
			System.out.println("Code 중복 에러");
		} catch (Exception e) {
			System.out.println("발생해서는 안되는 에러입니다. 유효성 검사를 해양한다");
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void test05_updateById() {
		Country country = new Country();
		country.setCode("KKK");
		country.setName("yyyy");
		
		try {
			int cnt = mapper.updateByCode(country);
			System.out.println("cnt=" + cnt);
			System.out.println(mapper.selectByCode(country.getCode()));
		} catch (Exception e) {
			System.out.println("발생해서는 안되는 에러입니다. 유효성 검사를 해양한다");
			e.printStackTrace();
		}
	}

	@Test
	public void test05_deleteById() {
		int cnt = mapper.deleteByCode("KKK");
		System.out.println("cnt=" + cnt);
		System.out.println(mapper.selectByCode("KKK"));
	}	


}
