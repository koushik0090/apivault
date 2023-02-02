package com.deloitte.apivault.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.core.publisher.Mono;

@Service
public class InvoiceService {

	@Value("${invoice.payable.host}")
	String host;

	@Value("${invoice.payable.basic.auth.user}")
	String username;

	@Value("${invoice.payable.basic.auth.password}")
	String password;

	@Value("${invoice.payable.ep.create}")
	String create;

	@Value("${invoice.payable.ep.applyprepayments}")
	String applyprepayments;

	@Value("${invoice.payable.ep.calculateTax}")
	String calculateTax;

	@Value("${invoice.payable.ep.validateInvoice}")
	String validateInvoice;

	@Value("${invoice.payable.ep.cancelInvoice}")
	String cancelInvoice;

	@Value("${invoice.payable.ep.cancelLine}")
	String cancelLine;

	@Value("${invoice.payable.ep.getall}")
	String getall;

	@Value("${invoice.payable.ep.getbyid}")
	String getbyid;

	@Value("${invoice.payable.ep.update}")
	String update;

	public WebClient webClient = null;

	private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

	public InvoiceService(WebClient.Builder webClientBuilder) {

		this.webClient = webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader("Content-Type", "application/vnd.oracle.adf.action+json").build();
	}

	public ResponseEntity<Object> getAllInvoices() {
		logger.info("Entered getAllInvoices");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
			response = webClient.get().uri(host + getall).retrieve().toEntity(Object.class).block();
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
			response = webClient.post().uri(host + create).body(Mono.just(invoice), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createInvoice");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating Invoice", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createInvoice");
		return response;
	}

	public ResponseEntity<Object> applyPrepaymentsInvoice(Object invoice) {
		logger.info("Entered applyPrepayments");
		logger.debug(host + applyprepayments);
		ResponseEntity<Object> response = null;
		try {
			response = webClient.post().uri(host + applyprepayments).body(Mono.just(invoice), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in applyPrepayments");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while apply Prepayments for Invoice",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed applyPrepayments");
		return response;
	}

	public ResponseEntity<Object> calculateTaxInvoice(Object invoice) {
		logger.info("Entered calculateTax");
		logger.debug(host + calculateTax);
		ResponseEntity<Object> response = null;
		try {
			response = webClient.post().uri(host + calculateTax).body(Mono.just(invoice), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in calculateTax");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while calculate Tax for Invoice",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed calculateTax");
		return response;
	}

	public ResponseEntity<Object> cancelInvoice(Object invoice) {
		logger.info("Entered cancelInvoice");
		logger.debug(host + cancelInvoice);
		ResponseEntity<Object> response = null;
		try {
			response = webClient.post().uri(host + cancelInvoice).body(Mono.just(invoice), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in cancelInvoice");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while cancel Invoice", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed cancelInvoice");
		return response;
	}

	public ResponseEntity<Object> cancelLineInvoice(Object invoice) {
		logger.info("Entered cancelLine");
		logger.debug(host + cancelLine);
		ResponseEntity<Object> response = null;
		try {
			response = webClient.post().uri(host + cancelLine).body(Mono.just(invoice), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in cancelLine");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while cancel Line in Invoice",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed cancelLine");
		return response;
	}

	public ResponseEntity<Object> getInvoiceById(String invoicesUniqID) {
		logger.info("Entered getInvoiceById");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
			response = webClient.get().uri(host + getbyid, invoicesUniqID).retrieve().toEntity(Object.class).block();
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

	public ResponseEntity<Object> updateInvoice(String invoicesUniqID, Object invoice) {
		logger.info("Entered updateInvoice");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = webClient.patch().uri(host + update, invoicesUniqID).body(Mono.just(invoice), Object.class)
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

	public ResponseEntity<Object> validateInvoice(Object invoice) {
		logger.info("Entered validateInvoice");
		logger.debug(host + validateInvoice);
		ResponseEntity<Object> response = null;
		try {
			response = webClient.post().uri(host + validateInvoice).body(Mono.just(invoice), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in validateInvoice");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while validating the Invoice",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed validateInvoice");
		return response;
	}

}
