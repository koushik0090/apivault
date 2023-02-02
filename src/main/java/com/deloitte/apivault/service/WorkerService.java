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
public class WorkerService {
	
	@Value("${workers.host}")
	String host;
	
	@Value("${workers.basic.auth.user}")
	String username;
	
	@Value("${workers.basic.auth.password}")
	String password;
	
	@Value("${workers.ep.create}")
	String create;
	
	@Value("${workers.ep.getall}")
	String getall;

	@Value("${workers.ep.getbyid}")
	String getbyid;
	
	@Value("${workers.ep.update}")
	String update;
	
	public WebClient webClient = null;
	
	private static final Logger logger = LoggerFactory.getLogger(WorkerService.class);

	public WorkerService(WebClient.Builder webClientBuilder) {
		this.webClient =  webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
		
	}

	public ResponseEntity<Object> getWorker() {
		logger.info("Entered getWorker");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
			 response  = this.webClient.get().uri(host + getall).retrieve().toEntity(Object.class).block();
			 logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getWorker");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from getWorker",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getWorker");
		return response;
	}

	public ResponseEntity<Object> getWorkerById(String PersonNumber) {
		logger.info("Entered getWorkerById");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getbyid, PersonNumber).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getWorkerById");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from  getWorkerById",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getWorkerById");
		return response;
	}

	public ResponseEntity<Object> createWorker(Object worker) {
		logger.info("Entered createWorker");
		logger.debug(host + create);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.post().uri(host + create).body(Mono.just(worker), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createWorker");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating createWorker",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createWorker");
		return response;
		
	}

	public ResponseEntity<Object> updateWorker(String PersonNumber,Object worker) {
		logger.info("Entered updateWorker");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + update,PersonNumber).body(Mono.just(worker), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
			
		} catch (WebClientResponseException ex) {
			logger.info("Error in updateWorker");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updating employee",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updateWorker");
		return response;
	}
	
	
	
	

}
