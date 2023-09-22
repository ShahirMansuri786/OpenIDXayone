package com.example.sec.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sec.entity.User;

@Repository
public interface LoginRepo extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
}
