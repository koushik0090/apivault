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
public class ReceivableInvoice {
	
	@Value("${invoice.receivable.host}")
	String host;

	@Value("${invoice.receivable.basic.auth.user}")
	String username;

	@Value("${invoice.receivable.basic.auth.password}")
	String password;

	@Value("${invoice.receivable.ep.create}")
	String create;

	@Value("${invoice.receivable.ep.getall}")
	String getall;

	@Value("${invoice.receivable.ep.getbyid}")
	String getbyid;

	@Value("${invoice.receivable.ep.update}")
	String update;
	
	@Value("${invoice.receivable.ep.delete}")
	String delete;
	
	public WebClient webClient = null;
	
	private static final Logger logger = LoggerFactory.getLogger(ReceivableInvoice.class);

	public  ReceivableInvoice(WebClient.Builder webClientBuilder) {
		
		this.webClient = webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	public ResponseEntity<Object> getAllInvoices() {
		logger.info("Entered getAllInvoices");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getall).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getAllInvoices");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from invoices",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getAllInvoices");
		return response;
	}
	
	public ResponseEntity<Object> createInvoice(Object invoice) {
		logger.info("Entered createInvoice");
		logger.debug(host + create);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.post().uri(host + create).body(Mono.just(invoice), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createInvoice");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating Invoice",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createInvoice");
		return response;
	}
	
	public ResponseEntity<Object> getInvoiceById(String CustomerTransactionId) {
		logger.info("Entered getInvoiceById");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getbyid, CustomerTransactionId).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getInvoiceById");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from invoice by invoicesUniqID",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getInvoiceById");
		return response;
	}
	
	public ResponseEntity<Object> deleteInvoiceById(String invoicesUniqID) {
		logger.info("Entered deleteInvoiceById");
		logger.debug(host + delete);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + delete, invoicesUniqID).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in deleteInvoiceById");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while delete invoice by invoicesUniqID",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed deleteInvoiceById");
		return response;
	}


	public ResponseEntity<Object> updateInvoice(String invoicesUniqID,Object invoice) {
		logger.info("Entered updateInvoice");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + update, invoicesUniqID).body(Mono.just(invoice), Object.class)
					.retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());

		} catch (WebClientResponseException ex) {
			logger.info("Error in updateInvoice");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updating invoice", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updateInvoice");
		return response;
	}

}
