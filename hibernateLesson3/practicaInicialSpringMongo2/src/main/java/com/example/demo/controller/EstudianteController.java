package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
	@Autowired
	private EstudianteRepository repository;
	
	@PostMapping
	public void crearEstudiante(@RequestBody Estudiante estudiante) {
		repository.save(estudiante);
	}
	
	@GetMapping
	public List<Estudiante> ontenerEstudiantes(){
		return repository.findAll();
	}
}
