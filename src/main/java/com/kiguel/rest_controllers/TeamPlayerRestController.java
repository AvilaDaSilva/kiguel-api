package com.kiguel.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kiguel.controllers.TeamController;
import com.kiguel.controllers.TeamPlayersController;
import com.kiguel.entities.TeamEntity;
import com.kiguel.entities.TeamPlayerEntity;

@RestController
@RequestMapping("/team-player")
public class TeamPlayerRestController {
	
	@Autowired
	private TeamPlayersController teamPlayersController;
	
	@Autowired
	private TeamController teamController;

	@GetMapping("/team/{idTeam}")
	public List<TeamPlayerEntity> getPlayerByTeam(@PathVariable Long idTeam) {
		
		TeamEntity team = teamController.findById(idTeam);
		List<TeamPlayerEntity> listPlayers = teamPlayersController.findPlayersByTeam(team);
		
//		ResponseEntity<Object> responsePlayerByTeam = ResponseEntity<Object>(TeamPlayerEntity, listPlayers, null, HttpStatus.OK);
		
		return listPlayers;
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public TeamPlayerEntity savePlayerInTeam(@RequestBody TeamPlayerEntity teamPlayer) {
        return teamPlayersController.save(teamPlayer);
    }
}
