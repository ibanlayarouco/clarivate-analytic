package com.clarivate.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clarivate.test.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 @Query("SELECT h FROM User h WHERE h.username = :user")
	 User getUser(String user);
}
