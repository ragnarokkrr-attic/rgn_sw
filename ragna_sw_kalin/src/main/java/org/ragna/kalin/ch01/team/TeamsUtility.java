package org.ragna.kalin.ch01.team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamsUtility {
	private Map<String, Team> team_map;

	public TeamsUtility() {
		this.team_map = new HashMap<String, Team>();
	}

	public Team getTeam(String name) {
		return this.team_map.get(name);
	}

	public List<Team> getTeams() {
		return new ArrayList<Team>(team_map.values());
	}

	public void make_test_teams() {
		List<Team> teams = new ArrayList<Team>();
		Player chico = new Player("Leonard Marx", "Chico");
		Player groucho = new Player("Julius Marx", "Groucho");
		Player harpo = new Player("Adolph Marx", "Harpo");
		List<Player> mb = new ArrayList<Player>();
		mb.add(chico);
		mb.add(groucho);
		mb.add(harpo);
		Team marx_brothers = new Team("Marx Brothers", mb);
		teams.add(marx_brothers);
		store_teams(teams);
	}

	private void store_teams(List<Team> teams) {
		for (Team team : teams)
			team_map.put(team.getName(), team);
	}

}
