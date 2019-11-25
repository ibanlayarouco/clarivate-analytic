package com.clarivate.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarivate.test.model.HighScore;
import com.clarivate.test.repository.HighScoreRepository;

@Service
public class HighScoreService implements IHighScoreService {
    
	@Autowired
    private HighScoreRepository repository;

	public void addOrUpdateHighScore(String user, int level, int score) {
		HighScore highScore = repository.findByUserAndLevel(user, level);
		if (highScore != null) {
			if(highScore.getScore() < score)
				highScore.setScore(score);
		} else {
			highScore = new HighScore(user, level, score);			
		}
		repository.save(highScore);
	}	
	
	@Override
	public HighScore getHighScoreByUserAndLevel(String user, int level) {
		return repository.findByUserAndLevel(user, level);
	}
	


}
