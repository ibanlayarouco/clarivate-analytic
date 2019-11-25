package com.clarivate.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clarivate.test.model.HighScore;
import com.clarivate.test.service.IHighScoreService;

@SpringBootTest
public class HighScoreServiceTest {
	@Autowired
	IHighScoreService highScoreService;
	private static String USER1 = "user1"; 
	private static String USER2 = "user2"; 
	private static String USER3 = "user3";
	
	private static int LEVEL1 = 1; 
	private static int LEVEL2 = 2; 

	private static int SCORE10 = 10; 
	private static int SCORE20 = 20; 
	private static int SCORE50 = 50; 
	
	@Test
	public void addOrUpdateHighScore() {
		HighScore score;
		
		highScoreService.addOrUpdateHighScore(USER1, LEVEL1, SCORE20);
		score = highScoreService.getHighScoreByUserAndLevel(USER1, LEVEL1);
		assertEquals(score.getScore(), SCORE20);
		
		highScoreService.addOrUpdateHighScore(USER1, LEVEL1, SCORE50);
		score = highScoreService.getHighScoreByUserAndLevel(USER1, LEVEL1);
		assertEquals(score.getScore(), SCORE50);

		highScoreService.addOrUpdateHighScore(USER1, LEVEL1, SCORE20);
		score = highScoreService.getHighScoreByUserAndLevel(USER1, LEVEL1);
		assertEquals(score.getScore(), SCORE50);
	
		highScoreService.addOrUpdateHighScore(USER1, LEVEL1, SCORE10);
		score = highScoreService.getHighScoreByUserAndLevel(USER1, LEVEL1);
		assertEquals(score.getScore(), SCORE50);

		highScoreService.addOrUpdateHighScore(USER2, LEVEL2, SCORE20);
		score = highScoreService.getHighScoreByUserAndLevel(USER2, LEVEL2);
		assertEquals(score.getScore(), SCORE20);
	
		highScoreService.addOrUpdateHighScore(USER2, LEVEL1, SCORE10);
		score = highScoreService.getHighScoreByUserAndLevel(USER2, LEVEL1);
		assertEquals(score.getScore(), SCORE10);

		highScoreService.addOrUpdateHighScore(USER2, LEVEL2, SCORE10);
		score = highScoreService.getHighScoreByUserAndLevel(USER2, LEVEL2);
		assertEquals(score.getScore(), SCORE20);
	
		highScoreService.addOrUpdateHighScore(USER2, LEVEL1, SCORE50);
		score = highScoreService.getHighScoreByUserAndLevel(USER2, LEVEL1);
		assertEquals(score.getScore(), SCORE50);

		highScoreService.addOrUpdateHighScore(USER3, LEVEL1, SCORE10);
		score = highScoreService.getHighScoreByUserAndLevel(USER3, LEVEL1);
		assertEquals(score.getScore(), SCORE10);
		
		highScoreService.addOrUpdateHighScore(USER3, LEVEL1, SCORE20);
		score = highScoreService.getHighScoreByUserAndLevel(USER3, LEVEL1);
		assertEquals(score.getScore(), SCORE20);

		highScoreService.addOrUpdateHighScore(USER3, LEVEL1, SCORE50);
		score = highScoreService.getHighScoreByUserAndLevel(USER3, LEVEL1);
		assertEquals(score.getScore(), SCORE50);
	
	}
}
