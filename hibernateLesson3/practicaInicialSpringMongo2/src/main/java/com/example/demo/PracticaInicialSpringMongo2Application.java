package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;

@SpringBootApplication
public class PracticaInicialSpringMongo2Application implements CommandLineRunner {
	@Autowired
	EstudianteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PracticaInicialSpringMongo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// repository.save(new Estudiante(null, "Marcelo", 39, "DAM"));
		repository.findAll().forEach(System.out::println);
	}

}
