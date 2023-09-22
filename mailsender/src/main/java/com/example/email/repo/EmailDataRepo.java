package com.example.email.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.email.entity.GenerateOtp;

@Repository
public interface EmailDataRepo extends JpaRepository<GenerateOtp, Integer> {
	
	

	
}
