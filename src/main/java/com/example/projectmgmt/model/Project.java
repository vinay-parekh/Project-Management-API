package com.example.projectmgmt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "project_id", nullable = false, updatable = false)
    private Long projectId;

    @Column(name = "title", nullable = false, updatable = true)
    private String title;

    @Column(name = "domain", nullable = false, updatable = true)
    private String domain;

    @Column(name = "type", nullable = false, updatable = true)
    private String type;
}
