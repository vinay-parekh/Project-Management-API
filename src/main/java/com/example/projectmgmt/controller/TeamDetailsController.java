package com.example.projectmgmt.controller;

import com.example.projectmgmt.model.TeamDetails;
import com.example.projectmgmt.service.teamdetails.TeamDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/project-mgmt/team-details")
public class TeamDetailsController {
    private final TeamDetailsService teamDetailsService;

    @PostMapping
    public String addTeamDetails(@RequestBody TeamDetails teamDetails) {
        teamDetailsService.addTeamDetails(teamDetails);
        return "Team Details added successfully!";
    }

    @GetMapping
    public List<TeamDetails> getTeamDetails() {
        return teamDetailsService.getAllTeamDetails();
    }

    @PutMapping
    public String updateTeamDetails(@RequestBody TeamDetails teamDetails) {
        teamDetailsService.updateTeamDetails(teamDetails);
        return "Team Details updated successfully!";
    }

    @DeleteMapping("{teamName}")
    public String deleteTeamDetails(@RequestParam(value = "teamName") String teamName) {
        teamDetailsService.deleteTeamDetails(teamName);
        return "Team Details deleted successfully!";
    }
}
