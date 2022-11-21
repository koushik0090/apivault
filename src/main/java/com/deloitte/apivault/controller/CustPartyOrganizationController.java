package com.deloitte.apivault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.apivault.service.CustPartyOrganizationService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "ApiVaultapi")
public class CustPartyOrganizationController {
	
	@Autowired
	CustPartyOrganizationService custPartyOrganizationService; 

	//Get Organization
	@GetMapping("/hubOrganizations")
	public ResponseEntity<Object> getOrganization()
	{
		return custPartyOrganizationService.getOrganization();
		
	}
	
	//POST Organizations
	@PostMapping("/hubOrganizations")
	public ResponseEntity<Object> createOrganization(
			@Parameter(description  =  "e.g:\r\n\n"
	        +"{\r\n"
			+ "  \"OrganizationName\": \"Lookahead SG Corp.\",\r\n"
			+ "  \"PartyUsageCode\": \"SUPPLIER\",\r\n"
			+ "  \"AddressNumber\": \"surya0090\",\r\n"
			+ "  \"Address1\": \"SG-15\",\r\n"
			+ "  \"Address2\": \"Singapore Post Centre\",\r\n"
			+ "  \"Country\": \"SG\",\r\n"
			+ "  \"PostalCode\": \"408600\",\r\n"
			+ "  \"CorpCurrencyCode\": \"USD\",\r\n"
			+ "  \"CurcyConvRateType\": \"Corporate\",\r\n"
			+ "  \"CurrencyCode\": \"USD\",\r\n"
			+ "  \"UniqueNameAlias\": \"Lookahead SG Corp.\"\r\n"
			+ "}",required = true)
	   	@RequestBody Object organization){
		return custPartyOrganizationService.createOrganization(organization);
	}
	
	//GET PartyNumber
		@GetMapping("/hubOrganizations/{PartyNumber}")
		public ResponseEntity<Object> getPartyNumber(
				@Parameter(description = "e.g: 713100")
				@PathVariable("PartyNumber") String partyNumber)
		{
			return custPartyOrganizationService.getPartyNumber(partyNumber);
		}
		
	//PATCH Party Number
		@PatchMapping("/hubOrganizations/{PartyNumber}")
		public ResponseEntity<Object> updatePartyNumber(
				@Parameter(description = "e.g:\r\n\n"
		        +"{\r\n"
				+ "  \"OrganizationName\": \"Lookahead SG Corp.\",\r\n"
				+ "  \"PartyUsageCode\": \"SUPPLIER\",\r\n"
				+ "  \"AddressNumber\": \"10143Raghav\",\r\n"
				+ "  \"Address1\": \"SG-16\",\r\n"
				+ "  \"Address2\": \"Singapore Post Centre\",\r\n"
				+ "  \"Country\": \"SG\",\r\n"
				+ "  \"PostalCode\": \"408600\",\r\n"
				+ "  \"CorpCurrencyCode\": \"USD\",\r\n"
				+ "  \"CurcyConvRateType\": \"Corporate\",\r\n"
				+ "  \"CurrencyCode\": \"USD\",\r\n"
				+ "  \"UniqueNameAlias\": \"Lookahead SG Corp.\"\r\n"
				+ "}")
				@RequestBody  Object organization,
				@Parameter(description = "e.g: 713100")
				@PathVariable("PartyNumber") String partyNumber)
		{
			return custPartyOrganizationService.updatePartyNumber(organization,partyNumber);
		}
		
	//DELETE Party Number
		@DeleteMapping("/hubOrganizations/{PartyNumber}")
		public ResponseEntity<Object> deletePartyNumber(
				@Parameter(description = "e.g: 1081,1080,3002")
				@PathVariable("PartyNumber") String partyNumber)
		{
			return custPartyOrganizationService.deletePartyNumber(partyNumber);
		}
	
}
