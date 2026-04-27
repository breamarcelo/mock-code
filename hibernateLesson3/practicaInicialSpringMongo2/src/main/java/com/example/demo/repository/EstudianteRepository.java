package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.example.demo.model.Estudiante;


public interface EstudianteRepository extends MongoRepository<Estudiante, String>{
	List<Estudiante> findByCurso(String curso);
	List<Estudiante> findByEdadGreaterThan(int edad);
}
