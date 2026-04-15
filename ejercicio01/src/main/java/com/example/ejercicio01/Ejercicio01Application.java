package com.example.ejercicio01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ejercicio01.model.Libro;
import com.example.ejercicio01.repository.LibroRepository;

@SpringBootApplication
public class Ejercicio01Application implements CommandLineRunner{
	@Autowired
	private LibroRepository libroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Ejercicio01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Libro libro1 = new Libro(null, "El Quijote", "Miguel de Cervantes Saavedra", "ISBN-13: 9788467585995", 2016);
		// Libro libro2 = new Libro(null, "La Vida Es Sueño", "Pedro Calderón de La Barca", "ISBN-13: 9798729605941", 2021);
		// Libro libro3 = new Libro(null, "La Divina Comedia", "Dante Alighieri", "ISBN-13: 9781518711374", 2015);
		// libroRepository.save(libro1);
		// libroRepository.save(libro2);
		// libroRepository.save(libro3);
	}

}
