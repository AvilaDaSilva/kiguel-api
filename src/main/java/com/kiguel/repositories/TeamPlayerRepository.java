package com.kiguel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kiguel.entities.TeamEntity;
import com.kiguel.entities.TeamPlayerEntity;

@Repository
public interface TeamPlayerRepository extends JpaRepository<TeamPlayerEntity, Long> {

	@Query("SELECT teamPlayer FROM TeamPlayerEntity teamPlayer WHERE teamPlayer.team = :team AND teamPlayer.endDate IS NULL")
	List<TeamPlayerEntity> findActivePlayersByTeam(@Param("team") TeamEntity team);
}
