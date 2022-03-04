package com.kiguel.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="team_players")
public class TeamPlayerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "team", nullable = false)
	private TeamEntity team;
	
	@OneToOne
	@JoinColumn(name = "player", nullable = false)
	private PlayerEntity player;
	
	@Column(nullable = true)
	private Date startDate;
	
	@Column(nullable = true)
	private Date endDate;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean isCaptain;

	@Column(columnDefinition = "boolean default false")
	private Boolean isCoach;
}
