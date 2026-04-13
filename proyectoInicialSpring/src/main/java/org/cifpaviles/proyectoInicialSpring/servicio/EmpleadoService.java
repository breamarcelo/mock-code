package org.cifpaviles.proyectoInicialSpring.servicio;

import org.cifpaviles.proyectoInicialSpring.entidad.Empleado;
import org.cifpaviles.proyectoInicialSpring.repositorio.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	public void save(Empleado empleado) {
		empleadoRepository.save(empleado);
	}
}
