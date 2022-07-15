package com.kiguel.rest_controllers;

import com.kiguel.controllers.TeamController;
import com.kiguel.entities.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamRestController {

    @Autowired
    private TeamController teamController;

    @GetMapping
    public List<TeamEntity> getAll() {
        return teamController.findAll();
    }

    @GetMapping("/{id}")
    public TeamEntity getById(@PathVariable Long id) {
        return teamController.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<TeamEntity> getByName(@PathVariable String name) {
        return teamController.findByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamEntity save(@RequestBody TeamEntity teamEntity) {
        return teamController.save(teamEntity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TeamEntity update(@PathVariable Long id, @RequestBody TeamEntity team) {
        team.setId(id);
        return teamController.save(team);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeam(@PathVariable Long id) {
        teamController.deleteById(id);
    }
}
