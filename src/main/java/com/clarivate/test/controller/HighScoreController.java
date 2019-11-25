package com.clarivate.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.test.model.HighScore;
import com.clarivate.test.service.IHighScoreService;

@RestController
public class HighScoreController {

	@Autowired
	IHighScoreService highScoreService;
	
	@GetMapping("/level/{level}/score")
	public ResponseEntity<HighScore> findHighScoreByUserAndLevl(Authentication auth, @PathVariable("level") int level) {
		return ResponseEntity.ok(highScoreService.getHighScoreByUserAndLevel(auth.getName(), level));
	}
	
	@PutMapping("/level/{level}/score/{score}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> putLevelScore(Authentication auth, @PathVariable("level") int level, @PathVariable("score") int score) {
		highScoreService.addOrUpdateHighScore(auth.getName(), level, score);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
