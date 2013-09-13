package org.ragna.kalin.ch01.team;

public class Player {
	private String name;
	private String nickname;

	public Player(String name, String nickname) {
		super();
		this.name = name;
		this.nickname = nickname;
	}

	public Player() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", nickname=" + nickname + "]";
	}

}
