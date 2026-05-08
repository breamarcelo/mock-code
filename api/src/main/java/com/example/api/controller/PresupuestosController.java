package com.example.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dto.PresupuestosDTO;
import com.example.api.model.PresupuestosEntity;
import com.example.api.repository.PresupuestosRepository;
import com.example.api.service.PresupuestosService;

@RestController
@CrossOrigin(origins="http://localhost:8100/")
@RequestMapping("/api/presupuestos")
public class PresupuestosController {
    @Autowired
    private PresupuestosRepository repository;
    
    @Autowired
    private PresupuestosService presupuestosService;

    @GetMapping()
    public List<PresupuestosDTO> getAll() {
        List<PresupuestosDTO> dtos = new ArrayList<>();
        repository.findAll().stream().forEach(presupuesto -> {
            dtos.add(presupuestosService.getInstance().toDto(presupuesto));
        });
        return dtos;
    }

    @GetMapping("/{id}")
    public PresupuestosDTO getById(@PathVariable int id) {
        PresupuestosEntity entity = repository.findById(id).get();
        PresupuestosDTO dto = presupuestosService.getInstance().toDto(entity);
        return dto;
    }
}
