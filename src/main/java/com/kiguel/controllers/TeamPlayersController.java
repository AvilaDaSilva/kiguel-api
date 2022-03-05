package com.kiguel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kiguel.entities.TeamEntity;
import com.kiguel.entities.TeamPlayerEntity;
import com.kiguel.repositories.TeamPlayerRepository;

@Controller
public class TeamPlayersController {

	@Autowired
	private TeamPlayerRepository teamPlayerRepository;

    public TeamPlayerEntity save(TeamPlayerEntity teamPlayerEntity) {
        return teamPlayerRepository.save(teamPlayerEntity);
    }
    
	public List<TeamPlayerEntity> findActivePlayersByTeam(TeamEntity team) {
		return teamPlayerRepository.findActivePlayersByTeam(team);
	}
}
