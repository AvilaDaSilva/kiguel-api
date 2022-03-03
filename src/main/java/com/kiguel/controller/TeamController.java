package com.kiguel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kiguel.model.Team;
import com.kiguel.repository.TeamRepository;

@RestController
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;

	@GetMapping
	public List<Team> getTeams() {
		
		try {
			return teamRepository.findAll();
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível retornar a lista de times. \nDetalhes: %s", e);
		}
	}

	@GetMapping("/{idTeam}")
	public Optional<Team> getTeamById(@PathVariable Long idTeam) {
		
		try {
			return teamRepository.findById(idTeam);
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível o time solicitado. \nDetalhes: %s", e);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Team saveTeam(@RequestBody Team team) {
		
		try {
			return teamRepository.save(team);
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível salvar o novo time. \nDetalhes: %s", e);
		}
	}

	@PutMapping("/{idTeam}")
	@ResponseStatus(HttpStatus.CREATED)
	public Team editTeam(@PathVariable Long idTeam, @RequestBody Team team) {
		
		try {
			team.setId(idTeam);
			return teamRepository.save(team);
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível editar o time. \nDetalhes: %s", e);
		}
	}
	
	@DeleteMapping("/{idTeam}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTeam(@PathVariable Long idTeam) {

		try {
			Team team = teamRepository.getById(idTeam);
			teamRepository.delete(team);
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível remover o time. \nDetalhes: %s", e);
		}
	}
}
