package com.example.country;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.city.form.CityForm;
import com.example.city.service.CityRegisterService;
import com.example.city.service.CitySearchService;
import com.example.country.form.CountryForm;
import com.example.country.service.CountryRegisterService;
import com.example.country.service.CountrySearchService;
import com.example.domain.City;
import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.exception.RegisterFailRuntimeException;

@Controller
@RequestMapping("/country")
public class CountryRegisterController {
	
	static Log log = LogFactory.getLog(CountryRegisterController.class);

	@Autowired
	CountrySearchService countrySearchService;
	
	@Autowired
	CountryRegisterService countryRegisterService;
	
	@GetMapping("/register")
	public String registerForm(CountryForm country) {
		log.info("registerForm(" + country + ")");
		
		return "country/registerForm";
	}
	
	@PostMapping("/register")
	public String register(@Valid CountryForm country, BindingResult errors)  {
		log.info("register(" + country + ")");
		
		if (errors.hasErrors()) {
//			errors.reject("cityForm.global.error", "errors 야............");
			System.out.println(errors);
			return "country/registerForm";
		}
		
		try {
//			countryRegisterService.register(city);
		} catch (DataIntegrityViolationException e) {
			errors.rejectValue("countryCodeInvalid", null, "유효한 코드가 아닙니다. 확인하세요");
		}

		if (errors.hasErrors()) {
			System.out.println(errors);
			return "city/registerForm";
		}
				
		return "redirect:/country/register/success/" + country.getCode();
	}
	
	@GetMapping("/register/success/{code}")
	public String registerSuccess(@PathVariable String code, Model model) {
		log.info("registerSuccess(" + code +")");
		Country country = countrySearchService.getCountryByCode(code);
		model.addAttribute("country", country);
		return "country/registerSuccess";
	}

}
