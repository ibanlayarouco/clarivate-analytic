package com.clarivate.test.repository;
import com.clarivate.test.model.HighScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HighScoreRepository extends JpaRepository<HighScore, Long> {
	 @Query("SELECT h FROM HighScore h WHERE h.username = :user AND h.level = :level")
	 HighScore findByUserAndLevel(String user, int level);
}
