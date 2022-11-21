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
public class CustPartyOrganizationService {

	@Value("${customer.org.host}")
	String host;

	@Value("${customer.org.basic.auth.user}")
	String username;

	@Value("${customer.org.basic.auth.password}")
	String password;

	@Value("${customer.org.ep.create}")
	String create;

	@Value("${customer.org.ep.getall}")
	String getall;

	@Value("${customer.org.ep.getbyid}")
	String getbyid;

	@Value("${customer.org.ep.update}")
	String update;

	@Value("${customer.org.ep.delete}")
	String delete;

	public WebClient webClient = null;

	private static final Logger logger = LoggerFactory.getLogger(CustPartyOrganizationService.class);

	public CustPartyOrganizationService(WebClient.Builder webClientBuilder) {

		this.webClient = webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

	}

	public ResponseEntity<Object> getOrganization() {

		logger.info("Entered getOrganization");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getall).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getOrganization");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from getOrganization",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getOrganization");
		return response;
	}

	public ResponseEntity<Object> createOrganization(Object organization) {

		logger.info("Entered createOrganization");
		logger.debug(host + create);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.post().uri(host + create).body(Mono.just(organization), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createOrganization");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating createOrganization",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createOrganization");
		return response;

	}

	public ResponseEntity<Object> getPartyNumber(String partyNumber) {

		logger.info("Entered getPartyNumber");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getbyid, partyNumber).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getPartyNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from  getPartyNumber",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getPartyNumber");
		return response;
	}

	public ResponseEntity<Object> updatePartyNumber(Object organisation, String partyNumber) {

		logger.info("Entered updatePartyNumber");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + update, partyNumber)
					.body(Mono.just(organisation), Object.class).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());

		} catch (WebClientResponseException ex) {
			logger.info("Error in updatePartyNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updating employee",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updatePartyNumber");
		return response;
	}

	public ResponseEntity<Object> deletePartyNumber(String partyNumber) {

		logger.info("Entered deletePartyNumber");
		logger.debug(host + delete);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + delete, partyNumber).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in deletePartyNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while delete from  deletePartyNumber",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed deletePartyNumber");
		return response;
	}

}