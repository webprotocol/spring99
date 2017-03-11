package com.example.city.form;

import java.util.Objects;

import com.example.domain.City;

public class CityForm extends City {

	
	String countryCodeInvalid;
	
	public String getCountryCodeInvalid() {
		return countryCodeInvalid;
	}

	public void setCountryCodeInvalid(String countryCodeInvalid) {
		this.countryCodeInvalid = countryCodeInvalid;
	}

	String nullStringToNull(String value) {
		if (Objects.nonNull(value)) {
			if (value.trim().equals(""))
				value = null;
		}
		return value;
	}
	
	@Override
	public City setName(String value) {
		return super.setName(nullStringToNull(value));
	}
	
	@Override
	public City setCountryCode(String value) {
		return super.setCountryCode(nullStringToNull(value));
	}
	
	@Override
	public City setDistrict(String value) {
		return super.setDistrict(nullStringToNull(value));
	}

}
