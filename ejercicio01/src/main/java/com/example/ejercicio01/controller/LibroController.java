package com.example.ejercicio01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejercicio01.model.Libro;
import com.example.ejercicio01.repository.LibroRepository;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "http://localhost:4200") 
public class LibroController {
	@Autowired
	private LibroRepository libroRepository;
	
	@GetMapping("/")
	public List<Libro> listarTodos() {
		return libroRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Libro> buscarPorId(@PathVariable Long id) {
		return libroRepository.findById(id);
	}
	
	@PostMapping("/")
	public void guardarLibro(Libro libro) {
		libroRepository.save(libro);
	}
	
	@PutMapping("/{id}")
	public void actualizarLibro(Long id, Libro libro) {
		if(libroRepository.existsById(id)) {
			libroRepository.save(libro);
		}
	}
	
	@DeleteMapping("/{id}")
	public void eliminarLinbro(Long id) {
		libroRepository.deleteById(id);
	}
}
