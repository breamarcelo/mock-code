package org.cifpaviles.proyectoInicialSpring.controller;

import java.util.Optional;

import org.cifpaviles.proyectoInicialSpring.entidad.Empleado;
import org.cifpaviles.proyectoInicialSpring.repositorio.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@GetMapping("/{id}")
	public Optional<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
		return empleadoRepository.findById(id);
	}
}
