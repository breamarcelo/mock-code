package com.example.libreriaBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.libreriaBackend.entity.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{

}
