package com.verisure.vcp.mongodb.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.verisure.vcp.mongodb.api.dto.ItemDTO;
import com.verisure.vcp.mongodb.client.RestTemplateClientExample;

/**
 * Sample Spring Rest Template Implementation client used as template. <b>Please remove for actual project implementation.</b>
 *
 * @since 3.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Service
public class RestTemplateClientExampleImpl implements RestTemplateClientExample {

	@Autowired
	RestTemplate restTemplate;

	public List<ItemDTO> getItems() {	
		
		String url  = "http://localhost:8080/remote";
		
		ResponseEntity<List<ItemDTO>> response = restTemplate.exchange(
		  url,
		  HttpMethod.GET,
		  null,
		  new ParameterizedTypeReference<List<ItemDTO>>(){});
		List<ItemDTO> items = response.getBody();
		return items;
	}
}
