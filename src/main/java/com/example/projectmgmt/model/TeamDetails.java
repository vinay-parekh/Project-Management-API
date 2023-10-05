package com.example.projectmgmt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "team_details")
public class TeamDetails {


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    @ToString.Exclude
    private Team team;

    @Id
    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "member1", nullable = false, updatable = true)
    private String member1;

    @Column(name = "member2", nullable = false, updatable = true)
    private String member2;

    @Column(name = "member3", nullable = false, updatable = true)
    private String member3;
}
