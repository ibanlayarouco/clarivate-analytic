package com.clarivate.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "highscore")
public class HighScore {
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private Long id;	
	private String username;
	private int level;
	private int score;
	
	public HighScore() {
		
	}
	
	public HighScore(String username, int level, int score) {
		this.username = username;
		this.level = level;
		this.score = score;
	}

	@Column(name = "id")
	public Long getID() {
		return this.id;
	}	
	
	@Column(name = "user")
	public String getUser() {
		return username;
	}
	public void setUser(String username) {
		this.username = username;
	}
	
	@Column(name = "level")
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Column(name = "score")
    public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
