package com.kiguel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiguel.services.TeamPlayerService;
import com.kiguel.dto.PlayerByTeamDTO;
import com.kiguel.entities.TeamEntity;
import com.kiguel.entities.TeamPlayerEntity;
import com.kiguel.utils.converters.TeamPlayerConverter;
import com.kiguel.repositories.TeamPlayerRepository;

@Service
public class TeamPlayerService {

	@Autowired
	private TeamPlayerRepository teamPlayerRepository;
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	TeamPlayerService teamPlayersService;

	public PlayerByTeamDTO findActivePlayersByTeam(Long teamId) {
		
		List<TeamPlayerEntity> listTeamPlayers = teamPlayersService.findActivePlayersByTeam(teamService.findById(teamId));
		return TeamPlayerConverter.converter(listTeamPlayers);
	}
	
	public TeamPlayerEntity save(TeamPlayerEntity teamPlayerEntity) {
        return teamPlayerRepository.save(teamPlayerEntity);
    }
    
	public List<TeamPlayerEntity> findActivePlayersByTeam(TeamEntity team) {
		return teamPlayerRepository.findActivePlayersByTeam(team);
	}
}
