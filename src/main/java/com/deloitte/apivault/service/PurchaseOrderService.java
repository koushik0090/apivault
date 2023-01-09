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
public class PurchaseOrderService {

	@Value("${purchaseOrders.host}")
	String host;

	@Value("${purchaseOrders.basic.auth.user}")
	String username;

	@Value("${purchaseOrders.basic.auth.password}")
	String password;

	@Value("${purchaseOrders.ep.cancel}")
	String cancel;

	@Value("${purchaseOrders.ep.close}")
	String close;

	@Value("${purchaseOrders.ep.recommunicate}")
	String recommunicate;

	@Value("${purchaseOrders.ep.renumber}")
	String renumber;

	@Value("${purchaseOrders.ep.resubmit}")
	String resubmit;

	@Value("${purchaseOrders.ep.getall}")
	String getall;

	@Value("${purchaseOrders.ep.getbyid}")
	String getbyid;

	public WebClient webClient = null;
	
	private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

	public  PurchaseOrderService(WebClient.Builder webClientBuilder) {
		
		this.webClient = webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	public ResponseEntity<Object> cancelPurchaseOrder(String purchaseOrdersUniqID, Object purchaseOrder) {
		logger.info("Entered cancelPurchaseOrder");
		logger.debug(host + cancel);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + cancel,purchaseOrdersUniqID).body(Mono.just(purchaseOrder), Object.class)
					.retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());

		} catch (WebClientResponseException ex) {
			logger.info("Error in cancelPurchaseOrder");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while cancel purchase order", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed cancelPurchaseOrder");
		return response;
	}
	
	public ResponseEntity<Object> closePurchaseOrder(String purchaseOrdersUniqID, Object purchaseOrder) {
		logger.info("Entered closePurchaseOrder");
		logger.debug(host + close);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + close,purchaseOrdersUniqID).body(Mono.just(purchaseOrder), Object.class)
					.retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());

		} catch (WebClientResponseException ex) {
			logger.info("Error in closePurchaseOrder");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while close purchase order", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed closePurchaseOrder");
		return response;
	}

	
	public ResponseEntity<Object> recommunicatePurchaseOrder(String purchaseOrdersUniqID, Object purchaseOrder) {
		logger.info("Entered recommunicatePurchaseOrder");
		logger.debug(host + close);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + close,purchaseOrdersUniqID).body(Mono.just(purchaseOrder), Object.class)
					.retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());

		} catch (WebClientResponseException ex) {
			logger.info("Error in recommunicatePurchaseOrder");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while re-communicate purchase order", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed recommunicatePurchaseOrder");
		return response;
	}
	
	public ResponseEntity<Object> renumberPurchaseOrder(String purchaseOrdersUniqID, Object purchaseOrder) {
		logger.info("Entered renumberPurchaseOrder");
		logger.debug(host + renumber);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + renumber,purchaseOrdersUniqID).body(Mono.just(purchaseOrder), Object.class)
					.retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());

		} catch (WebClientResponseException ex) {
			logger.info("Error in renumberPurchaseOrder");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while re-number purchase order", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed renumberPurchaseOrder");
		return response;
	}
	
	
	public ResponseEntity<Object> resubmitPurchaseOrder(String purchaseOrdersUniqID, Object purchaseOrder) {
		logger.info("Entered resubmitPurchaseOrder");
		logger.debug(host + resubmit);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + resubmit,purchaseOrdersUniqID).body(Mono.just(purchaseOrder), Object.class)
					.retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());

		} catch (WebClientResponseException ex) {
			logger.info("Error in resubmitPurchaseOrder");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while resubmit purchase order", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed resubmitPurchaseOrder");
		return response;
	}
	
	public ResponseEntity<Object> getAllPurchaseOrder() {
		logger.info("Entered getAllPurchaseOrder");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getall).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getAllPurchaseOrder");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from purchase order",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getAllPurchaseOrder");
		return response;
	}
	
	public ResponseEntity<Object> getPurchaseOrderById(String POHeaderId) {
		logger.info("Entered getPurchaseOrderById");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getbyid, POHeaderId).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getInvoiceById");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from purchase order by POHeaderId",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getPurchaseOrderById");
		return response;
	}

}
