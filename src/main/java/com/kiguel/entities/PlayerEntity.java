package com.kiguel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="players")
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
	
	@Column(nullable = false)
	private StatesEntity state;
}
