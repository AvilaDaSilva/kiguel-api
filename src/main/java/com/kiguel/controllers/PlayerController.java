package com.kiguel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kiguel.entities.PlayerEntity;
import com.kiguel.repositories.PlayerRepository;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;

	@GetMapping
	public List<PlayerEntity> getAll() {
		return playerRepository.findAll();
	}

	@GetMapping("/{idPlayer}")
	public Optional<PlayerEntity> getById(@PathVariable Long idPlayer) {
		return playerRepository.findById(idPlayer);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlayerEntity save(@RequestBody PlayerEntity player) {
		return playerRepository.save(player);
	}

	@PutMapping("/{idPlayer}")
	@ResponseStatus(HttpStatus.CREATED)
	public PlayerEntity edit(@PathVariable Long idPlayer, @RequestBody PlayerEntity player) {
		player.setId(idPlayer);
		return playerRepository.save(player);
	}
	
	@DeleteMapping("/{idPlayer}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long idPlayer) {
//		PlayerEntity player = playerRepository.getById(idPlayer);
//		playerRepository.delete(player);
	}
}
