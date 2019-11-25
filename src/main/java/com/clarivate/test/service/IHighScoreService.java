package com.clarivate.test.service;

import com.clarivate.test.model.HighScore;

public interface IHighScoreService {
	public void addOrUpdateHighScore(String user, int level, int score);
	public HighScore getHighScoreByUserAndLevel(String user, int level);
}
