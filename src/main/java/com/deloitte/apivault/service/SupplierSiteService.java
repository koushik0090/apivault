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
public class SupplierSiteService {

	@Value("${suppliers.sites.host}")
	String host;
	
	@Value("${suppliers.sites.basic.auth.user}")
	String username;
	
	@Value("${suppliers.sites.basic.auth.password}")
	String password;
	
	@Value("${suppliers.sites.ep.create}")
	String create;
	
	@Value("${suppliers.sites.ep.getall}")
	String getall;

	@Value("${suppliers.sites.ep.getbyid}")
	String getbyid;
	
	@Value("${suppliers.sites.ep.update}")
	String update;

	public WebClient webClient = null;

	private static final Logger logger = LoggerFactory.getLogger(SupplierSiteService.class);
	
public SupplierSiteService(WebClient.Builder webClientBuilder) {
		
		this.webClient =  webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
		
	}

	public ResponseEntity<Object> getAllSupplierSite(String SupplierId ) {
		
		logger.info("Entered getAllSupplierSite");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
		     response = this.webClient.get().uri(host + getall,SupplierId).retrieve().toEntity(Object.class).block();
		     logger.debug(response.toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getAllSupplierSite");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from getAllSupplierSite",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getAllSupplierSite");
		return response;
	}

	public ResponseEntity<Object> getSupplierSiteByNumber(String SupplierId,String SupplierSiteId) {
		
		logger.info("Entered getSupplierSiteByNumber");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
		     response = this.webClient.get().uri(host + getall,SupplierId,SupplierSiteId).retrieve().toEntity(Object.class).block();
		     logger.debug(response.toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getSupplierSiteByNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from getSupplierSiteByNumber",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getSupplierSiteByNumber");
		return response;
	}

	public ResponseEntity<Object> createSupplierSite(String SupplierId,Object supplier) {
		
		logger.info("Entered createSupplierSite");
		logger.debug(host + create);
		ResponseEntity<Object> response = null;
		try {
			response= this.webClient.post().uri(host + create,SupplierId).body(Mono.just(supplier), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createSupplierSite");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating createSupplierSite",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createSupplierSite");
		return response;
	}

	public ResponseEntity<Object> updateSupplierSite(String SupplierId, String SupplierSiteId, Object supplier) {
		
		logger.info("Entered updateSupplierSite");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response= this.webClient.patch().uri(host + update,SupplierId,SupplierSiteId).body(Mono.just(supplier), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in updateSupplierSite");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updating updateSupplierSite",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updateSupplierSite");
		return response;
	}

}
