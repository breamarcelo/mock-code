package com.example.libreriaBackend.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libreriaBackend.entity.Usuario;
import com.example.libreriaBackend.repository.UsuarioRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class AuthService {
	private final String SECRET_KEY = "9d8e45c94865044b66e02f7d8e37ee0ae425c0baf02cee774142b7a8caaa8dee";

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email) // No longer .setSubject()
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSigningKey()) // Algorithm is inferred from the key type
                .compact();
    }

    public String extractEmail(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey()) // Replaces setSigningKey()
                .build()
                .parseSignedClaims(token)    // Replaces parseClaimsJws()
                .getPayload()                // Replaces getBody()
                .getSubject();
    }
}
