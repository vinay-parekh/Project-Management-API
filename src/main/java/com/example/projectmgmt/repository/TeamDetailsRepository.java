package com.example.projectmgmt.repository;

import com.example.projectmgmt.model.TeamDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamDetailsRepository extends JpaRepository<TeamDetails, Long> {

    @Query("select t from TeamDetails t where t.teamName = ?1")
    Optional<TeamDetails> findByTeamName(String teamName);
}
