package com.deloitte.apivault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.apivault.dto.PayloadExample;
import com.deloitte.apivault.service.WorkerService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "ApiVaultapi")
public class WorkerController {

	@Autowired
	WorkerService workerService;

	@GetMapping("/workers")
	public ResponseEntity<Object> getWorker() {
		return workerService.getWorker();
	}

	@GetMapping("/workers/{PersonNumber}")
	public ResponseEntity<Object> getWorkerById(
			@Parameter(description = "e.g : 300000003102354") @PathVariable("PersonNumber") String PersonNumber) {
		return workerService.getWorkerById(PersonNumber);
	}

	@PostMapping("/workers")
	public ResponseEntity<Object> createWorker(@Parameter(description = PayloadExample.createWorker) @RequestBody Object worker) {

		return workerService.createWorker(worker);
	}

	@PatchMapping("/workers/{PersonNumber}")
	public ResponseEntity<Object> updateWorker(
			@Parameter(description = "e.g : 00020000000EACED00057708000110D9319E16920000004AACED00057372000D6A6176612E73716C2E4461746514FA46683F3566970200007872000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001831018BC0078") @PathVariable("PersonNumber") String PersonNumber, @Parameter(description = PayloadExample.updateWorker) @RequestBody Object worker) {
		return workerService.updateWorker(PersonNumber, worker);
	}

}
