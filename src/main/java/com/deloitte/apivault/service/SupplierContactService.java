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
public class SupplierContactService {

	@Value("${suppliers.contact.host}")
	String host;
	
	@Value("${suppliers.contact.basic.auth.user}")
	String username;
	
	@Value("${suppliers.contact.basic.auth.password}")
	String password;
	
	@Value("${suppliers.contact.ep.create}")
	String create;
	
	@Value("${suppliers.contact.ep.getall}")
	String getall;

	@Value("${suppliers.contact.ep.getbyid}")
	String getbyid;
	
	@Value("${suppliers.contact.ep.update}")
	String update;
	
	public WebClient webClient = null;
	
	private static final Logger logger = LoggerFactory.getLogger(SupplierContactService.class);

public SupplierContactService(WebClient.Builder webClientBuilder) {
		
		this.webClient =  webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
		
	}

	public ResponseEntity<Object> getSupplierContactById(String SupplierId,String SupplierContactId) {
		
		logger.info("Entered getSupplierContactById");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
		     response = this.webClient.get().uri(host + getall,SupplierId,SupplierContactId).retrieve().toEntity(Object.class).block();
		     logger.debug(response.toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getSupplierContactById");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from getSupplierContactById",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getSupplierContactById");
		return response;
	}

	public ResponseEntity<Object> createSupplierContact(String SupplierId, Object supplier) {
		
		logger.info("Entered createSupplierContact");
		logger.debug(host + create);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.post().uri(host + create,SupplierId).body(Mono.just(supplier), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createSupplierContact");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating createSupplierContact",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createSupplierContact");
		return response;
	}

	public ResponseEntity<Object> updateSupplierContact(String SupplierId, String SupplierContactId, Object supplier) {
		
		logger.info("Entered updateSupplierContact");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + update,SupplierId,SupplierContactId).body(Mono.just(supplier), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in updateSupplierContact");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updating updateSupplierContact",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updateSupplierContact");
		return response;
	}

	public ResponseEntity<Object> getListSupplierContact(String SupplierId) {
		
		logger.info("Entered getListSupplierContact");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
		     response = this.webClient.get().uri(host + getall,SupplierId).retrieve().toEntity(Object.class).block();
		     logger.debug(response.toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getListSupplierContact");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from getListSupplierContact",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getListSupplierContact");
		return response;
	}

}
