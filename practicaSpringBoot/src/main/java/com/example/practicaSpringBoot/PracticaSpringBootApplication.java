package com.example.practicaSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.practicaSpringBoot.controller.ClienteController;
import com.example.practicaSpringBoot.entity.Cliente;

@SpringBootApplication
public class PracticaSpringBootApplication implements CommandLineRunner {
	@Autowired
	private ClienteController clienteController;

	public static void main(String[] args) {
		SpringApplication.run(PracticaSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente(null, "Marcelo", "marcelo@mail.com");
		Cliente c2 = new Cliente(null, "Juan", "juan@mail.com");
		
		// clienteController.crear(c1);
		// clienteController.crear(c2);
	}

}
