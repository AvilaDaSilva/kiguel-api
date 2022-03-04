package com.kiguel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiguel.entities.TeamEntity;
import com.kiguel.entities.TeamPlayerEntity;

@Repository
public interface TeamPlayerRepository extends JpaRepository<TeamPlayerEntity, Long> {

	List<TeamPlayerEntity> findByTeam(TeamEntity team);
}
