package com.sq.learn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sq.learn.exception.ActiveCheckAPIException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountService {
	
	@Value("${activation.api.uri}")
	private String activationApiUri;
	
	@Autowired
	RestTemplate restTemplate;
	
	public Boolean getAccount(Integer empNo) {
		log.debug("Activation check started for employee {}", empNo);
		try {
		ResponseEntity<Boolean> response = restTemplate.getForEntity(activationApiUri + empNo, Boolean.class, "");
		log.debug("Activation check completed for employee {} and Active status is {} ", empNo, response.getBody());
		return response.getBody();
		} catch (Exception e) {
			throw new ActiveCheckAPIException("Error while checking employee activation " + e.getMessage());
		}
	}

}
