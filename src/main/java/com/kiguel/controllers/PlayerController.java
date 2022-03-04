package com.kiguel.controllers;

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

import com.kiguel.entities.PlayerEntity;
import com.kiguel.repositories.PlayerRepository;

@RestController
@RequestMapping("/players")
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;

	@GetMapping
	public List<PlayerEntity> getPlayers() {
		
		try {
			return playerRepository.findAll();
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível retornar a lista de jogadors. \nDetalhes: %s", e);
		}
	}

	@GetMapping("/{idPlayer}")
	public Optional<PlayerEntity> getPlayerById(@PathVariable Long idPlayer) {
		
		try {
			return playerRepository.findById(idPlayer);
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível o jogador solicitado. \nDetalhes: %s", e);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlayerEntity savePlayer(@RequestBody PlayerEntity Player) {
		
		try {
			return playerRepository.save(Player);
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível salvar o novo jogador. \nDetalhes: %s", e);
		}
	}

	@PutMapping("/{idPlayer}")
	@ResponseStatus(HttpStatus.CREATED)
	public PlayerEntity editPlayer(@PathVariable Long idPlayer, @RequestBody PlayerEntity Player) {
		
		try {
			Player.setId(idPlayer);
			return playerRepository.save(Player);
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível editar o jogador. \nDetalhes: %s", e);
		}
	}
	
	@DeleteMapping("/{idPlayer}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePlayer(@PathVariable Long idPlayer) {

		try {
			PlayerEntity player = playerRepository.getById(idPlayer);
			playerRepository.delete(player);
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível remover o jogador. \nDetalhes: %s", e);
		}
	}
}
