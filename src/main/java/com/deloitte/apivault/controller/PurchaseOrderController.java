package com.deloitte.apivault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.deloitte.apivault.dto.PayloadExample;
import com.deloitte.apivault.service.PurchaseOrderService;

import io.swagger.v3.oas.annotations.Parameter;

public class PurchaseOrderController {
	
	@Autowired
	PurchaseOrderService purchaseOrderService;
	
	@PostMapping("/purchaseOrders/{purchaseOrdersUniqID}/action/cancel")
	public ResponseEntity<Object> cancelPurchaseOrder(
			@Parameter(description = "") @PathVariable("purchaseOrdersUniqID") String purchaseOrdersUniqID,
			@Parameter(description = PayloadExample.cancelPurchaseOrder) @RequestBody Object purshaseOrder){
	
		return purchaseOrderService.cancelPurchaseOrder(purchaseOrdersUniqID, purshaseOrder);
	}
	
	@PostMapping("/purchaseOrders/{purchaseOrdersUniqID}/action/close")
	public ResponseEntity<Object> closePurchaseOrder(
			@Parameter(description = "") @PathVariable("purchaseOrdersUniqID") String purchaseOrdersUniqID, 
			@Parameter(description = PayloadExample.closePurchaseOrder) @RequestBody Object purshaseOrder){
	
		return purchaseOrderService.closePurchaseOrder(purchaseOrdersUniqID, purshaseOrder);
	}
	
	@PostMapping("/purchaseOrders/{purchaseOrdersUniqID}/action/communicate")
	public ResponseEntity<Object> recommunicatePurchaseOrder(
			@Parameter(description = "") @PathVariable("purchaseOrdersUniqID") String purchaseOrdersUniqID,
			@Parameter(description = PayloadExample.recommunicatePurchaseOrder) @RequestBody Object purshaseOrder){
	
		return purchaseOrderService.recommunicatePurchaseOrder(purchaseOrdersUniqID, purshaseOrder);
	}
	
	@PostMapping("/purchaseOrders/{purchaseOrdersUniqID}/action/communicate")
	public ResponseEntity<Object> renumberPurchaseOrder(
			@Parameter(description = "") @PathVariable("purchaseOrdersUniqID") String purchaseOrdersUniqID,
			@Parameter(description = PayloadExample.renumberPurchaseOrder) @RequestBody Object purshaseOrder){
	
		return purchaseOrderService.renumberPurchaseOrder(purchaseOrdersUniqID, purshaseOrder);
	}
	
	@PostMapping("/purchaseOrders/{purchaseOrdersUniqID}/action/communicate")
	public ResponseEntity<Object> resubmitPurchaseOrder(
			@Parameter(description = "100000019476400") @PathVariable("purchaseOrdersUniqID") String purchaseOrdersUniqID,
			@Parameter(description = PayloadExample.resubmitPurchaseOrder) @RequestBody Object purshaseOrder){
	
		return purchaseOrderService.resubmitPurchaseOrder(purchaseOrdersUniqID, purshaseOrder);
	}
	
	@GetMapping("/purchaseOrders")
	public ResponseEntity<Object> getAllPurchaseOrder()
	{
		return purchaseOrderService.getAllPurchaseOrder();
	}
	
	@GetMapping("/purchaseOrders/{POHeaderId}")
	public ResponseEntity<Object> getPurchaseOrderById(@Parameter(description = "e.g : 123") @PathVariable("POHeaderId") String POHeaderId)
	{
		return purchaseOrderService.getPurchaseOrderById(POHeaderId);
	}

}
