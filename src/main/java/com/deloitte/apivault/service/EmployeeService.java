package com.deloitte.apivault.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
	
	@Value("${employees.host}")
	String host;
	
	@Value("${employees.basic.auth.user}")
	String username;
	
	@Value("${employees.basic.auth.password}")
	String password;
	
	@Value("${employees.ep.create}")
	String create;
	
	@Value("${employees.ep.getall}")
	String getall;

	@Value("${employees.ep.getbyid}")
	String getbyid;
	
	@Value("${employees.ep.update}")
	String update;
	
	public WebClient webClient = null;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	public EmployeeService(WebClient.Builder webClientBuilder) {
		this.webClient =  webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
		
	}

	public ResponseEntity<Object> getEmp() {
		logger.info("Entered getEmp");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
			 response  = this.webClient.get().uri(host + getall).retrieve().toEntity(Object.class).block();
			 logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getEmp");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from getEmp",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getEmp");
		return response;
	}

	public ResponseEntity<Object> getEmpById(String empsUniqID) {
		logger.info("Entered getEmpById");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getbyid, empsUniqID).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getEmpById");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from  getEmpById",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getEmpById");
		return response;
	}

	public ResponseEntity<Object> createEmp(Object employee) {
		logger.info("Entered createEmp");
		logger.debug(host + create);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.post().uri(host + create).body(Mono.just(employee), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createEmp");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating createEmp",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createEmp");
		return response;
		
	}

	public ResponseEntity<Object> updateEmp(String empsUniqID,Object employee) {
		logger.info("Entered updateEmp");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + update,empsUniqID).body(Mono.just(employee), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
			
		} catch (WebClientResponseException ex) {
			logger.info("Error in updateEmp");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updating employee",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updateEmp");
		return response;
	}
	
	
	
	

}
