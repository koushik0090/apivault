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
public class SupplierService {

	@Value("${suppliers.host}")
	String host;

	@Value("${suppliers.basic.auth.user}")
	String username;

	@Value("${suppliers.basic.auth.password}")
	String password;

	@Value("${suppliers.ep.create}")
	String create;

	@Value("${suppliers.ep.getall}")
	String getall;

	@Value("${suppliers.ep.getbyid}")
	String getbyid;

	@Value("${suppliers.ep.update}")
	String update;

	public WebClient webClient = null;

	private static final Logger logger = LoggerFactory.getLogger(SupplierService.class);

	public SupplierService(WebClient.Builder webClientBuilder) {

		this.webClient = webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	// Get all supplier
	public ResponseEntity<Object> getAllSupplier() {

		logger.info("Entered getAllSupplier");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
			 response  = this.webClient.get().uri(host + getall).retrieve().toEntity(Object.class).block();
			 logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getAllSupplier");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from Supplier",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getAllSupplier");
		return response;
	}

	// Get supplier by suppliers number
	public ResponseEntity<Object> getSupplierByNumber(String SupplierId) {

		logger.info("Entered getSupplierByNumber");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getbyid, SupplierId).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getSupplierByNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from Supplier by id",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getSupplierByNumber");
		return response;
	}

	// Create supplier
	public ResponseEntity<Object> createSupplier(Object supplier) {
		logger.info("Entered createSupplier");
		logger.debug(host + create);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.post().uri(host + create).body(Mono.just(supplier), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createSupplier");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating Supplier",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createSupplier");
		return response;
	}

	// Update supplier
	public ResponseEntity<Object> updateSupplier(Object supplier, String SupplierId) {

		logger.info("Entered updateSupplier");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + update,SupplierId).body(Mono.just(supplier), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
			
		} catch (WebClientResponseException ex) {
			logger.info("Error in updateSupplier");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updating Supplier",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updateSupplier");
		return response;
	}

}
