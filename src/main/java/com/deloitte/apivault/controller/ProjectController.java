package com.deloitte.apivault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.apivault.dto.PayloadExample;
import com.deloitte.apivault.service.ProjectService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "ApiVaultapi")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	// Create Project details
	@PostMapping("/project")
	public ResponseEntity<Object> createProject(@Parameter(description = PayloadExample.createProject) @RequestBody Object projects) {
		return projectService.createProject(projects);
	}

	// Create Project details by ProjectId
	@PostMapping("/projects/{ProjectId}")
	public ResponseEntity<Object> createProjectById(
			@Parameter(description = PayloadExample.createProjectAddTask) @RequestBody Object projects,
			@Parameter(description = "e.g : ProjectId = 213243543") @PathVariable("ProjectId") String ProjectId) {
		return projectService.createProjectById(ProjectId, projects);
	}

	// Get project details
	@GetMapping("/projects")
	public ResponseEntity<Object> getAllProjects() {
		return projectService.getAllProjects();
	}

	// Get worker project by ProjectId
	@GetMapping("/projects/{ProjectId}")
	public ResponseEntity<Object> getProjectById(
			@Parameter(description = PayloadExample.getProjectId) @PathVariable("ProjectId") String empsUniqID) {
		return projectService.getProjectById(empsUniqID);
	}

	// Update project
	@PatchMapping("/projects/{ProjectId}")
	public ResponseEntity<Object> updateProject(
			@Parameter(description = PayloadExample.updateProject) @RequestBody Object project,
			@Parameter(description = "300000008308413") @PathVariable("ProjectId") String PersonId) {
		return projectService.updateProject(PersonId, project);
	}

}
