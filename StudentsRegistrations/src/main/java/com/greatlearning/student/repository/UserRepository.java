package com.greatlearning.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.student.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User getUserByUsername(String username);
}
