package com.kiguel.dto;

import java.util.ArrayList;
import java.util.List;

import com.kiguel.entities.PlayerEntity;
import com.kiguel.entities.TeamEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerByTeamDTO {

	private TeamEntity team;
	private List<PlayerEntity> player = new ArrayList<>();
}
