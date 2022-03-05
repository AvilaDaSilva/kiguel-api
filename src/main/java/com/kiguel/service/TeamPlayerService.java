package com.kiguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiguel.controllers.TeamController;
import com.kiguel.controllers.TeamPlayersController;
import com.kiguel.dto.PlayerByTeamDTO;
import com.kiguel.entities.TeamPlayerEntity;
import com.kiguel.utils.converters.TeamPlayerConverter;

@Service
public class TeamPlayerService {
	
	@Autowired
	TeamController teamController;
	
	@Autowired
	TeamPlayersController teamPlayersController;

	public PlayerByTeamDTO findActivePlayersByTeam(Long teamId) {
		
		List<TeamPlayerEntity> listTeamPlayers = teamPlayersController.findActivePlayersByTeam(teamController.findById(teamId));
		return TeamPlayerConverter.converter(listTeamPlayers);
	}
}
