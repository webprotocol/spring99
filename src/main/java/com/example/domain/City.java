package com.example.domain;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class City {

	private int id;
	@NotNull
	@Size(min=1, max=35)
	private String name;
	@Size(max=3)
	private String countryCode;
	@Size(max=20)
	private String district;
	@Digits(integer=11, fraction = 0)
	private BigDecimal population;
	private Country country;
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public City() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		String str= null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return str;
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param value the id to set
	 */
	public City setId(final int value) {
		id = value;
		return this;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param value the name to set
	 */
	public City setName(final String value) {
		name = value;
		return this;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param value the countryCode to set
	 */
	public City setCountryCode(final String value) {
		countryCode = value;
		return this;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param value the district to set
	 */
	public City setDistrict(final String value) {
		district = value;
		return this;
	}

	/**
	 * @return the population
	 */
	public BigDecimal getPopulation() {
		return population;
	}

	/**
	 * @param value the population to set
	 */
	public City setPopulation(final BigDecimal value) {
		population = value;
		return this;
	}

}
