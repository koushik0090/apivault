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
public class CustomerAccountService {

	@Value("${customer.account.host}")
	String host;

	@Value("${customer.account.basic.auth.user}")
	String username;

	@Value("${customer.account.basic.auth.password}")
	String password;

	@Value("${customer.account.ep.create}")
	String create;

	@Value("${customer.account.ep.getall}")
	String getall;

	@Value("${customer.account.ep.getbyid}")
	String getbyid;

	@Value("${customer.account.ep.update}")
	String update;

	@Value("${customer.account.ep.delete}")
	String delete;

	@Value("${customer.account.ep.findDuplicate}")
	String findDuplicate;

	public WebClient webClient = null;

	private static final Logger logger = LoggerFactory.getLogger(CustomerAccountService.class);

	public CustomerAccountService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	public ResponseEntity<Object> getCustAccount() {
		logger.info("Entered getCustAddress");
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

	public ResponseEntity<Object> getCustAccountByPartyNumber(String PartyNumber) {
		logger.info("Entered getCustAccountByPartyNumber");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getall, PartyNumber).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getCustAccountByPartyNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from getCustAccountByPartyNumber",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getCustAccountByPartyNumber");
		return response;
	}

	public ResponseEntity<Object> createCustAccount(Object customerAccount) {
		logger.info("Entered createCustAccount");
		logger.debug(host + create);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.post().uri(host + create).body(Mono.just(customerAccount), Object.class)
					.retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createCustAccount");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating createCustAccount",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createCustAccount");
		return response;
	}

	public ResponseEntity<Object> updateCustAccountByPartyNumber(String PartyNumber, Object customerAccount) {
		logger.info("Entered updateCustAccountByPartyNumber");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + update, PartyNumber)
					.body(Mono.just(customerAccount), Object.class).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());

		} catch (WebClientResponseException ex) {
			logger.info("Error in updateCustAccountByPartyNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updating updateCustAddressByPartyNumber",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updateCustAccountByPartyNumber");
		return response;
	}

	public ResponseEntity<Object> deleteCustAccountByPartyNumber(String PartyNumber) {
		logger.info("Entered deleteCustAccountByPartyNumber");
		logger.debug(host + delete);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + delete, PartyNumber).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in deleteCustAccountByPartyNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while delete from  deleteCustAccountByPartyNumber",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed deleteCustAccountByPartyNumber");
		return response;
	}

}
