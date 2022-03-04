package com.kiguel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiguel.entities.PlayerEntity;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

}
