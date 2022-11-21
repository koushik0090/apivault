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
public class SupplierAddressService {

	@Value("${suppliers.addresses.host}")
	String host;
	
	@Value("${suppliers.addresses.basic.auth.user}")
	String username;
	
	@Value("${suppliers.addresses.basic.auth.password}")
	String password;
	
	@Value("${suppliers.addresses.ep.create}")
	String create;
	
	@Value("${suppliers.addresses.ep.getall}")
	String getall;

	@Value("${suppliers.addresses.ep.getbyid}")
	String getbyid;
	
	@Value("${suppliers.addresses.ep.update}")
	String update;

	public WebClient webClient = null;
	
	private static final Logger logger = LoggerFactory.getLogger(SupplierAddressService.class);

public SupplierAddressService(WebClient.Builder webClientBuilder) {
		
		this.webClient =  webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
		
	}

	public ResponseEntity<Object> getListSupplierAddress(String SupplierId) {
		
		logger.info("Entered getListSupplierAddress");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
		     response = this.webClient.get().uri(host + getall,SupplierId).retrieve().toEntity(Object.class).block();
		     logger.debug(response.toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getListSupplierAddress");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from getListSupplierAddress",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getListSupplierAddress");
		return response;
	}

	public ResponseEntity<Object> getSupplierAddressById(String SupplierId,String SupplierAddressId) {
		
		logger.info("Entered getSupplierAddressById");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
		     response = this.webClient.get().uri(host + getall,SupplierId,SupplierAddressId).retrieve().toEntity(Object.class).block();
		     logger.debug(response.toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getSupplierAddressById");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from getSupplierAddressById",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getSupplierAddressById");
		return response;

	}

	public ResponseEntity<Object> createSupplierAddress(Object supplier,String SupplierId) {
		
		logger.info("Entered createSupplierAddress");
		logger.debug(host + create);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.post().uri(host + create,SupplierId).body(Mono.just(supplier), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createSupplierAddress");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating createSupplierAddress",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createSupplierAddress");
		return response;

	}

	public ResponseEntity<Object> updateSupplierAddress(Object supplier, String SupplierId,String SupplierAddressId) {
		
		logger.info("Entered updateSupplierAddress");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + update,SupplierId,SupplierAddressId).body(Mono.just(supplier), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in updateSupplierAddress");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updating updateSupplierContact",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updateSupplierAddress");
		return response;
	}

}
