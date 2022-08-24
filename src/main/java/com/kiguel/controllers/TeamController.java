package com.kiguel.controllers;

import com.kiguel.entities.TeamEntity;
import com.kiguel.services.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<TeamEntity> getAll() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public TeamEntity getById(@PathVariable Long id) {
        return teamService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<TeamEntity> getByName(@PathVariable String name) {
        return teamService.findByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamEntity save(@RequestBody TeamEntity teamEntity) {
        return teamService.save(teamEntity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TeamEntity update(@PathVariable Long id, @RequestBody TeamEntity team) {
        team.setId(id);
        return teamService.save(team);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteById(id);
    }
}
