package com.deloitte.apivault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.apivault.service.EmployeeService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "ApiVaultapi")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/emps")
	public ResponseEntity<Object> getEmp()
	{
		return employeeService.getEmp();
	}
	
	@GetMapping("/emps/{empsUniqID}")
	public ResponseEntity<Object> getEmpById(@Parameter(description = "e.g : 123") @PathVariable("empsUniqID") String empsUniqID)
	{
		return employeeService.getEmpById(empsUniqID);
	}
	
	@PostMapping("/emps")
	public ResponseEntity<Object> createEmp(Object employee){
	
		return employeeService.createEmp(employee);
	}

	@PatchMapping("/emps/{empsUniqID}")
	public ResponseEntity<Object> updateEmp(
			@Parameter(description = "e.g : 123") @PathVariable("empsUniqID") String empsUniqID,
			Object employee){
	     return employeeService.updateEmp(empsUniqID,employee);  
	}
	
	
}
