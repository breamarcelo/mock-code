package com.example.practicaSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practicaSpringBoot.entity.Cliente;
import com.example.practicaSpringBoot.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> getAll() {
		return repository.findAll();
	}
	
	public Cliente crear(Cliente nuevo) {
		return repository.save(nuevo);
	}
}
