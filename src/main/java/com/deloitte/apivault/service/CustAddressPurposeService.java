
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
public class CustAddressPurposeService {
	
	 
	
	@Value("${customer.address.purpose.host}")
	String host;
	
	@Value("${customer.address.purpose.basic.auth.user}")
	String username;
	
	@Value("${customer.address.purpose.basic.auth.password}")
	String password;
	
	@Value("${customer.address.purpose.ep.create}")
	String create;
	
	@Value("${customer.address.purpose.ep.getall}")
	String getall;

	@Value("${customer.address.purpose.ep.getbyid}")
	String getbyid;
	
	@Value("${customer.address.purpose.ep.update}")
	String update;
	
	@Value("${customer.address.purpose.ep.delete}")
	String delete;
	
	public WebClient webClient = null;
	
	private static final Logger logger = LoggerFactory.getLogger(CustAddressPurposeService.class);
	
	public CustAddressPurposeService(WebClient.Builder webClientBuilder) {		
		this.webClient =  webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();		
	}
	
	public ResponseEntity<Object> getCustAddressPurpose(String PartyNumber,String AddressNumber) {
		
		logger.info("Entered getCustAddressPurpose");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getall,PartyNumber,AddressNumber).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getCustAddressPurpose");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from getCustAddressPurpose",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getCustAddressPurpose");
		return response;
	}

	public ResponseEntity<Object> getCustAddressPurposeByPartyNumber(String PartyNumber,String AddressNumber,String AddressPurposeId) {
		logger.info("Entered getCustAddressPurposeByPartyNumber");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getbyid, PartyNumber, AddressNumber, AddressPurposeId).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getCustAddressPurposeByPartyNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from  getCustAddressPurposeByPartyNumber",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getCustAddressPurposeByPartyNumber");
		return response;
	}

	public ResponseEntity<Object> createCustAddressPurpose(String PartyNumber,String AddressNumber,Object customerAccount) {
		logger.info("Entered createCustAddressPurpose");
		logger.debug(host + create);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.post().uri(host + create, PartyNumber, AddressNumber).body(Mono.just(customerAccount), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createCustAddressPurpose");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating createCustAddressPurpose",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createCustAddressPurpose");
		return response;
	}

	public ResponseEntity<Object> updateCustAddressPurposeByPartyNumber(String PartyNumber,String AddressNumber,String AddressPurposeId ,Object customerAccount) {
		logger.info("Entered updateCustAddressPurposeByPartyNumber");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + update, PartyNumber, AddressNumber, AddressPurposeId)
					.body(Mono.just(customerAccount), Object.class).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());

		} catch (WebClientResponseException ex) {
			logger.info("Error in updateCustAddressPurposeByPartyNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updateCustAddressPurposeByPartyNumber",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updateCustAddressPurposeByPartyNumber");
		return response;
	}



	public ResponseEntity<Object> deleteCustAddressPurposeByPartyNumber(String PartyNumber,String AddressNumber,String AddressPurposeId) {
		logger.info("Entered deleteCustAddressPurposeByPartyNumber");
		logger.debug(host + delete);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + delete, PartyNumber, AddressNumber, AddressPurposeId).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in deleteCustAddressPurposeByPartyNumber");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while delete from  deleteCustAddressPurposeByPartyNumber",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed deleteCustAddressPurposeByPartyNumber");
		return response;
	}


}
