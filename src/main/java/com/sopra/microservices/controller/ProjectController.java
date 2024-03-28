package com.sopra.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.microservices.Project;
import com.sopra.microservices.services.Services;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private Services ser;
	
	@GetMapping("/all")
	public ResponseEntity<List<Project>> getAll(){
		
		List<Project> ls=ser.getAll();
		return new ResponseEntity<>(ls,HttpStatus.OK);
	}
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Project> getbyId(@PathVariable("id") int id){
		Project pr=ser.getbyId(id);
		return new ResponseEntity<>(pr,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deletebyId(@PathVariable("id") int id){
		ser.deletebyId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Void> add(@RequestBody Project p){
		ser.addProject(p);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable("id")int id, @RequestBody String name){
		
		Project pr = ser.getbyId(id);
		
		pr.setName(name);
		
		ser.updatebyId(pr);
		
		return new ResponseEntity<String>("Updated", HttpStatus.OK);
	}
	
	
	


}
