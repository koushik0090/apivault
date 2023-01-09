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

import com.deloitte.apivault.service.CustAddressPurposeService;
import com.deloitte.apivault.service.CustomerAccountService;
import com.deloitte.apivault.service.CustomerAddressService;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class CustomerController {

	@Autowired
	CustomerAccountService customerAccountService;

	@Autowired
	CustomerAddressService customerAddressService;

	@Autowired
	CustAddressPurposeService custAddressPurposeService;

	@GetMapping("/accounts")
	public ResponseEntity<Object> getCustAccount() {
		return customerAccountService.getCustAccount();
	}

	@GetMapping("/accounts/{PartyNumber}")
	public ResponseEntity<Object> getCustAccountByPartyNumber(
			@Parameter(description = "e.g: 5003") @PathVariable("PartyNumber") String PartyNumber) {
		return customerAccountService.getCustAccountByPartyNumber(PartyNumber);
	}

	@PostMapping("/accounts")
	public ResponseEntity<Object> createCustAccount(@RequestBody Object customerAccount) {
		return customerAccountService.createCustAccount(customerAccount);
	}

	@PatchMapping("/accounts/{PartyNumber}")
	public ResponseEntity<Object> updateCustAccountByPartyNumber(
			@Parameter(description = "e.g: 5003") @PathVariable("PartyNumber") String PartyNumber,
			@RequestBody Object customerAccount) {
		return customerAccountService.updateCustAccountByPartyNumber(PartyNumber, customerAccount);
	}

	@DeleteMapping("/accounts/{PartyNumber}")
	public ResponseEntity<Object> deleteCustAccountByPartyNumber(
			@Parameter(description = "e.g: 59786") @PathVariable("PartyNumber") String PartyNumber) {
		return customerAccountService.deleteCustAccountByPartyNumber(PartyNumber);
	}

	@GetMapping("/accounts/{PartyNumber}/child/Address")
	public ResponseEntity<Object> getCustAddress(
			@Parameter(description = "e.g: 5003") @PathVariable("PartyNumber") String PartyNumber) {
		return customerAddressService.getCustAddress(PartyNumber);
	}

	@GetMapping("/accounts/{PartyNumber}/child/Address/{AddressNumber}")
	public ResponseEntity<Object> getCustAddressByPartyNumber(
			@Parameter(description = "e.g: 5003") @PathVariable("PartyNumber") String PartyNumber,
			@Parameter(description = "e.g: 3033") @PathVariable("AddressNumber") String AddressNumber) {
		return customerAddressService.getCustAddressByPartyNumber(PartyNumber, AddressNumber);
	}

	@PostMapping("/accounts/{PartyNumber}/child/Address")
	public ResponseEntity<Object> createCustAddress(
			@Parameter(description = "e.g: 5003") @PathVariable("PartyNumber") String PartyNumber,
			@RequestBody Object customerAccount) {
		return customerAddressService.createCustAddress(PartyNumber, customerAccount);
	}

	@PatchMapping("/accounts/{PartyNumber}/child/Address/{AddressNumber}")
	public ResponseEntity<Object> updateCustAddressByPartyNumber(
			@Parameter(description = "e.g: 5003") @PathVariable("PartyNumber") String PartyNumber,
			@Parameter(description = "e.g: 3033") @PathVariable("AddressNumber") String AddressNumber,
			@RequestBody Object customerAccount) {
		return customerAddressService.updateCustAddressByPartyNumber(PartyNumber, AddressNumber, customerAccount);
	}

	@DeleteMapping("/accounts/{PartyNumber}/child/Address/{AddressNumber}")
	public ResponseEntity<Object> deleteCustAddressByPartyNumber(
			@Parameter(description = "e.g: 5003") @PathVariable("PartyNumber") String PartyNumber,
			@Parameter(description = "e.g: 123") @PathVariable("AddressNumber") String AddressNumber) {
		return customerAddressService.deleteCustAddressByPartyNumber(PartyNumber, AddressNumber);
	}

	@GetMapping("/accounts/{PartyNumber}/child/Address/{AddressNumber}/child/AddressPurpose")
	public ResponseEntity<Object> getCustAddressPurpose(
			@Parameter(description = "e.g: 123") @PathVariable("PartyNumber") String PartyNumber,
			@Parameter(description = "e.g: 123") @PathVariable("AddressNumber") String AddressNumber) {
		return custAddressPurposeService.getCustAddressPurpose(PartyNumber, AddressNumber);
	}

	@GetMapping("/accounts/{PartyNumber}/child/Address/{AddressNumber}/child/AddressPurpose/{AddressPurposeId}")
	public ResponseEntity<Object> getCustAddressPurposeByPartyNumber(
			@Parameter(description = "e.g: 123") @PathVariable("PartyNumber") String PartyNumber,
			@Parameter(description = "e.g: 123") @PathVariable("AddressNumber") String AddressNumber,
			@Parameter(description = "e.g: 123") @PathVariable("AddressPurposeId") String AddressPurposeId) {
		return custAddressPurposeService.getCustAddressPurposeByPartyNumber(PartyNumber, AddressNumber,
				AddressPurposeId);
	}

	@PostMapping("/accounts/{PartyNumber}/child/Address/{AddressNumber}/child/AddressPurpose")
	public ResponseEntity<Object> createCustAddressPurpose(
			@Parameter(description = "e.g: 123") @PathVariable("PartyNumber") String PartyNumber,
			@Parameter(description = "e.g: 123") @PathVariable("PartyNumber") String AddressNumber,
			@RequestBody Object customerAccount) {
		return custAddressPurposeService.createCustAddressPurpose(PartyNumber, AddressNumber, customerAccount);
	}

	@PatchMapping("/accounts/{PartyNumber}/child/Address/{AddressNumber}/child/AddressPurpose/{AddressPurposeId}")
	public ResponseEntity<Object> updateCustAddressPurposeByPartyNumber(
			@Parameter(description = "e.g: 123") @PathVariable("PartyNumber") String PartyNumber,
			@Parameter(description = "e.g: 123") @PathVariable("AddressNumber") String AddressNumber,
			@Parameter(description = "e.g: 123") @PathVariable("AddressPurposeId") String AddressPurposeId,
			@RequestBody Object customerAccount) {
		return custAddressPurposeService.updateCustAddressPurposeByPartyNumber(PartyNumber, AddressNumber,
				AddressPurposeId, customerAccount);
	}

	@DeleteMapping("/accounts/{PartyNumber}/child/Address/{AddressNumber}/child/AddressPurpose/{AddressPurposeId}")
	public ResponseEntity<Object> deleteCustAddressPurposeByPartyNumber(
			@Parameter(description = "e.g: 123") @PathVariable("PartyNumber") String PartyNumber,
			@Parameter(description = "e.g: 123") @PathVariable("AddressNumber") String AddressNumber,
			@Parameter(description = "e.g: 123") @PathVariable("AddressPurposeId") String AddressPurposeId) {
		return custAddressPurposeService.deleteCustAddressPurposeByPartyNumber(PartyNumber, AddressNumber,
				AddressPurposeId);
	}

}
