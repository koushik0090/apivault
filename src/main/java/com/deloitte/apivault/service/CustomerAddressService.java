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
public class CustomerAddressService {

	@Value("${customer.address.host}")
	String host;

	@Value("${customer.address.basic.auth.user}")
	String username;

	@Value("${customer.address.basic.auth.password}")
	String password;

	@Value("${customer.address.ep.create}")
	String create;

	@Value("${customer.address.ep.getall}")
	String getall;

	@Value("${customer.address.ep.getbyid}")
	String getbyid;

	@Value("${customer.address.ep.update}")
	String update;

	@Value("${customer.address.ep.delete}")
	String delete;

	public WebClient webClient = null;

	private static final Logger logger = LoggerFactory.getLogger(CustPartyOrganizationService.class);

	public CustomerAddressService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	public ResponseEntity<Object> getCustAddress(String PartyNumber) {

		logger.info("Entered getCustAddress");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getall, PartyNumber).retrieve().toEntity(Object.class).block();
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

	public ResponseEntity<Object> getCustAddressByPartyNumber(String PartyNumber, String AddressNumber) {
		logger.info("Entered getCustAddressByPartyNumber");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getbyid, PartyNumber, AddressNumber).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getCustAddressByPartyNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from getCustAddressByPartyNumber",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getCustAddressByPartyNumber");
		return response;
	}

	public ResponseEntity<Object> createCustAddress(String PartyNumber, Object customerAccount) {
		logger.info("Entered createCustAddress");
		logger.debug(host + create);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.post().uri(host + create, PartyNumber)
					.body(Mono.just(customerAccount), Object.class).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createCustAddress");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating createCustAddress",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createCustAddress");
		return response;

	}

	public ResponseEntity<Object> updateCustAddressByPartyNumber(String PartyNumber, String AddressNumber,
			Object customerAccount) {
		logger.info("Entered updateCustAddressByPartyNumber");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + update, PartyNumber, AddressNumber)
					.body(Mono.just(customerAccount), Object.class).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());

		} catch (WebClientResponseException ex) {
			logger.info("Error in updateCustAddressByPartyNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updating updateCustAddressByPartyNumber",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updateCustAddressByPartyNumber");
		return response;
	}

	public ResponseEntity<Object> deleteCustAddressByPartyNumber(String PartyNumber, String AddressNumber) {
		logger.info("Entered deleteCustAddressByPartyNumber");
		logger.debug(host + delete);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.delete().uri(host + delete, PartyNumber, AddressNumber).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in deleteCustAddressByPartyNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while delete from  deleteCustAddressByPartyNumber",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed deleteCustAddressByPartyNumber");
		return response;
	}

}
