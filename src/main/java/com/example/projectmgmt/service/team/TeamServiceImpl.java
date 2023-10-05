package com.example.projectmgmt.service.team;

import com.example.projectmgmt.model.Project;
import com.example.projectmgmt.model.Team;
import com.example.projectmgmt.repository.ProjectRepository;
import com.example.projectmgmt.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final ProjectRepository projectRepository;

    @Override
    public Team createTeam(Team team) {
        return teamRepository.saveAndFlush(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team updateTeam(Team team) {
        Team temp = teamRepository.findByTeamId(team.getTeamId())
                .orElseThrow(() -> new IllegalStateException("Enter the correct TeamID: "+team.getTeamId()));

        Project project = projectRepository.findByProjectId(team.getProject().getProjectId())
                .orElseThrow(() -> new IllegalStateException("Enter the correct ProjectID: "+team.getProject().getProjectId()));

        temp.setProject(project);
        temp.setDescription(team.getDescription());

        return teamRepository.saveAndFlush(temp);
    }

    @Override
    public void deleteTeam(Long teamId) {
        Team team = teamRepository.findByTeamId(teamId)
                .orElseThrow(() -> new IllegalStateException("Enter the correct TeamID: "+teamId));

        teamRepository.deleteById(teamId);
    }
}
