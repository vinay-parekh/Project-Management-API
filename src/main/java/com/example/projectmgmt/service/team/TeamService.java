package com.example.projectmgmt.service.team;

import com.example.projectmgmt.model.Team;

import java.util.List;

public interface TeamService {
    Team createTeam(Team team);
    List<Team> getAllTeams();
    Team updateTeam(Team team);
    void deleteTeam(Long teamId);
}
