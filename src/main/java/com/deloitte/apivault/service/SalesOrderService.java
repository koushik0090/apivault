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
public class SalesOrderService {

	@Value("${salesOrders.host}")
	String host;

	@Value("${salesOrders.basic.auth.user}")
	String username;

	@Value("${salesOrders.basic.auth.password}")
	String password;

	@Value("${salesOrders.ep.create}")
	String create;

	@Value("${salesOrders.ep.getall}")
	String getall;

	@Value("${salesOrders.ep.getbyid}")
	String getbyid;

	@Value("${salesOrders.ep.update}")
	String update;
	
	@Value("${salesOrders.ep.delete}")
	String delete;

	public WebClient webClient = null;

	private static final Logger logger = LoggerFactory.getLogger(SalesOrderService.class);

	public SalesOrderService(WebClient.Builder webClientBuilder) {

		this.webClient = webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	// Get all supplier
	public ResponseEntity<Object> getAllSalesOrder() {

		logger.info("Entered getAllSalesOrder");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
			 response  = this.webClient.get().uri(host + getall).retrieve().toEntity(Object.class).block();
			 logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getAllSalesOrder");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from sale Order",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getAllSalesOrder");
		return response;
	}

	// Get sale order by OrderKey
	public ResponseEntity<Object> getSaleOrderByOrderKey(String OrderKey) {

		logger.info("Entered getSaleOrderByOrderKey");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getbyid, OrderKey).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getSaleOrderByOrderKey");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from sales Order by OrderKey",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getSaleOrderByOrderKey");
		return response;
	}

	// Create sale Order
	public ResponseEntity<Object> createSalesOrder(Object saleOrder) {
		
		logger.info("Entered createSalesOrder");
		logger.debug(host + create);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.post().uri(host + create).body(Mono.just(saleOrder), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createSalesOrder");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating sales Order",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createSalesOrder");
		return response;
	}

	// Update supplier
	public ResponseEntity<Object> updateSaleOrder(Object order, String OrderKey) {
		
		logger.info("Entered updateSaleOrder");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + update,OrderKey).body(Mono.just(order), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
			
		} catch (WebClientResponseException ex) {
			logger.info("Error in updateSaleOrder");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updating sale Order",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updateSaleOrder");
		return response;
	}
	
	// delete sale order by OrderKey
		public ResponseEntity<Object> deleteSaleOrder( String OrderKey) {
			
			logger.info("Entered deleteSaleOrder");
			logger.debug(host + delete);
			ResponseEntity<Object> response = null;
			try {
				response = this.webClient.delete().uri(host + delete,OrderKey).retrieve()
						.toEntity(Object.class).block();
				logger.debug(response.getBody().toString());
				
			} catch (WebClientResponseException ex) {
				logger.info("Error in deleteSaleOrder");
				return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
			} catch (Exception ex) {
				return new ResponseEntity<Object>("Error occured while deleting sale order",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			logger.info("completed deleteSaleOrder");
			return response;
		}
}
