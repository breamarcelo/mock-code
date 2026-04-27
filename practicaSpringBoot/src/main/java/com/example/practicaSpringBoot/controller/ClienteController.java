package com.example.practicaSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practicaSpringBoot.entity.Cliente;
import com.example.practicaSpringBoot.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping("/")
	public List<Cliente> getAll() {
		return repository.findAll();
	}
	
	@PostMapping("/")
	public Cliente crear(@RequestBody Cliente nuevo) {
		return repository.save(nuevo);
	}
}
