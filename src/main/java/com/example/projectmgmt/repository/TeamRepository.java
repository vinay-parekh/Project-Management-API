package com.example.projectmgmt.repository;

import com.example.projectmgmt.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("select t from Team t where t.teamId = ?1")
    Optional<Team> findByTeamId(Long id);
}
