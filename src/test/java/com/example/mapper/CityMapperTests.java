package com.example.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.city.form.CityForm;
import com.example.domain.City;
import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTests {
	
	@Autowired
	CityMapper cityMapper;
	
	@Autowired
	CountryMapper countryMapper;
	
	@Autowired
	Validator validator;
	
	@Test
	public void test00_confirmCityMapper() {
		System.out.println("cityMapper=" + cityMapper);
	}
	
	@Test
	public void test00_confirmCountryMapper() {
		System.out.println("countryMapper=" + countryMapper);
	}
	
	@Test
	public void test00_confirmValidator() {
		System.out.println("validator=" + validator);
	}
	
	@Test
	public void test01_selectAll() {
		List<City> list = cityMapper.selectAll();
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test01_selectAllWithCountry() {
		List<City> list = cityMapper.selectAllWithCountry();
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPage() {
		Pagination paging = new Pagination();
		paging.setTotalItem(cityMapper.selectTotalCount());
		paging.setPageNo(1000);
		
		List<City> list = cityMapper.selectPage(paging);
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPageWithCountry() {
		Pagination paging = new Pagination();
		paging.setTotalItem(cityMapper.selectTotalCount());
		paging.setPageNo(2);
		
		List<City> list = cityMapper.selectPageWithCountry(paging);
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test03_selectById() {
		City city = cityMapper.selectById(4560000);
		
		if (city == null) {
			throw new NotFoundRuntimeException("City 정보가 없습니다");
		}
		
		System.out.println(city);
	}
	
	@Test
	public void test03_selectByIdWithCountry() {
		City city = cityMapper.selectByIdWithCountry(10);
		
		if (city == null) {
			throw new NotFoundRuntimeException("City 정보가 없습니다");
		}
		
		System.out.println(city);
	}
	
	@Test
	public void test04_insert() {
		City city = new City();
		BindingResult errors = new BeanPropertyBindingResult(city, "cityForm");

		city.setName("xxxx");
		city.setCountryCode("KOR");
		
		Country country = countryMapper.selectByCode(city.getCountryCode());
		if (country == null) {
			errors.reject("InvalidCountryCode", null, "유효한 ContryCode가 아닙니다.");
			System.out.println(errors);
			return;
		}
		
		cityMapper.insert(city);
		System.out.println(cityMapper.selectById(city.getId()));
	}
	
	@Test
	public void test05_updateById() {
		City city = new City();
		BindingResult errors = new BeanPropertyBindingResult(city, "cityForm");
		
		int id = 4182;
		city = cityMapper.selectById(id);
		if (city == null) {
			errors.reject("InvalidId", null, "해당 id가 존재하지 않습니다.");
			System.out.println(errors);
			return;
		}

		city.setName("zzzz");
		city.setCountryCode("KOR");

		Country country = countryMapper.selectByCode(city.getCountryCode());
		if (country == null) {
			errors.reject("InvalidCountryCode", null, "유효한 ContryCode가 아닙니다.");
			System.out.println(errors);
			return;
		}
		
		cityMapper.updateById(city);
		System.out.println("id =" + cityMapper.selectById(city.getId()));
	}

	@Test
	public void test05_deleteById() {
		int id = 4181;
		int cnt = cityMapper.deleteById(id);
		System.out.println("cnt=" + cnt);
		System.out.println("city = " + cityMapper.selectById(id));
	}
	
}









