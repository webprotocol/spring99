package com.example.city;

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
import com.example.domain.City;
import com.example.exception.NotFoundRuntimeException;
import com.example.exception.RegisterFailRuntimeException;

@Controller
@RequestMapping("/city")
public class CityRegisterController {
	
	static Log log = LogFactory.getLog(CityRegisterController.class);

	@Autowired
	CitySearchService citySearchService;
	
	@Autowired
	CityRegisterService cityRegisterService;
	
	@GetMapping("/register")
	public String registerForm(CityForm city) {
		log.info("registerForm(" + city + ")");
		
		return "city/registerForm";
	}
	
	@PostMapping("/register")
	public String register(@Valid CityForm city, BindingResult errors)  {
		log.info("register(" + city + ")");
		
		if (errors.hasErrors()) {
			errors.reject("cityForm.global.error", "errors 야............");
			System.out.println(errors);
			return "city/registerForm";
		}
		
		try {
			cityRegisterService.register(city);
		} catch (DataIntegrityViolationException e) {
			errors.rejectValue("countryCodeInvalid", null, "유효한 코드가 아닙니다. 확인하세요");
		}

		if (errors.hasErrors()) {
			System.out.println(errors);
			return "city/registerForm";
		}
				
		return "redirect:/city/register/success/" + city.getId();
	}
	
	@GetMapping("/register/success/{id}")
	public String registerSuccess(@PathVariable int id, Model model) {
		log.info("registerSuccess(" + id +")");
		City city = citySearchService.getCityById(id);
		model.addAttribute("city", city);
		return "city/registerSuccess";
	}

}
