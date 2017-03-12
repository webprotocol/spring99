package com.example.city.form;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.domain.City;
import com.example.domain.Country;

public class CityForm extends City {

	
	String countryCodeInvalid;
	
	public String getCountryCodeInvalid() {
		return countryCodeInvalid;
	}

	public void setCountryCodeInvalid(String countryCodeInvalid) {
		this.countryCodeInvalid = countryCodeInvalid;
	}

	@NotNull
	@Size(max=35)
	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setName(String name) {
		if (name != null && name.trim().equals(""))	name = null;
		super.setName(name);
	}

	@Size(max=3)
	@Override
	public String getCountryCode() {
		return super.getCountryCode();
	}

	@Override
	public void setCountryCode(String countryCode) {
		if (countryCode != null && countryCode.trim().equals(""))	countryCode = null;
		super.setCountryCode(countryCode);
	}

	@Size(max=20)
	@Override
	public String getDistrict() {
		return super.getDistrict();
	}

	@Override
	public void setDistrict(String district) {
		if (district != null && district.trim().equals(""))	district = null;
		super.setDistrict(district);
	}

	@Digits(integer=11, fraction = 0)
	@Override
	public BigDecimal getPopulation() {
		return super.getPopulation();
	}

	@Override
	public void setPopulation(BigDecimal population) {
		super.setPopulation(population);
	}

}
