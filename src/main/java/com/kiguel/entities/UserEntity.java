package com.kiguel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kiguel.enums.UserRolesEnum;

import lombok.Data;

@Data
@Entity
@Table(name="user_auth")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;

	private UserRolesEnum role;

	@Column(nullable = false)
	private String fullName;
}
