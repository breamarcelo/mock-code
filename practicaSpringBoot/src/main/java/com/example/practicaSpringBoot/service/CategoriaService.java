package com.example.practicaSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practicaSpringBoot.entity.Categoria;
import com.example.practicaSpringBoot.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> getAll() {
		return repository.findAll();
	}
}
