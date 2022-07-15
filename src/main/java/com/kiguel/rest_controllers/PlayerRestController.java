package com.kiguel.rest_controllers;

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

import com.kiguel.controllers.PlayerController;
import com.kiguel.entities.PlayerEntity;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {
	
	@Autowired
	private PlayerController playerController;

	@GetMapping
	public List<PlayerEntity> getAll() {
		return playerController.getAll();
	}

	@GetMapping("/{idPlayer}")
	public Optional<PlayerEntity> getById(@PathVariable Long idPlayer) {
		return playerController.getById(idPlayer);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlayerEntity save(@RequestBody PlayerEntity player) {
		return playerController.save(player);
	}

	@PutMapping("/{idPlayer}")
	@ResponseStatus(HttpStatus.CREATED)
	public PlayerEntity edit(@PathVariable Long idPlayer, @RequestBody PlayerEntity player) {
		player.setId(idPlayer);
		return playerController.save(player);
	}
	
	@DeleteMapping("/{idPlayer}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long idPlayer) {
//		PlayerEntity player = playerController.getById(idPlayer);
//		playerController.delete(player);
	}
}
