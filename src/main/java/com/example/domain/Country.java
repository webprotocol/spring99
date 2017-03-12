package com.example.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Country {


	private String code;
	@NotNull
	@Size(max=52)
	private String name;
	@Pattern(regexp="Asia|Europe|North America|Africa|Oceania|Antarctica|South America", message="Asia|Europe|North America|Africa|Oceania|Antarctica|South America")
	private String continent;
	@Size(max=26)
	private String region;
	@Digits(integer=8, fraction=2)
	private BigDecimal surfaceArea;
	@Digits(integer=6, fraction=0)
	private BigDecimal indepYear;
	@Digits(integer=11, fraction=0)
	private BigDecimal population;
	@Digits(integer=2, fraction=1)
	private BigDecimal lifeExpectancy;
	@Digits(integer=8, fraction=2)
	private BigDecimal gnp;
	@Digits(integer=8, fraction=2)
	private BigDecimal gnpOld;
	@Size(max=45)
	private String localName;
	@Size(max=45)
	private String governmentForm;
	@Size(max=60)
	private String headOfState;
	@Digits(integer=11, fraction=0)
	private BigDecimal capital;
	@Size(max=2)
	private String code2;
	private List<City> citys;
	

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public Country() {
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
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public BigDecimal getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(BigDecimal surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public BigDecimal getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(BigDecimal indepYear) {
		this.indepYear = indepYear;
	}

	public BigDecimal getPopulation() {
		return population;
	}

	public void setPopulation(BigDecimal population) {
		this.population = population;
	}

	public BigDecimal getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(BigDecimal lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public BigDecimal getGnp() {
		return gnp;
	}

	public void setGnp(BigDecimal gnp) {
		this.gnp = gnp;
	}

	public BigDecimal getGnpOld() {
		return gnpOld;
	}

	public void setGnpOld(BigDecimal gnpOld) {
		this.gnpOld = gnpOld;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

}
