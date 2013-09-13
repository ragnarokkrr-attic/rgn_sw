package org.ragna.kalin.ch01.team;

import java.util.List;

import teamsC.TeamsService;
import teamsC.Teams;
import teamsC.Team;
import teamsC.Player;

public class TeamClient {

	/**
	 * 
	 * C:\opt\Java\eclipse_jun_jee_ws\ragna_sw\ragna_sw_kalin\target\classes>
	 * wsgen -cp . org.ragna.kalin.ch01.team.Teams -r ..\..\src\main\resources -s ..\..\src\main\java 
	 * 
	 * 
	 * C:\opt\Java\eclipse_jun_jee_ws\ragna_sw\ragna_sw_kalin\target\classes>
	 * wsimport -s ..\..\src\main\java -p teamsC -keep http://localhost:8888/teams?wsdl
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TeamsService service = new TeamsService();
		Teams port = service.getTeamsPort();
		List<Team> teams = port.getTeams();
		
		for (Team team : teams) {
			System.out.println("Team name: "+ team.getName()
					+  " roster count: " + team.getRosterCount());
			
			for (Player player : team.getPlayers()) {
				System.out.println(" Player: " + player.getNickname());
			}
		}
		
	}

}
