package com.example.projectmgmt.service.teamdetails;

import com.example.projectmgmt.model.TeamDetails;

import java.util.List;

public interface TeamDetailsService {
    TeamDetails addTeamDetails(TeamDetails teamDetails);
    List<TeamDetails> getAllTeamDetails();
    TeamDetails updateTeamDetails(TeamDetails teamDetails);
    void deleteTeamDetails(String teamName);
}
