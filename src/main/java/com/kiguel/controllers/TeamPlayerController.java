package com.kiguel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kiguel.services.TeamPlayerService;
import com.kiguel.dto.PlayerByTeamDTO;
import com.kiguel.entities.TeamPlayerEntity;

@RestController
@RequestMapping("/api/team-player")
public class TeamPlayerController {
	
	@Autowired
	private TeamPlayerService teamPlayersService;
	
	@Autowired
	private TeamPlayerService service;

	@GetMapping("/team/{idTeam}")
	public PlayerByTeamDTO getPlayerByTeam(@PathVariable Long idTeam) {
		return service.findActivePlayersByTeam(idTeam);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public TeamPlayerEntity savePlayerInTeam(@RequestBody TeamPlayerEntity teamPlayer) {
        return teamPlayersService.save(teamPlayer);
    }
}
