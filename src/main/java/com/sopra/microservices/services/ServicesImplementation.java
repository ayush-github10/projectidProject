package com.sopra.microservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.microservices.Project;
import com.sopra.microservices.repository.ProjectRepo;

@Service
public class ServicesImplementation implements Services{
	
	@Autowired
	private ProjectRepo repo;

	@Override
	public Project addProject(Project p) {
		return repo.save(p);
	}

	@Override
	public List<Project> getAll() {
		
		return repo.findAll();
	}

	@Override
	public Project getbyId(int id) {
		Optional<Project> proj =repo.findById(id);
		return proj.get();
	}

	@Override
	public void deletebyId(int id) {
		repo.deleteById(id);;
	}

	@Override
    public String updatebyId(Project pr) {
		
		repo.save(pr);
		return "Updated";
	}

}
