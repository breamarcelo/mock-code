package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="estudiantes")
public class Estudiante {
	@Id
	private String id;
	private String nombre;
	private int edad;
	private String curso;
	public Estudiante() {
		super();
	}
	public Estudiante(String id, String nombre, int edad, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.curso = curso;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", curso=" + curso + "]";
	}
	
}
