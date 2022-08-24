package com.kiguel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiguel.entities.AccessTokenEntity;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessTokenEntity, Long> {

	AccessTokenEntity findByAccessToken(String accessToken);
}
