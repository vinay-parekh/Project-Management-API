package com.example.projectmgmt.service.project;

import com.example.projectmgmt.model.Project;
import com.example.projectmgmt.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    @Override
    public Project createProject(Project project) {
        return projectRepository.saveAndFlush(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }


    @Override
    public Project updateProject(Project project) {
        Project temp = projectRepository.findByProjectId(project.getProjectId())
                .orElseThrow(() -> new IllegalStateException("Enter the correct ProjectID: "+project.getProjectId()));

        temp.setTitle(project.getTitle());
        temp.setDomain(project.getDomain());
        temp.setType(project.getType());
        return projectRepository.saveAndFlush(temp);
    }

    @Override
    public void deleteProject(Long projectId) {
        Project temp = projectRepository.findByProjectId(projectId)
                .orElseThrow(() -> new IllegalStateException("Enter the correct ProjectID: "+projectId));

        projectRepository.deleteById(projectId);

    }
}
