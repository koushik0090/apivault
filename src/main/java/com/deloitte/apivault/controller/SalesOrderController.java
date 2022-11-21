package com.deloitte.apivault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.apivault.service.SalesOrderService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "ApiVaultapi")
public class SalesOrderController {

	@Autowired
	SalesOrderService SalesOrderService;
	
	@GetMapping("/salesOrdersForOrderHub")
	public ResponseEntity<Object> getAllSalesOrder()
	{
		return SalesOrderService.getAllSalesOrder();
	}
	
	@GetMapping("/salesOrdersForOrderHub/{OrderKey}")
	public ResponseEntity<Object> getSaleOrderByOrderKey(@Parameter(description = "e.g : 123") @PathVariable("OrderKey") String OrderKey)
	{
		return SalesOrderService.getSaleOrderByOrderKey(OrderKey);
	}
	
	@PostMapping("/salesOrdersForOrderHub")
	public ResponseEntity<Object> createSalesOrder(Object order){
	
		return SalesOrderService.createSalesOrder(order);
	}

	@PatchMapping("/salesOrdersForOrderHub/{OrderKey}")
	public ResponseEntity<Object> updateSaleOrder(
			@Parameter(description = "e.g : 123") @PathVariable("OrderKey") String OrderKey,
			Object order){
	     return SalesOrderService.updateSaleOrder(order,OrderKey);  
	}

	@DeleteMapping("/salesOrdersForOrderHub/{OrderKey}")
	public ResponseEntity<Object> deleteSaleOrder(@Parameter(description = "e.g : 123") @PathVariable("OrderKey") String OrderKey)
	{
		return SalesOrderService.deleteSaleOrder(OrderKey);
	}
	

}
