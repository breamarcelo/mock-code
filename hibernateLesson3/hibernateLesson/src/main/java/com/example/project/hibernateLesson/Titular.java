package com.example.project.hibernateLesson;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Titular")
public class Titular implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Apellidos")
	private String apellidos;
	
	public Titular() {}

	public Titular(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}
