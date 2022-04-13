package me.egaetan.redblue;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RedBlueEntity {

	@Id	
	String team;
	int score;
	
	public RedBlueEntity() {
	}
	
	public RedBlueEntity(String team, int score) {
		super();
		this.team = team;
		this.score = score;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


}
