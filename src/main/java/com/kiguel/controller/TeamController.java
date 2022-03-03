package com.kiguel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kiguel.model.Player;
import com.kiguel.model.Team;
import com.kiguel.repository.TeamRepository;

@RestController
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;

	@GetMapping
	public List<Team> getRecords() {
		
		return teamRepository.findAll();
	}
	
//	@GetMapping("/{name}")
//	public List<Team> getRecords(@PathVariable String name) {
//		
//		return teamRepository.findByName(name);
//	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Team saveRecord(@RequestBody Team team) {
		
//		ResponseEntity<Team> responseEntityTeam = new ResponseEntity<Team>(HttpStatus.CREATED);
//		responseEntityTeam.
		return teamRepository.save(team);
	}
	
	@PutMapping("/{idTeam}")
	@ResponseStatus(HttpStatus.CREATED)
	public Team editRecord(@PathVariable Long idTeam, @RequestBody Team team) {
		
//		ResponseEntity<Team> responseEntityTeam = new ResponseEntity<Team>(HttpStatus.CREATED);
//		responseEntityTeam.
		team.setId(idTeam);
		return teamRepository.save(team);
	}
	
	
}
