package com.example.city;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CityRegisterControllerTests {
	
	@LocalServerPort
	int port;
	
	@Autowired
	TestRestTemplate rest;
	
	@Test
	public void test00_confirmTestRestTemplate() {
		System.out.println("port=" + port);
		System.out.println("rest=" + rest);
	}
	
	@Test
	public void test01_register_GET() {
		String html = rest.getForObject("/city/register", String.class);
		System.out.println(html);
	}
	
	@Test
	public void test01_register_POST() {
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("name", "uuu");
//		params.add("countryCode", "xxx");
		
		ResponseEntity<String> response = rest.postForEntity("/city/register", params, String.class);
		
		URI redirectUri = response.getHeaders().getLocation();
		if (redirectUri == null)
			System.out.println(response.getBody());
		else {
			System.out.println(redirectUri);
			String html = rest.getForObject(redirectUri, String.class);
			System.out.println(html);
		}
	}

}
