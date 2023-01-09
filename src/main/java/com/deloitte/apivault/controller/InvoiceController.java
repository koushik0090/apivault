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

import com.deloitte.apivault.dto.PayloadExample;
import com.deloitte.apivault.service.InvoiceService;
import com.deloitte.apivault.service.ReceivableInvoice;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "ApiVaultapi")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;

	@Autowired
	ReceivableInvoice receivableInvoice;

	// get invoice
	@GetMapping("/invoices")
	public ResponseEntity<Object> getAllInvoices() {
		return invoiceService.getAllInvoices();
	}

	// apply Pre-payments Invoice
	@PostMapping("/invoices/action/applyPrepayments")
	public ResponseEntity<Object> applyPrepaymentsInvoice(
			@Parameter(description = PayloadExample.applyPrepayments) @RequestBody Object invoice) {
		return invoiceService.applyPrepaymentsInvoice(invoice);
	}

	// calculate Tax Invoice
	@PostMapping("/invoices/action/calculateTax")
	public ResponseEntity<Object> calculateTaxInvoice(
			@Parameter(description = PayloadExample.calculateTax) @RequestBody Object invoice) {
		return invoiceService.calculateTaxInvoice(invoice);
	}

	// cancel Invoice
	@PostMapping("/invoices/action/cancelInvoice")
	public ResponseEntity<Object> cancelInvoice(
			@Parameter(description = PayloadExample.cancelInvoice) @RequestBody Object invoice) {
		return invoiceService.cancelInvoice(invoice);
	}

	// cancel line Invoice
	@PostMapping("/invoices/action/cancelLine")
	public ResponseEntity<Object> cancelLineInvoice(
			@Parameter(description = PayloadExample.cancelLineInvoice) @RequestBody Object invoice) {
		return invoiceService.cancelLineInvoice(invoice);
	}

	// create invoice
	@PostMapping("/invoices")
	public ResponseEntity<Object> createInvoice(
			@Parameter(description = PayloadExample.createInvoice) @RequestBody Object invoice) {
		return invoiceService.createInvoice(invoice);
	}

	// get invoice by invoice Id
	@GetMapping("/invoices/{invoicesUniqID}")
	public ResponseEntity<Object> getInvoiceById(
			@Parameter(description = "300000011998916") @PathVariable("invoicesUniqID") String invoicesUniqID) {
		return invoiceService.getInvoiceById(invoicesUniqID);
	}

	// Update invoice
	@PatchMapping("/invoices/{invoicesUniqID}")
	public ResponseEntity<Object> updateInvoice(
			@Parameter(description = PayloadExample.updateInvoice) @RequestBody Object invoice,
			@Parameter(description = "300000011998916") @PathVariable("invoicesUniqID") String invoicesUniqID) {
		return invoiceService.updateInvoice(invoicesUniqID, invoice);
	}

	// get invoice
	@GetMapping("/receivableInvoice")
	public ResponseEntity<Object> getAllReceivableInvoices() {
		return receivableInvoice.getAllInvoices();
	}

	// create invoice
	@PostMapping("/receivableInvoice")
	public ResponseEntity<Object> createReceivableInvoice(
			@Parameter(description = PayloadExample.createReceivableInvoice) @RequestBody Object invoice) {
		return receivableInvoice.createInvoice(invoice);
	}

	// get invoice by invoice Id
	@GetMapping("/receivableInvoice/{invoicesUniqID}")
	public ResponseEntity<Object> getReceivableInvoiceById(
			@Parameter(description = "225206") @PathVariable("invoicesUniqID") String invoicesUniqID) {
		return receivableInvoice.getInvoiceById(invoicesUniqID);
	}

	// Update invoice
	@PatchMapping("/receivableInvoice/{invoicesUniqID}")
	public ResponseEntity<Object> updateReceivableInvoice(
			@Parameter(description = PayloadExample.updateInvoice) @RequestBody Object invoice,
			@Parameter(description = "225088") @PathVariable("invoicesUniqID") String invoicesUniqID) {
		return receivableInvoice.updateInvoice(invoicesUniqID, invoice);
	}

	// get invoice by invoice Id
	@DeleteMapping("/receivableInvoice/{invoicesUniqID}")
	public ResponseEntity<Object> deleteReceivableInvoiceById(
			@Parameter(description = "225086") @PathVariable("invoicesUniqID") String invoicesUniqID) {
		return receivableInvoice.deleteInvoiceById(invoicesUniqID);
	}

}
