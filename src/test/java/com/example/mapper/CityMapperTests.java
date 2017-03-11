package com.example.mapper;

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
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTests {
	
	@Autowired
	CityMapper mapper;
	
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
	public void test01_selectAll() {
		List<City> list = mapper.selectAll();
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test01_selectAllWithCountry() {
		List<City> list = mapper.selectAllWithCountry();
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPage() {
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(1000);
		
		List<City> list = mapper.selectPage(paging);
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPageWithCountry() {
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(2);
		
		List<City> list = mapper.selectPageWithCountry(paging);
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test03_selectById() {
		City city = mapper.selectById(4560000);
		
		if (city == null) {
			throw new NotFoundRuntimeException("City 정보가 없습니다");
		}
		
		System.out.println(city);
	}
	
	@Test
	public void test03_selectByIdWithCountry() {
		City city = mapper.selectByIdWithCountry(10);
		
		if (city == null) {
			throw new NotFoundRuntimeException("City 정보가 없습니다");
		}
		
		System.out.println(city);
	}
	
	@Test
	public void test04_insert() {
		City city = new City();
		city.setName("xxx");
		city.setCountryCode("KOR");
		
		BindingResult result = new BeanPropertyBindingResult(city, "city");
		validator.validate(city, result);
		
		if (result.hasErrors()) {
			System.out.println(result);
			return;
		}
		
		int cnt = mapper.insert(city);
		System.out.println("cnt=" + cnt);
		System.out.println("id =" + city.getId());
		
	}
	

	
	@Test
	public void test05_updateById() {
		City city = new City();
		city.setId(4088);
		city.setName("xxx");
		city.setCountryCode("KORR");
		
		BindingResult errors = new BeanPropertyBindingResult(city, "city");
		validator.validate(city, errors);
		
		if (errors.hasErrors()) {
			System.out.println("errors = " + errors);
			return;
		}
		
		int cnt = mapper.updateById(city);
		System.out.println("cnt=" + cnt);
		System.out.println("id =" + city.getId());
	}

	@Test
	public void test05_deleteById() {
		int cnt = mapper.deleteById(4102);
		System.out.println("cnt=" + cnt);
	}
	
}









