package com.example.projectmgmt.service.project;

import com.example.projectmgmt.model.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    List<Project> getAllProjects();
    Project updateProject(Project project);
    void deleteProject(Long projectId);

}
