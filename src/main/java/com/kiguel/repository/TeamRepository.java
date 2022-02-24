package com.kiguel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiguel.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

	List<Team> findByName(String name);
}
