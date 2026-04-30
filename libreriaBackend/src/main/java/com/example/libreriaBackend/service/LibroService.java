package com.example.libreriaBackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libreriaBackend.entity.Libro;
import com.example.libreriaBackend.repository.LibroRepository;

@Service
public class LibroService {
	@Autowired
	private LibroRepository repository;

	public List<Libro> findAll() {
		return repository.findAll();
	}

	public Optional<Libro> findById(Long id) {
		return repository.findById(id);
	}

	public Libro save(Libro libro) {
		return repository.save(libro);
	}

	public Libro update(Long id, Libro libro) {
		if(repository.existsById(id)) {
			return repository.save(libro);
		}
		return null;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
