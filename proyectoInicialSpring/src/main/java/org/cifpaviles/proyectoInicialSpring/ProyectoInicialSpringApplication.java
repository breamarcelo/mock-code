package org.cifpaviles.proyectoInicialSpring;

import org.cifpaviles.proyectoInicialSpring.entidad.Empleado;
import org.cifpaviles.proyectoInicialSpring.repositorio.EmpleadoRepository;
import org.cifpaviles.proyectoInicialSpring.servicio.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoInicialSpringApplication implements CommandLineRunner{
	@Autowired
	private EmpleadoService empleadoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoInicialSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//Empleado empleado = new Empleado(0, "Pepe");
		// empleadoService.save(empleado);
		// empleadoRepository.save(empleado);
	}

}
