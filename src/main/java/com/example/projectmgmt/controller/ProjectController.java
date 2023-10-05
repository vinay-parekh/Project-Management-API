package com.example.projectmgmt.controller;

import com.example.projectmgmt.model.Project;
import com.example.projectmgmt.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project-mgmt/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public String createProject(@RequestBody Project project) {
        projectService.createProject(project);
        return "Project created successfully!";
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectService.getAllProjects();
    }

    @PutMapping
    public String updateProject(@RequestBody Project project) {
        projectService.updateProject(project);
        return "Project updated successfully!";
    }

    @DeleteMapping("{projectId}")
    public String deleteProject(@PathVariable("projectId") Long projectId) {
        projectService.deleteProject(projectId);
        return "Project deleted successfully!";
    }
}
