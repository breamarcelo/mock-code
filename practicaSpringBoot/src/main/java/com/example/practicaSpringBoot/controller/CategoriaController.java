package com.example.practicaSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.practicaSpringBoot.entity.Categoria;
import com.example.practicaSpringBoot.service.CategoriaService;

@Controller
@RequestMapping("/api/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService service;
	
	@GetMapping("/")
	public List<Categoria> getAll(){
		return service.getAll();
	}
}
