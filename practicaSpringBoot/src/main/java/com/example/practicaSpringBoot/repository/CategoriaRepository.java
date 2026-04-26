package com.example.practicaSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practicaSpringBoot.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
