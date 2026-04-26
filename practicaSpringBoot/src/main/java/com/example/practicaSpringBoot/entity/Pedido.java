package com.example.practicaSpringBoot.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TPedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate fecha;
	@ManyToOne
	@JoinColumn(name="fk_cliente")
	private Cliente cliente;
	@ManyToMany
	@JoinTable(name="TPedidos_Productos",
	joinColumns=@JoinColumn(name="fk_pedido"),
	inverseJoinColumns=@JoinColumn(name="fk_producto"))
	private List<Producto> productos;
	public Pedido() {
		super();
	}
	public Pedido(Long id, LocalDate fecha, Cliente cliente, List<Producto> productos) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
		this.productos = productos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
