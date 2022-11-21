package com.deloitte.apivault.service;

import java.io.IOException;

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
public class ProjectService {

	@Value("${project.host}")
	String host;

	@Value("${project.basic.auth.user}")
	String username;

	@Value("${project.basic.auth.password}")
	String password;

	@Value("${project.ep.create}")
	String create;

	@Value("${project.ep.createbyid}")
	String createbyid;

	@Value("${project.ep.getall}")
	String getall;

	@Value("${project.ep.getbyid}")
	String getbyid;

	@Value("${project.ep.update}")
	String update;

	public WebClient webClient = null;

	private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);

	public ProjectService(WebClient.Builder webClientBuilder) throws IOException {
		this.webClient = webClientBuilder
				.filter(ExchangeFilterFunctions.basicAuthentication("MuleSoft.API", "Welcome@1"))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	// Create Project details
	public ResponseEntity<Object> createProject(Object worker) {
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
			return new ResponseEntity<Object>("Error occured while creating worker", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createWorker");
		return response;
	}

	// Create Project details by ProjectId
	public ResponseEntity<Object> createProjectById(String empsUniqID, Object worker) {
		logger.info("Entered createWorkerById");
		logger.debug(host + createbyid, empsUniqID);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.post().uri(host + create).body(Mono.just(worker), Object.class).retrieve()
					.toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in createWorkerById");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while creating worker by empsUniqID",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed createWorkerById");
		return response;
	}

	// Get project details
	public ResponseEntity<Object> getAllProjects() {
		logger.info("Entered getAllProjects");
		logger.debug(host + getall);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getall).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getAllProjects");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from projects",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getAllProjects");
		return response;
	}

	// Get project details by ProjectId
	public ResponseEntity<Object> getProjectById(String empsUniqID) {
		logger.info("Entered getProjectById");
		logger.debug(host + getbyid);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.get().uri(host + getbyid, empsUniqID).retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());
		} catch (WebClientResponseException ex) {
			logger.info("Error in getProjectById");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while fetching from project by empsUniqID",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed getProjectById");
		return response;
	}

	// Update project
	public ResponseEntity<Object> updateProject(String empsUniqID, Object project) {

		logger.info("Entered updateProject");
		logger.debug(host + update);
		ResponseEntity<Object> response = null;
		try {
			response = this.webClient.patch().uri(host + update, empsUniqID).body(Mono.just(project), Object.class)
					.retrieve().toEntity(Object.class).block();
			logger.debug(response.getBody().toString());

		} catch (WebClientResponseException ex) {
			logger.info("Error in updateProject");
			return new ResponseEntity<Object>(ex.getResponseBodyAsString(), ex.getStatusCode());
		} catch (Exception ex) {
			return new ResponseEntity<Object>("Error occured while updating project", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("completed updateProject");
		return response;
	}

}
