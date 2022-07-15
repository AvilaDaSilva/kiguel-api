package com.kiguel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.kiguel.enums.StatesEnum;

import lombok.Data;

@Data
@Entity
@Table(name="player")
public class PlayerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private int registration;
	
	@Column
	private String photoPath;
	
	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private CityEntity city;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;
}
