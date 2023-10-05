package com.example.projectmgmt.controller;

import com.example.projectmgmt.model.Team;
import com.example.projectmgmt.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project-mgmt/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public String createTeam(@RequestBody Team team) {
        teamService.createTeam(team);
        return "Team created successfully!";
    }

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getAllTeams();
    }

    @PutMapping
    public String updateTeam(@RequestBody Team team) {
        teamService.updateTeam(team);
        return "Team updated successfully!";
    }

    @DeleteMapping("{teamId}")
    public String deleteTeam(@RequestParam(value = "teamId") Long teamId) {
        teamService.deleteTeam(teamId);
        return "Team deleted successfully!";
    }
}
