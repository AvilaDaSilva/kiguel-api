package com.kiguel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiguel.entities.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

	List<TeamEntity> findByName(String name);
}
