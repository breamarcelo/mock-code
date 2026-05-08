package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.PresupuestosEntity;
import com.example.api.repository.PresupuestosRepository;

@RestController
@RequestMapping("/api/presupuestos")
public class PresupuestosController {
    @Autowired
    private PresupuestosRepository repository;

    @GetMapping
    public List<PresupuestosEntity> getAll() {
        return repository.findAll();
    }
}
