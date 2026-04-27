package com.example.libreriaBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libreriaBackend.entity.LoginDTO;
import com.example.libreriaBackend.entity.Usuario;
import com.example.libreriaBackend.repository.UsuarioRepository;
import com.example.libreriaBackend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired 
	private AuthService authService;
    @Autowired 
    private UsuarioRepository repository;
    
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO request) {
        Usuario user = repository.findByEmail(request.getEmail());

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return authService.generateToken(user.getEmail());
        } else {
        	System.out.println("No match");
        }
        throw new RuntimeException("Invalid credentials");
    }
}
