package com.sopra.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.microservices.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
	
	

}
