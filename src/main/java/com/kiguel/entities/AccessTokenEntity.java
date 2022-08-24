package com.kiguel.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="access_token")
public class AccessTokenEntity {

    public AccessTokenEntity(){}

	@Id
	private String accessToken;

    public AccessTokenEntity(String token) {
        this.accessToken = token;
    }
}
