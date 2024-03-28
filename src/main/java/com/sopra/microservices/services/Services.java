package com.sopra.microservices.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sopra.microservices.Project;

@Service
public interface Services {
	
	public Project addProject(Project p);
	
	public List<Project> getAll();
	
	public Project getbyId(int id);
	
	public void deletebyId(int id);
	
	public String updatebyId(Project pr);

}
