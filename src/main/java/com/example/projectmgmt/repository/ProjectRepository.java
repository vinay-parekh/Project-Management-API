package com.example.projectmgmt.repository;

import com.example.projectmgmt.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("select p from Project p where p.projectId = ?1")
    Optional<Project> findByProjectId(Long projectId);
}
