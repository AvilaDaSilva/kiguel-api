package com.kiguel.utils.converters;

import java.util.List;

import com.kiguel.dto.PlayerByTeamDTO;
import com.kiguel.entities.TeamPlayerEntity;

public class TeamPlayerConverter {

	public static PlayerByTeamDTO converter(List<TeamPlayerEntity> teamPlayers) {
		
		if (!teamPlayers.isEmpty()) {

			PlayerByTeamDTO playerByTeam = new PlayerByTeamDTO();
			playerByTeam.setTeam(teamPlayers.get(0).getTeam());
			
			for (TeamPlayerEntity teamPlayer : teamPlayers) {
				
				playerByTeam.getPlayer().add(teamPlayer.getPlayer());
			}
			
			return playerByTeam;
		}
		
		return null;
	}
}
