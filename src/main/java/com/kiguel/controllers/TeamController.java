package com.kiguel.controllers;

import com.kiguel.entities.TeamEntity;
import com.kiguel.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    public TeamEntity save(TeamEntity teamEntity) {
        return teamRepository.save(teamEntity);
    }

    public TeamEntity update(TeamEntity teamEntity) {
        return teamRepository.save(teamEntity);
    }

    public TeamEntity findById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public List<TeamEntity> findByName(String name) {
        return teamRepository.findByName(name);
    }

    public List<TeamEntity> findAll() {
        return teamRepository.findAll();
    }

    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }
}
