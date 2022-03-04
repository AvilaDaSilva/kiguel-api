package com.kiguel.entities;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="teams")
public class TeamEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = true)
	private String crestPath;
	
	@ManyToOne
	@JoinColumn(name = "city", nullable = false)
	private CityEntity city;
	
	@Column(nullable = true)
	private String address;
}
