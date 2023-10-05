package com.example.projectmgmt.service.teamdetails;

import com.example.projectmgmt.model.Team;
import com.example.projectmgmt.model.TeamDetails;
import com.example.projectmgmt.repository.TeamDetailsRepository;
import com.example.projectmgmt.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamDetailsServiceImpl implements TeamDetailsService {
    private final TeamDetailsRepository teamDetailsRepository;
    private final TeamRepository teamRepository;

    @Override
    public TeamDetails addTeamDetails(TeamDetails teamDetails) {
        return teamDetailsRepository.saveAndFlush(teamDetails);
    }

    @Override
    public List<TeamDetails> getAllTeamDetails() {
        return teamDetailsRepository.findAll();
    }

    @Override
    public TeamDetails updateTeamDetails(TeamDetails teamDetails) {
        TeamDetails temp = teamDetailsRepository.findByTeamName(teamDetails.getTeamName())
                .orElseThrow(() -> new RuntimeException("Enter the correct Team Name: "+teamDetails.getTeamName()));

        Team team = teamRepository.findByTeamId(teamDetails.getTeam().getTeamId())
                .orElseThrow(() -> new RuntimeException("Enter the correct TeamID: "+teamDetails.getTeam().getTeamId()));

        temp.setTeam(team);
        temp.setMember1(teamDetails.getMember1());
        temp.setMember2(teamDetails.getMember2());
        temp.setMember3(teamDetails.getMember3());

        return teamDetailsRepository.saveAndFlush(temp);
    }

    @Override
    public void deleteTeamDetails(String teamName) {
        TeamDetails teamDetails = teamDetailsRepository.findByTeamName(teamName)
                .orElseThrow(() -> new RuntimeException("Enter the correct Team Name: "+teamName));
        teamDetailsRepository.delete(teamDetails);
    }
}
